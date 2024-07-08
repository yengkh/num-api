package com.num.numdb.controller;
import com.num.numdb.entity.professional.ProfessionalLogin;
import com.num.numdb.service.ProfessionalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prof-api")
public class ProfessionalController {
    private final ProfessionalService professionalService;
    public ProfessionalController(
            ProfessionalService professionalService
    ) {
        this.professionalService = professionalService;
    }
    // Add Teacher
    @PostMapping("/add-teacher")
    public ProfessionalLogin addTeacher(
            @RequestBody
            ProfessionalLogin professionalLogin
    ){
        return professionalService.addTeacher(professionalLogin);
    }
    // Get Teacher
    @GetMapping("/get-teacher/{name}")
    public ProfessionalLogin getTeacher(
            @PathVariable
            String name
    ){
        return professionalService.findByName(name);
    }
    // Update Teacher
    @PutMapping("/update-teacher")
    public ProfessionalLogin updateTeacher(
            @PathVariable
            Integer id,
            @RequestBody
            ProfessionalLogin professionalLogin
    ){
        return professionalService.updateTeacher(id, professionalLogin);
    }
    // Delete teacher
    @DeleteMapping("/delete-teacher/{id}")
    public String deleteStudent(
            @PathVariable
            Integer id
    ){
        professionalService.deleteTeacherById(id);
        return "Teacher with ID : " + id + " deleted successfully.";
    }
}
