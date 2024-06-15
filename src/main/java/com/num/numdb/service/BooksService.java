package com.num.numdb.service;
import com.num.numdb.entity.book.BooksEntity;
import com.num.numdb.entity.book.BooksEntityDTO;
import com.num.numdb.repository.BooksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.UUID;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    // Save book to db
    public BooksEntity saveBook(
            @ModelAttribute
            BooksEntityDTO booksEntityDTO
    ) throws IOException {
        Date time = new Date();
        // Save File
        MultipartFile file = booksEntityDTO.getFile();

        String filePath = file.getOriginalFilename();

        String uploadFileDir = "public/files/";
        Path uploadPath = Paths.get(uploadFileDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try(InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, Paths.get(uploadFileDir + filePath), StandardCopyOption.REPLACE_EXISTING);
        }

        String uploadImageDir =  "public/images/";
        InputStream inputStream = file.getInputStream();
        PDDocument document = PDDocument.load(inputStream);

        PDFRenderer renderer = new PDFRenderer(document);
        BufferedImage image = renderer.renderImage(0);
        // Save the first page of the PDF as an image file
        String imageFileName = UUID.randomUUID() + "image_for_first_page.png";
        Path imagePath = Paths.get(uploadImageDir + imageFileName);
        ImageIO.write(image, "png", imagePath.toFile());

        // Save the image file path to the database
        String imagePathStr = imageFileName;
        document.close();

        BooksEntity booksEntity = new BooksEntity();
        booksEntity.setAuthor(booksEntityDTO.getAuthor());
        booksEntity.setName(booksEntityDTO.getName());
        booksEntity.setTime(time);
        booksEntity.setFile(filePath);
        booksEntity.setImage(imagePathStr);

        return booksRepository.save(booksEntity);
    }

    // Update book
    public  BooksEntity updateBook(
            Integer id,
            BooksEntityDTO booksEntityDTO
    ) throws IOException {
        BooksEntity existBook = booksRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id : " + id + " not found."));

        Date time = new Date();
        // File
        MultipartFile file = booksEntityDTO.getFile();
        String filePath = file.getOriginalFilename();
        String uploadDir = "public/files/";
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, Paths.get(uploadDir + filePath), StandardCopyOption.REPLACE_EXISTING);
        }

        // Image
        String uploadImageDir = "public/images/";
        InputStream inputStream = file.getInputStream();
        PDDocument document = PDDocument.load(inputStream);
        PDFRenderer renderer = new PDFRenderer(document);
        BufferedImage image = renderer.renderImage(0);
        // Save the first page of the PDF as an image file
        String imageFileName = UUID.randomUUID() + "_" +"image_for_first_page.png";
        Path imagePath = Paths.get(uploadImageDir + imageFileName);
        ImageIO.write(image, "png", imagePath.toFile());

        // Save the image file path to the database
        String imagePathStr = imageFileName;
        document.close();

        existBook.setAuthor(booksEntityDTO.getAuthor());
        existBook.setName(booksEntityDTO.getName());
        existBook.setFile(filePath);
        existBook.setImage(imagePathStr);
        existBook.setTime(time);

        return  booksRepository.save(existBook);
    }

    public void deleteBookById(Integer id) {
        booksRepository.deleteById(id);
    }

    // Delete Book
}
