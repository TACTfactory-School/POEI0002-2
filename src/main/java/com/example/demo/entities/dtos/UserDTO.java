package com.example.demo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * DTO of the User entity.
 * @author Cedrick Pennec
 */
public class UserDTO {

  /**
 * id of the UserDTO.
 */
private long id;

  /**
 * username of the UserDTO.
 */
private String username;

  /**
 * city of the UserDTO.
 */
private String city;

  /**
 * name of the UserDTO.
 */
private String name;

  /**
 * email of the UserDTO.
 */
private String email;

  /**
 * sex of the UserDTO.
 */
private String sex;

  /**
 * picture of the UserDTO. With a default value of "default_user.png".
 */
private String picture = "default_user.png";

  /**
 * Marital status of the UserDTO.
 */
@JsonProperty("marital_status")
  private String maritalStatus;

  /**
 * Date of birth of the UserDTO.
 */
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime birthDate;

  /**
 * Description of the UserDTO.
 */
private String description;

  /**
 * Last connection date of the UserDTO.
 */
@JsonProperty("last_connection_date")
  private LocalDateTime lastConnectionDate;

  /**
 * Creation date of the UserDTO.
 */
@JsonProperty("created_at")
  private LocalDateTime createdAt;

  /**
 * Last modification date of the UserDTO.
 */
@JsonProperty("update_at")
  private LocalDateTime updatedAt;

  /**
 * Profession of the UserDTO.
 */
private String profession;



  /**
   * Retrieve the id of the UserDTO.
 * @return id long.
 */
public long getId() {
    return id;
  }

  /**
   * Set the id of the UserDTO.
 * @param id long.
 */
public void setId(final long id) {
    this.id = id;
  }

  /**
   * Retrieves the username of the UserDTO.
 * @return username String.
 */
public String getUsername() {
    return username;
  }

  /**
   * Set the username of the UserDTO.
 * @param username String
 */
public void setUsername(final String username) {
    this.username = username;
  }

  /**
   * Retrieves the city of the UserDTO.
 * @return city String.
 */
public String getCity() {
    return city;
  }

  /**
   * Set the city of the UserDTO.
 * @param city String.
 */
public void setCity(final String city) {
    this.city = city;
  }

  /**
   * retrieves the name of the UserDTO.
 * @return name String.
 */
public String getName() {
    return name;
  }

  /**
   * Set the name of the UserDTO.
 * @param name String.
 */
public void setName(final String name) {
    this.name = name;
  }

  /**
   * Retrieves the email of the UserDTO.
 * @return email String.
 */
public String getEmail() {
    return email;
  }

  /**
   * Set the email of the UserDTO.
 * @param email String.
 */
public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Retrieves the sex of the UserDTO.
 * @return sex String.
 */
public String getSex() {
    return sex;
  }

  /**
   * Set the sex of the UserDTO.
 * @param sex String.
 */
public void setSex(final String sex) {
    this.sex = sex;
  }

  /**
   * Retrieves the picture of the UserDTO.
 * @return picture String.
 */
public String getPicture() {
    return picture;
  }

  /**
   * Set the picture of the UserDTO.
 * @param picture String.
 */
public void setPicture(final String picture) {
    this.picture = picture;
  }

  /**
   * Retrieves the marital status of the UserDTO.
 * @return maritalStatus String.
 */
public String getMaritalStatus() {
    return maritalStatus;
  }

  /**
   * Set the marital status of the UserDTO.
 * @param maritalStatus String.
 */
public void setMaritalStatus(final String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  /**
   * Retrieves the date of birth of the UserDTO.
 * @return birthdate LocalDateTime.
 */
public LocalDateTime getBirthDate() {
    return birthDate;
  }

  /**
   * Set the date of birth of birth of the UserDTO.
 * @param birthDate LocalDateTime.
 */
public void setBirthDate(final LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * retrieves the description of the UserDTO.
 * @return description String.
 */
public String getDescription() {
    return description;
  }

  /**
   * Set the description of the UserDTO.
 * @param description String.
 */
public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Retrieves the last connection date of the UserDTO.
 * @return lastConnectionDate LocalDateTime.
 */
public LocalDateTime getLastConnectionDate() {
    return lastConnectionDate;
  }

  /**
   * Set  the last connection date of the UserDTO.
 * @param lastConnectionDate LocalDateTime.
 */
public void setLastConnectionDate(final LocalDateTime lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }

  /**
   * Retrieves the profession of the UserDTO.
 * @return profession String.
 */
public String getProfession() {
    return profession;
  }

  /**
   * Set the profession of the UserDTO.
 * @param profession String.
 */
public void setProfession(final String profession) {
    this.profession = profession;
  }

  /**
   * Retrieves the date of creation of the UserDTO.
 * @return createdAt LocalDateTime.
 */
public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Set  the date of creation of the UserDTO.
 * @param createdAt LocalDateTime.
 */
public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Retrieves the date of the last modification of the UserDTO.
 * @return updatedAt LocalDateTime.
 */
public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Set the date of the last modification of the UserDTO.
 * @param updatedAt LocalDateTime.
 */
public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
