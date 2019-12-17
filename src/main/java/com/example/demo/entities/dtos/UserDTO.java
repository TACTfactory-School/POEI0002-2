package com.example.demo.entities.dtos;

import java.time.LocalDateTime;


public class UserDTO {

  private long id;

  private String username;

  private String city;

  private String name;

  private String email;

  private String sex;

  private String picture = "default_user.png";

  private String maritalStatus;

  private LocalDateTime birthDate;

  private String description;

  private LocalDateTime lastConnectionDate;

  private String profession;



  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(final String sex) {
    this.sex = sex;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(final String picture) {
    this.picture = picture;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(final String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(final LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public LocalDateTime getLastConnectionDate() {
    return lastConnectionDate;
  }

  public void setLastConnectionDate(final LocalDateTime lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(final String profession) {
    this.profession = profession;
  }
}
