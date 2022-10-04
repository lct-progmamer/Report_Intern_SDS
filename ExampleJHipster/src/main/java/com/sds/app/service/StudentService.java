package com.sds.app.service;

import com.sds.app.domain.Student;
import com.sds.app.params.SearchAndFilter;
import com.sds.app.repository.IStudentRepository;
import com.sds.app.specification.StudentSpecification;
import com.sds.app.specification.StudentSpecificationBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    private IStudentRepository repository;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable, SearchAndFilter param) {
        StudentSpecificationBuilder builder = new StudentSpecificationBuilder(param);
        Specification<Student> where = builder.build();
        return repository.findAll(where, pageable);
    }

    @Override
    public Student getById(int masv) {
        return repository.findByMaSv(masv);
    }

    @Override
    public Student getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Student createNewStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteById(int msv) {
        repository.deleteById(msv);
    }

    @Override
    public boolean existsByMaSv(int maSv) {
        return repository.existsById(maSv);
    }

    @Override
    public void deleteMulByMsv(List ids) {
        repository.deleteByMaSvIn(ids);
    }
}
