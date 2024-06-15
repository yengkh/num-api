package com.num.numdb.entity.book;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 70)
    private String name;
    @Column(length = 50)
    private String author;
    private String file;
    private String image;
    private Date time;

    public BooksEntity(Integer id, String name, String author, String file, String image, Date time) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.file = file;
        this.image = image;
        this.time = time;
    }

    public BooksEntity() {
    }

    public BooksEntity(String name, String author, String file, String image, Date time) {
        this.name = name;
        this.author = author;
        this.file = file;
        this.image = image;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
