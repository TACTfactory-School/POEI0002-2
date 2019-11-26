package com.example.demo.entities;

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
    private String author;

    @Column(length = LENGTH, nullable = false)
    @NotBlank
    private String description;

    @Column(length = LENGTH, nullable = false)
    @NotBlank
    private String label;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }
}
