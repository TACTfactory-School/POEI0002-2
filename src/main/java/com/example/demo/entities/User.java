package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ovg_user")
public class User extends EntityBase{

    @Column(length = 255, nullable = false)
    @NotBlank
    private String username;

    @Column(length = 255, nullable = false)
    @NotBlank
    private String password;

    @Column(length = 255, nullable = false)
    @NotBlank
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
