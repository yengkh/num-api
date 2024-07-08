package com.num.numdb.entity.student;

public class StudentLogInDTO {
    private String stuEmail;
    private String stuPassword;
    private String schoolId;

    public StudentLogInDTO() {
    }

    public StudentLogInDTO(String stuEmail, String stuPassword, String schoolId) {
        this.stuEmail = stuEmail;
        this.stuPassword = stuPassword;
        this.schoolId = schoolId;
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
}
