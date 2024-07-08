package com.num.numdb.entity.professional;
import jakarta.persistence.*;

@Entity
public class ProfessionalLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String passwd;

    public ProfessionalLogin(Integer id, String name, String passwd) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;

    }

    public ProfessionalLogin(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public ProfessionalLogin() {
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
