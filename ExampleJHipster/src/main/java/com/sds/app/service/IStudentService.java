package com.sds.app.service;

import com.sds.app.domain.Student;
import com.sds.app.params.SearchAndFilter;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    Page<Student> getAllStudents(Pageable pageable, SearchAndFilter param);

    Student getById(int masv);

    Student getByName(String name);

    Student createNewStudent(Student student);

    Student updateStudent(Student student);

    void deleteById(int msv);

    boolean existsByMaSv(int maSv);

    void deleteMulByMsv(List<Integer> ids);
}
