package com.num.numdb.entity.student;

import jakarta.persistence.*;

@Entity
@Table(name = "student_login")
public class StudentEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String stuName;
    @Column(unique = true)
    private String stuEmail;
    private String stuPassword;
    private String schoolId;

    public StudentEntity() {
    }

    public StudentEntity(Integer id, String stuName, String stuEmail, String stuPassword, String schoolId) {
        this.id = id;
        this.stuName = stuName;
        this.stuEmail = stuEmail;
        this.stuPassword = stuPassword;
        this.schoolId = schoolId;
    }

    public StudentEntity(String stuName, String stuEmail, String stuPassword, String schoolId) {
        this.stuName = stuName;
        this.stuEmail = stuEmail;
        this.stuPassword = stuPassword;
        this.schoolId = schoolId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", schoolId='" + schoolId + '\'' +
                '}';
    }
}
