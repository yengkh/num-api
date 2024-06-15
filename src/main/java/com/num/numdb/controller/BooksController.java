package com.num.numdb.controller;

import com.num.numdb.entity.book.BooksEntity;
import com.num.numdb.entity.book.BooksEntityDTO;
import com.num.numdb.entity.professional.ProfessionalLogin;
import com.num.numdb.entity.professional.ProfessionalLoginDTO;
import com.num.numdb.repository.BooksRepository;
import com.num.numdb.repository.ProfessionalLoginRepository;
import com.num.numdb.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/num-api")
@CrossOrigin("*")
public class BooksController {
    private final BooksService booksService;
    private final BooksRepository booksRepository;
    private final ProfessionalLoginRepository professionalLoginRepository;

    @Autowired
    public BooksController(
            BooksService booksService,
            BooksRepository booksRepository,
            ProfessionalLoginRepository professionalLoginRepository
    ) {
        this.booksService = booksService;
        this.booksRepository = booksRepository;
        this.professionalLoginRepository = professionalLoginRepository;
    }

    // Add book
    @PostMapping("/add-books")
    public BooksEntity saveBooks(
            BooksEntityDTO booksEntityDTO
    ) throws IOException {
        BooksEntity save = booksService.saveBook(booksEntityDTO);

        return booksRepository.save(save);
    }

    // Get book
    @GetMapping("/get")
    public List<BooksEntity> getBooks(){
        return booksRepository.findAll();
    }

    @PostMapping("/post-prof")
    public ProfessionalLogin postProf(
           @ModelAttribute
           ProfessionalLoginDTO professionalLoginDTO
    ){
        ProfessionalLogin professionalLogin = new ProfessionalLogin();
        professionalLogin.setName(professionalLoginDTO.getName());
        professionalLogin.setPasswd(professionalLoginDTO.getPasswd());

        return professionalLoginRepository.save(professionalLogin);
    }

    @GetMapping("/get-prof")
    public List<ProfessionalLogin> getProf(){
        return professionalLoginRepository.findAll();
    }
}
