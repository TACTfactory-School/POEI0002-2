package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ovg_event")
public class Event extends EntityBase {

    static final int LENGTH = 255;

    @Column(length = LENGTH, nullable = false)
    @NotBlank
    private String title;

    @Column(length = 5000, nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    private LocalDateTime dueAt;

    @Column(nullable = false)
    private Integer nbPlace;

    @Column(length = 255, nullable = true)
    private String photo;

    @Column(length = 255, nullable = true)
    private String adresse;

    @Column(nullable = true)
    private Integer CP;

    @Column(length = 255, nullable = false)
    @NotBlank
    private String city;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public LocalDateTime getDueAt() {
        return dueAt;
    }

    public void setDueAt(LocalDateTime dueAt) {
        this.dueAt = dueAt;
    }

    public Integer getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Integer nbPlace) {
        this.nbPlace = nbPlace;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCP() {
        return CP;
    }

    public void setCP(Integer cP) {
        CP = cP;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
