package com.num.numdb.entity.professional;

public class ProfessionalLoginDTO {
    private String name;
    private String passwd;

    public ProfessionalLoginDTO(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public ProfessionalLoginDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
