package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.example.demo.contracts.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = UserContract.TABLE)
@AttributeOverride(name = UserContract.COL_ID,
        column = @Column(name=UserContract.COL_ID))
@AttributeOverride(name = UserContract.COL_UPDATED_AT,
        column = @Column(name=UserContract.COL_CREATED_AT))
@AttributeOverride(name = UserContract.COL_UPDATED_AT,
        column = @Column(name=UserContract.COL_UPDATED_AT))
@AttributeOverride(name = UserContract.COL_ENABLE,
        column = @Column(name=UserContract.COL_ENABLE))
public class User extends EntityBase {


  @Column(length = UserContract.LENGTH, nullable = false, unique = true, name = UserContract.COL_USERNAME)
  @NotBlank
  private String username;

  @Column(length = UserContract.LENGTH, nullable = false, name = UserContract.COL_PASSWORD)
  @NotBlank
  private String password;

  @Column(length = UserContract.LENGTH, nullable = false, name = UserContract.COL_CITY)
  @NotBlank
  private String city;

  @Column(nullable = true, name = UserContract.COL_NAME)
  private String name;

  @Column(nullable = true, name = UserContract.COL_EMAIL)
  private String email;

  @Column(nullable = true, name = UserContract.COL_SEX)
  private String sex;

  @Column(nullable = true, name = UserContract.COL_PICTURE)
  private String picture = UserContract.DEFAULT_PICTURE;

  @Column(nullable = true, name = UserContract.COL_MARITAL_STATUS)
  private String maritalStatus;

  @Column(nullable = true, name = UserContract.COL_BIRTH_DATE)
  private LocalDateTime birthDate;

  @Column(nullable = true, name = UserContract.COL_DESCRIPTION)
  private String description;

  @Column(nullable = true, name = UserContract.COL_LAST_CONNECTION_DATE)
  private LocalDateTime lastConnectionDate;

  @Column(nullable = true, name = UserContract.COL_PROFESSION)
  private String profession;

  @Column(nullable = false, name = UserContract.COL_ROLE)
  private String role;

  @Column(nullable = false, name = UserContract.COL_ENABLE)
  private Boolean enable;

  public String getRole() {
    return role;
  }

  public void setRole(final String role) {
    this.role = role;
  }

  public Boolean getEnable() {
    return enable;
  }

  public void setEnable(final Boolean enable) {
    this.enable = enable;
  }


  @JsonIgnore
  @OneToMany(mappedBy = UserEventParticipantContract.USER_PARTICIPANT)
  private List<UserEventParticipant> asParticipant;

  @JsonIgnore
  @OneToMany(mappedBy = EventContract.AUTHOR)
  private List<Event> eventsAsCreator;

  @JsonIgnore
  @OneToMany(mappedBy = UserEventOrganisatorContract.USER_ORGANISATOR)
  private List<UserEventOrganisator> asOrganisators;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name=UserContract.ASC_TABLE_FRIENDS,
          joinColumns=@JoinColumn(name=UserContract.ASC_COL_FRIEND1, referencedColumnName="id"),
          inverseJoinColumns=@JoinColumn(name=UserContract.ASC_COL_FRIEND2, referencedColumnName="id"))
  private List<User> friends;

  @JsonIgnore
  @OneToMany(mappedBy = UserHobbieContract.HOBBIE)
  private List<UserHobbie> userHobbie;


  @JsonIgnore
  @OneToMany(mappedBy = UserLanguageContract.USER_LANGUAGE)
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

  public void setEventsAsCreator(final List<Event> eventsAsCreator) {
    this.eventsAsCreator = eventsAsCreator;
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

  public void addAsParticipant(final UserEventParticipant usereventparticipant) {
    this.asParticipant.add(usereventparticipant);
  }

  public void setAsParticipant(final List<UserEventParticipant> asParticipant) {
    this.asParticipant = asParticipant;
  }

  public List<UserEventOrganisator> getAsOrganisators() {
    return asOrganisators;
  }

  public void setAsOrganisators(final List<UserEventOrganisator> asOrganisators) {
    this.asOrganisators = asOrganisators;
  }

  public List<UserHobbie> getUserHobbie() {
    return userHobbie;
  }

  public void setUserHobbie(final List<UserHobbie> userHobbie) {
    this.userHobbie = userHobbie;
  }

  public List<UserLanguage> getUserLanguages() {
    return userLanguages;
  }

  public void setUserLanguages(final List<UserLanguage> userLanguages) {
    this.userLanguages = userLanguages;
  }

}
