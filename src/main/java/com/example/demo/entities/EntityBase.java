package com.example.demo.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private LocalDateTime createdAt = LocalDateTime.now();

    protected EntityBase() {
        super();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
}
