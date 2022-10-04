package com.sds.app.repository;

import com.sds.app.domain.Student;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
    Student findByMaSv(int masv);
    Student findByName(String name);

    @Transactional
    void deleteByMaSvIn(List<Integer> ids);
}
