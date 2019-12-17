package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ovg_user")
public class User extends EntityBase {

  private static final int LENGTH = 255;

  @Column(length = LENGTH, nullable = false, unique = true)
  @NotBlank
  private String username;

  @Column(length = LENGTH, nullable = false)
  @NotBlank
  private String password;

  @Column(length = LENGTH, nullable = false)
  @NotBlank
  private String city;

  @Column(nullable = true)
  private String name;

  @Column(nullable = true)
  private String email;

  @Column(nullable = true)
  private String sex;

  @Column(nullable = true)
  private String picture = "default_user.png";

  @Column(nullable = true)
  private String maritalStatus;

  @Column(nullable = true)
  private LocalDateTime birthDate;

  @Column(nullable = true)
  private String description;

  @Column(nullable = true)
  private LocalDateTime lastConnectionDate;

  @Column(nullable = true)
  private String profession;

  @Column(nullable = false)
  private String role;

  @Column(nullable = false)
  private Boolean enable;

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Boolean getEnable() {
    return enable;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }


  @JsonIgnore
  @OneToMany(mappedBy = "userParticipant")
  private List<UserEventParticipant> asParticipant;

  @JsonIgnore
  @OneToMany(mappedBy = "author")
  private List<Event> eventsAsCreator;

  @JsonIgnore
  @OneToMany(mappedBy = "userOrganisator")
  private List<UserEventOrganisator> asOrganisators;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name="ovg_user_friends",
          joinColumns=@JoinColumn(name="friend1_id", referencedColumnName="id"),
          inverseJoinColumns=@JoinColumn(name="friend2_id", referencedColumnName="id"))
  private List<User> friends;

  @JsonIgnore
  @OneToMany(mappedBy = "hobbie")
  private List<UserHobbie> UserHobbie;


  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<UserLanguage> userLanguages;


  public List<User> getFriends() {
    return friends;
  }

  public void setFriends(List<User> friends) {
    this.friends = friends;
  }

  public List<Event> getEventsAsCreator() {
    return eventsAsCreator;
  }

  public void setEventsAsCreator(List<Event> eventsAsCreator) {
    this.eventsAsCreator = eventsAsCreator;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getLastConnectionDate() {
    return lastConnectionDate;
  }

  public void setLastConnectionDate(LocalDateTime lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public List<UserEventParticipant> getAsParticipant() {
    return asParticipant;
  }

  public void addAsParticipant(UserEventParticipant usereventparticipant){
    this.asParticipant.add(usereventparticipant);
  }

  public void setAsParticipant(List<UserEventParticipant> asParticipant) {
    this.asParticipant = asParticipant;
  }

  public List<UserEventOrganisator> getAsOrganisators() {
    return asOrganisators;
  }

  public void setAsOrganisators(List<UserEventOrganisator> asOrganisators) {
    this.asOrganisators = asOrganisators;
  }

  public List<UserHobbie> getUserHobbie() {
    return UserHobbie;
  }

  public void setUserHobbie(List<UserHobbie> userHobbie) {
    UserHobbie = userHobbie;
  }

  public List<UserLanguage> getUserLanguages() {
    return userLanguages;
  }

  public void setUserLanguages(List<UserLanguage> userLanguages) {
    this.userLanguages = userLanguages;
  }

}
