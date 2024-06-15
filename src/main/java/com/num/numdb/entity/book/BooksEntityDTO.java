package com.num.numdb.entity.book;

import org.springframework.web.multipart.MultipartFile;

public class BooksEntityDTO {
    private String name;
    private String author;
    private MultipartFile file;
    private MultipartFile image;

    public BooksEntityDTO() {
    }

    public BooksEntityDTO(String name, String author, MultipartFile file, MultipartFile image) {
        this.name = name;
        this.author = author;
        this.file = file;
        this.image = image;
    }

    public BooksEntityDTO(String author, MultipartFile file, MultipartFile image) {
        this.author = author;
        this.file = file;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
