package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity of a User
 * @author Cedrick Pennec
 */
@Entity
@Table(name = "ovg_user")
public class User extends EntityBase {

  private static final int LENGTH = 255;

  /**
 * Username of the user
 */
@Column(length = LENGTH, nullable = false, unique = true)
  @NotBlank
  private String username;

  /**
 * Password of User
 */
@Column(length = LENGTH, nullable = false)
  @NotBlank
  private String password;

  /**
 * City of User
 */
@Column(length = LENGTH, nullable = false)
  @NotBlank
  private String city;

  /**
 * Name of User
 */
@Column(nullable = true)
  private String name;

  /**
 * Email of User
 */
@Column(nullable = true)
  private String email;

  /**
 * Sex of User
 */
@Column(nullable = true)
  private String sex;

  /**
 * Picture of user possessing a default value.
 */
@Column(nullable = true)
  private String picture = "default_user.png";

  /**
 * Marital status of User.
 */
@Column(nullable = true)
  private String maritalStatus;

  /**
 * Date of birth of User.
 */
@Column(nullable = true)
  private LocalDateTime birthDate;

  /**
 * Description of User.
 */
@Column(nullable = true)
  private String description;

  /**
 * Last connection date of User.
 */
@Column(nullable = true)
  private LocalDateTime lastConnectionDate;

  /**
 * Profession of User
 */
@Column(nullable = true)
  private String profession;

  /**
 * Security role of User
 */
@Column(nullable = false)
  private String role;

  /**
 * Whether a User is enabled or not.
 */
@Column(nullable = false)
  private Boolean enable;

  /**
   * Retrieves the role of User.
 * @return the role of User.
 */
public String getRole() {
    return role;
  }

  /**
   * Set the role of User.
 * @param role the role of User.
 */
public void setRole(final String role) {
    this.role = role;
  }

  /**
 * List of associations between User and Event containing those this User is participating in.
 */
@JsonIgnore
  @OneToMany(mappedBy = "userParticipant")
  private List<UserEventParticipant> asParticipant;

  /**
 * List of Events created by this User.
 */
@JsonIgnore
  @OneToMany(mappedBy = "author")
  private List<Event> eventsAsCreator;

  /**
 * List of associations between User and Event containing those this User is organizing.
 */
@JsonIgnore
  @OneToMany(mappedBy = "userOrganisator")
  private List<UserEventOrganisator> asOrganisators;

  /**
 * List of Users this User is friend with.
 */
@JsonIgnore
  @ManyToMany
  @JoinTable(
          name="ovg_user_friends",
          joinColumns=@JoinColumn(name="friend1_id", referencedColumnName="id"),
          inverseJoinColumns=@JoinColumn(name="friend2_id", referencedColumnName="id"))
  private List<User> friends;

  /**
 * List of associations between User and Hobby containing those concerning this User.
 */
@JsonIgnore
  @OneToMany(mappedBy = "hobbie")
  private List<UserHobbie> userHobbie;


  /**
 * List of associations between User and Language containing those concerning this User.
 */
@JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<UserLanguage> userLanguages;


  /**
   * Retrieves this User's friends.
 * @return a List of User.
 */
public List<User> getFriends() {
    return friends;
  }

  /**
   * Set this User's friends.
 * @param friends List of User.
 */
public void setFriends(final List<User> friends) {
    this.friends = friends;
  }

  /**
   * Retrieves the events this User created.
 * @return a List of Event.
 */
public List<Event> getEventsAsCreator() {
    return eventsAsCreator;
  }

  /**
   * Set the events this User created.
 * @param eventsAsCreator List of Event.
 */
public void setEventsAsCreator(final List<Event> eventsAsCreator) {
    this.eventsAsCreator = eventsAsCreator;
  }

  /**
   * Retrieves this User's name.
 * @return this User's name.
 */
public String getName() {
    return name;
  }

  /**
   * Set this User's name.
 * @param name String.
 */
public void setName(final String name) {
    this.name = name;
  }

  /**
   * Retrieves the Email of User.
 * @return String email.
 */
public String getEmail() {
    return email;
  }

  /**
   * Set this User's email.
 * @param email String
 */
public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * retrieve this User's sex.
 * @return String sex.
 */
public String getSex() {
    return sex;
  }

  /**
   * Set this User's Sex.
 * @param sex String.
 */
public void setSex(final String sex) {
    this.sex = sex;
  }

  /**
   * Retrieves this User's picture.
 * @return String picture.
 */
public String getPicture() {
    return picture;
  }

  /**
   * Set this User's picture.
 * @param picture String
 */
public void setPicture(final String picture) {
    this.picture = picture;
  }

  /**
   * Retrieves the marital status of User.
 * @return String MaritalStatus.
 */
public String getMaritalStatus() {
    return maritalStatus;
  }

  /**
   * Set marital Status of User
 * @param maritalStatus String.
 */
public void setMaritalStatus(final String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  /**
   * Retrieve birth date of User.
 * @return LocalDateTime birthDate.
 */
public LocalDateTime getBirthDate() {
    return birthDate;
  }

  /**
   * Set the birth date of User.
 * @param birthDate LocalDateTime.
 */
public void setBirthDate(final LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * Retrieves the description of User.
 * @return String description.
 */
public String getDescription() {
    return description;
  }

  /**
   * Set the description of User.
 * @param description String.
 */
public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Retrieves the last connection date of User.
 * @return LocalDateTime lastConnectionDate.
 */
public LocalDateTime getLastConnectionDate() {
    return lastConnectionDate;
  }

  /**
   * set the last connection date of User.
 * @param lastConnectionDate LocalDateTime.
 */
public void setLastConnectionDate(final LocalDateTime lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }

  /**
   * Retrieves the User's profession.
 * @return String profession.
 */
public String getProfession() {
    return profession;
  }

  /**
   * Set the User's profession.
 * @param profession String.
 */
public void setProfession(final String profession) {
    this.profession = profession;
  }

  /**
   * Retrieves the User's username.
 * @return String username.
 */
public String getUsername() {
    return username;
  }

  /**
   * Set the User's username.
 * @param username String.
 */
public void setUsername(final String username) {
    this.username = username;
  }

  /**
   * Retrieves the User's password.
 * @return String password.
 */
public String getPassword() {
    return password;
  }

  /**
   * Set the User's password.
 * @param password String.
 */
public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * retrieves the User's city.
 * @return String city.
 */
public String getCity() {
    return city;
  }

  /**
   * Set the User's city.
 * @param city String.
 */
public void setCity(final String city) {
    this.city = city;
  }

  /**
   * Retrieves the associations between User and Event containing those this User is participating in.
 * @return asParticipant List of UserEventParticipant
 */
public List<UserEventParticipant> getAsParticipant() {
    return asParticipant;
  }

  /**
   * Add an association between User and Event concerning the participation oh this User in that Event.
 * @param usereventparticipant UserEventParticipant
 */
public void addAsParticipant(final UserEventParticipant usereventparticipant) {
    this.asParticipant.add(usereventparticipant);
  }

  /**
   * Set an association between User and Event concerning the participation oh this User in that Event.
 * @param asParticipant UserEventParticipant.
 */
public void setAsParticipant(final List<UserEventParticipant> asParticipant) {
    this.asParticipant = asParticipant;
  }

  /**
   * Retrieves the associations between User and Event containing those this User is organizing.
 * @return asOrganisators List of UserEventOrganisator
 */
public List<UserEventOrganisator> getAsOrganisators() {
    return asOrganisators;
  }

  /**
   * Set an association between User and Event concerning the organizing oh that Event by this User.
 * @param asOrganisators List of UserEventOrganisator
 */
public void setAsOrganisators(final List<UserEventOrganisator> asOrganisators) {
    this.asOrganisators = asOrganisators;
  }

  /**
   * Retrieves the associations between this User and its Hobbies.
 * @return userHobbie List of UserHobbie
 */
public List<UserHobbie> getUserHobbie() {
    return userHobbie;
  }

  /**
   * Set the associations between this User and its Hobbies.
 * @param userHobbie List of UserHobbie
 */
public void setUserHobbie(final List<UserHobbie> userHobbie) {
    this.userHobbie = userHobbie;
  }

  /**
   * Retrieves Retrieves the associations between this User and its Languages.
 * @return List of UserLanguage
 */
public List<UserLanguage> getUserLanguages() {
    return userLanguages;
  }

  /**
   * Set the associations between this User and its Languages.
 * @param userLanguages List UserLanguage
 */
public void setUserLanguages(final List<UserLanguage> userLanguages) {
    this.userLanguages = userLanguages;
  }

}
