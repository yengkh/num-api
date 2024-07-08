package com.num.numdb.service;

import com.num.numdb.entity.student.StudentDTO;
import com.num.numdb.entity.student.StudentEntity;
import com.num.numdb.entity.student.StudentLogInDTO;
import com.num.numdb.repository.StudentRepository;
import com.num.numdb.respone.LoginResponse;
import com.num.numdb.responemessage.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentService {
    Date time = new Date();
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentService(
            StudentRepository studentRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Add New Student
    public String saveStudent(StudentDTO studentDTO) {
        if (studentRepository.findByStuEmail(studentDTO.getStuEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered");
        }

        StudentEntity student = new StudentEntity();
        student.setStuName(studentDTO.getStuName());
        student.setStuEmail(studentDTO.getStuEmail());
        student.setStuPassword(passwordEncoder.encode(studentDTO.getStuPassword()));
        student.setSchoolId(studentDTO.getSchoolId());

        studentRepository.save(student);
        return student.getStuName();
    }

    // Update Existing Student
    public String updateStudent(Integer id, StudentDTO studentDTO) {

        Optional<StudentEntity> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            StudentEntity student = existingStudent.get();
            student.setSchoolId(studentDTO.getSchoolId());
            student.setStuEmail(studentDTO.getStuEmail());
            student.setStuName(studentDTO.getStuName());
            if (!studentDTO.getStuPassword().isEmpty()) {
                student.setStuPassword(this.passwordEncoder.encode(studentDTO.getStuPassword()));
            }
            studentRepository.save(student);
            return "Student with ID : " + id + " updated successfully!" + time;
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    public LoginResponse loginStudent(StudentLogInDTO studentLogInDTO) {
        StudentEntity studentEntity = studentRepository.findStudentByStuEmail(studentLogInDTO.getStuEmail());
        if (studentEntity == null) {
            return new LoginResponse("Email not exists", false);
        }

        boolean isPwdRight = passwordEncoder.matches(studentLogInDTO.getStuPassword(), studentEntity.getStuPassword());
        if (!isPwdRight) {
            return new LoginResponse("Password does not match", false);
        }

        if (!studentEntity.getSchoolId().equals(studentLogInDTO.getSchoolId())) {
            return new LoginResponse("School ID does not match", false);
        }

        return new LoginResponse("Login Success" + time, true);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
