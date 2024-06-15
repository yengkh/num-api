package com.num.numdb.service;

import com.num.numdb.entity.professional.ProfessionalLogin;
import com.num.numdb.repository.ProfessionalLoginRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {
    private final ProfessionalLoginRepository professionalLoginRepository;

    public ProfessionalService(
            ProfessionalLoginRepository professionalLoginRepository
    ) {
        this.professionalLoginRepository = professionalLoginRepository;
    }

    // Add Teacher
    public ProfessionalLogin addTeacher(
            ProfessionalLogin professionalLogin
    ){
        return  professionalLoginRepository.save(professionalLogin);
    }

    public ProfessionalLogin findByName(String name) {
        return professionalLoginRepository.findByName(name);
    }

    public ProfessionalLogin updateTeacher(
            Integer id,
            ProfessionalLogin professionalLogin
    ) {
        return professionalLoginRepository.save(professionalLogin);
    }

    public void deleteTeacherById(Integer id) {
        professionalLoginRepository.deleteById(id);
    }
}
