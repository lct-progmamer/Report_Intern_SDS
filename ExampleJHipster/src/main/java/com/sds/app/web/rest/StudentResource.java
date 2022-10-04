package com.sds.app.web.rest;

import com.sds.app.domain.Student;
import com.sds.app.params.SearchAndFilter;
import com.sds.app.service.IStudentService;
import com.sds.app.service.dto.AdminUserDTO;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;

@RestController
@RequestMapping(value = "/api/students")
@CrossOrigin("*")
public class StudentResource {

    private IStudentService service;

    public StudentResource(IStudentService service) {
        this.service = service;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll(Pageable pageable, SearchAndFilter filter) {
        Page<Student> students = service.getAllStudents(pageable, filter);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/msv/{masv}")
    public ResponseEntity<?> getByMaSv(@PathVariable("masv") int masv) {
        Student student = service.getById(masv);
        if (student == null) return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name) {
        Student student = service.getByName(name);
        if (student == null) return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createNewStudent(@RequestBody Student student) {
        Student std = service.createNewStudent(student);
        if (std == null) return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{msv}")
    public ResponseEntity<?> updateStudent(@PathVariable("msv") int msv, @RequestBody Student student) {
        if (service.existsByMaSv(msv)) {
            student.setMaSv(msv);
            Student std = service.updateStudent(student);
            if (std == null) return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{msv}")
    public ResponseEntity<?> updateStudent(@PathVariable("msv") int msv) {
        if (service.existsByMaSv(msv)) {
            service.deleteById(msv);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/deleteMul/{ids}")
    public ResponseEntity<?> updateListStudent(@PathVariable(name = "ids") List<Integer> ids) {
        service.deleteMulByMsv(ids);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
