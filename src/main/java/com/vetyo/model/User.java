package com.vetyo.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Admin on 1/3/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    @Email(message = "Validate email and try again")
    private String email;
    @NotNull
    @NotEmpty
    private String pno;
    @Column(name = "admin",columnDefinition = "char(3)")
    @Type(type = "yes_no")
    private Boolean admin;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    private List<Ad> adList;

    public User(String username, String password, String email, String pno, Boolean admin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.pno = pno;
        this.admin = admin;
    }

    public User() {

    }

    public User(List<Ad> adList) {
        this.adList = adList;
    }

    public User(String username, String password, String email, String pno, Boolean admin, List<Ad> adList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.pno = pno;
        this.admin = admin;
        this.adList = adList;
    }

    public List<Ad> getAdList() {
        return adList;
    }

    public void setAdList(List<Ad> adList) {
        this.adList = adList;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}
