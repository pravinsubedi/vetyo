package com.vetyo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Admin on 1/3/2017.
 */
@Entity
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    private String cname;

    public Catagory() {
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

