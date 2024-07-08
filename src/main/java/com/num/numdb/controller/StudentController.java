package com.num.numdb.controller;

import com.num.numdb.entity.student.StudentDTO;
import com.num.numdb.entity.student.StudentLogInDTO;
import com.num.numdb.respone.LoginResponse;
import com.num.numdb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    Date time = new Date();
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDTO studentDTO) {
        String studentName = studentService.saveStudent(studentDTO);
        return ResponseEntity.ok("Student " + studentName + " registered successfully! " + time);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> studentLogin(
            @RequestBody
            StudentLogInDTO studentLogInDTO
    ){
        LoginResponse loginResponse = studentService.loginStudent(studentLogInDTO);

        return ResponseEntity.ok(loginResponse);
    }

    @PutMapping(path = "/update-student/{id}")
    public String updateStudent(
            @PathVariable Integer id,
            @RequestBody StudentDTO studentDTO
    ){
        return  studentService.updateStudent(id, studentDTO);
    }

    @DeleteMapping(path = "/delete-student/{id}")
    public String deleteStudent(
            @PathVariable Integer id
    ){
        studentService.deleteStudent(id);
        return  "Student with ID :" + id + " deleted successfully! " + time;
    }


}
