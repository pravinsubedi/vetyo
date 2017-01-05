package com.vetyo.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 1/3/2017.
 */
@Entity
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    private String cname;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid")
    private List<Ad> adList;

    public Catagory() {
    }

    public List<Ad> getAdList() {
        return adList;
    }

    public void setAdList(List<Ad> adList) {
        this.adList = adList;
    }

    public Catagory(String cname, List<Ad> adList) {
        this.cname = cname;
        this.adList = adList;
    }

    public Catagory(String cname) {
        this.cname = cname;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}

