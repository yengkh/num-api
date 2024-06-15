package com.num.numdb.repository;

import com.num.numdb.entity.professional.ProfessionalLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalLoginRepository extends JpaRepository<ProfessionalLogin, Integer> {
    ProfessionalLogin findByName(String name);
}
