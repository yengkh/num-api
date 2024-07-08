package com.num.numdb.repository;

import com.num.numdb.entity.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    Optional<StudentEntity> findByStuEmailAndStuPasswordAndSchoolId(String stuEmail, String stuPassword, String schoolId);
    Optional<StudentEntity> findByStuEmail(String stuEmail);

    StudentEntity findStudentByStuEmail(String stuEmail);
}
