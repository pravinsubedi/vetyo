package com.vetyo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Admin on 1/16/2017.
 */
@Entity
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long spec_id;
    private int lot;
    private String cc;
    private String purchase_year;

    public Specification() {
    }

    public Specification(int lot, String cc, String purchase_year) {
        this.lot = lot;
        this.cc = cc;
        this.purchase_year = purchase_year;
    }

    public long getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(long spec_id) {
        this.spec_id = spec_id;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getPurchase_year() {
        return purchase_year;
    }

    public void setPurchase_year(String purchase_year) {
        this.purchase_year = purchase_year;
    }
}
