package com.num.numdb.controller;

import com.num.numdb.entity.book.BooksEntity;
import com.num.numdb.entity.book.BooksEntityDTO;
import com.num.numdb.entity.professional.ProfessionalLogin;
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

    // Update book
    @PutMapping("/update-book/{id}")
    public BooksEntity updateBook(
            @PathVariable Integer id,
            BooksEntityDTO booksEntityDTO
    ) throws IOException {
        BooksEntity save = booksService.updateBook(id, booksEntityDTO);

        return booksRepository.save(save);
    }

    // Delete book
    @DeleteMapping("/delete-book/{id}")
    public String deleteBook(
            @PathVariable
            Integer id
    ){
        booksService.deleteBookById(id);

        return "Book with ID: " + id +" deleted successfully.";
    }
    @GetMapping("/get-prof")
    public List<ProfessionalLogin> getProf(){
        return professionalLoginRepository.findAll();
    }
}
