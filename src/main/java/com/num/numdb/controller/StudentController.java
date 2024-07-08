package com.num.numdb.controller;

import com.num.numdb.entity.student.StudentDTO;
import com.num.numdb.entity.student.StudentLogInDTO;
import com.num.numdb.respone.LoginResponse;
import com.num.numdb.responemessage.LoginMessage;
import com.num.numdb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDTO studentDTO) {
        String studentName = studentService.saveStudent(studentDTO);
        return ResponseEntity.ok("Student " + studentName + " registered successfully");
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> studentLogin(
            @RequestBody
            StudentLogInDTO studentLogInDTO
    ){
        LoginResponse loginResponse = studentService.loginStudent(studentLogInDTO);

        return ResponseEntity.ok(loginResponse);
    }


}
