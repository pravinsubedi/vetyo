package com.vetyo.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 1/3/2017.
 */
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String price;
    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Specification> specificationList;

    public Ad(List<Specification> specificationList) {
        this.specificationList = specificationList;
    }

    public Ad(String title, String price, String city, List<Specification> specificationList) {
        this.title = title;
        this.price = price;
        this.city = city;
        this.specificationList = specificationList;
    }

    public Ad() {
    }


    public Ad(String title, String price, String city) {
        this.title = title;
        this.price = price;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Specification> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<Specification> specificationList) {
        this.specificationList = specificationList;
    }
}
