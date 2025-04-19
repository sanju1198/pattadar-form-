package com.example.demo.entity;

import javax.persistence.*;

@Table(name = "pattadar_form")
@Entity
public class FormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String landOwner;
    private String fatherName;
    private String aadhaarNo;
    private Boolean newPattadarBook;
    private String newPattadarBookNo;
    private Boolean oldPattadarBook;
    private String khataNo;

    // Getters and Setters
    public String getLandOwner() {
        return landOwner;
    }

    public void setLandOwner(String landOwner) {
        this.landOwner = landOwner;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public Boolean getNewPattadarBook() {
        return newPattadarBook;
    }

    public void setNewPattadarBook(Boolean newPattadarBook) {
        this.newPattadarBook = newPattadarBook;
    }

    public String getNewPattadarBookNo() {
        return newPattadarBookNo;
    }

    public void setNewPattadarBookNo(String newPattadarBookNo) {
        this.newPattadarBookNo = newPattadarBookNo;
    }

    public Boolean getOldPattadarBook() {
        return oldPattadarBook;
    }

    public void setOldPattadarBook(Boolean oldPattadarBook) {
        this.oldPattadarBook = oldPattadarBook;
    }

    public String getKhataNo() {
        return khataNo;
    }

    public void setKhataNo(String khataNo) {
        this.khataNo = khataNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}