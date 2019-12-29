package com.example.demo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * DTO of the Event entity.
 *
 * @author Cedrick Pennec
 */
public class EventDto {

  /**
   * Title of the EventDTO.
   */
  private String title;
  /**
   * description of the EventDTO.
   */
  private String description;
  /**
   * author of the EventDTO.
   */
  private String author;
  /**
   * Due time of the EventDTO.
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime dueAt;
  /**
   * Maximum number of participants of the EventDTO.
   */
  private Integer nbPlace;
  /**
   * Number of places available at an EventDTO.
   */
  private Integer nbPlaceRest;
  /**
   * City of the EventDTO.
   */
  private String city;
  /**
   * id of the EventDTO.
   */
  private long id;
  /**
   * photo of the EventDTO.
   */
  private String photo;
  /**
   * Address of the EventDTO.
   */
  private String adresse;
  /**
   * Postal code of the EventDTO.
   */
  private Integer cp;

  /**
   * Retrieves the photo of the EventDTO.
   *
   * @return photo String.
   */
  public String getPhoto() {
    return photo;
  }

  /**
   * Set the photo of the EventDTO.
   *
   * @param photo String.
   */
  public void setPhoto(final String photo) {
    this.photo = photo;
  }

  /**
   * Retrieves the address of the EventDTO.
   *
   * @return adresse String.
   */
  public String getAdresse() {
    return adresse;
  }

  /**
   * Set the address of the EventDTO.
   *
   * @param adresse String.
   */
  public void setAdresse(final String adresse) {
    this.adresse = adresse;
  }

  /**
   * Retrieves the postal code of the EventDTO.
   *
   * @return cp Integer.
   */
  public Integer getCp() {
    return cp;
  }

  /**
   * Set the postal code of the EventDTO.
   *
   * @param cp Integer.
   */
  public void setCp(final Integer cp) {
    this.cp = cp;
  }

  /**
   * Retrieves the id of the EventDTO.
   *
   * @return id long.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the id of the EventDTO.
   *
   * @param id long
   */
  public void setId(final long id) {
    this.id = id;
  }

  /**
   * Retrieves the title of the EventDTO.
   *
   * @return title String.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the EventDTO.
   *
   * @param title String.
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Retrieves the description of the EventDTO.
   *
   * @return description String
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set the description of the EventDTO.
   *
   * @param description String.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Retrieves the author  of the EventDTO..
   *
   * @return author String.
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Set the author of the EventDTO.
   *
   * @param author String.
   */
  public void setAuthor(final String author) {
    this.author = author;
  }

  /**
   * Retrieves the due time of the EventDTO.
   *
   * @return dueAt LocalDateTime.
   */
  public LocalDateTime getDueAt() {
    return dueAt;
  }

  /**
   * Set the due time of the EventDTO.
   *
   * @param dueAt LocalDateTime.
   */
  public void setDueAt(final LocalDateTime dueAt) {
    this.dueAt = dueAt;
  }

  /**
   * Retrieves the maximum amount of participants of the EventDTO.
   *
   * @return nbPlace Integer.
   */
  public Integer getNbPlace() {
    return nbPlace;
  }

  /**
   * Set the maximum amount of participants of the EventDTO.
   *
   * @param nbPlace Integer.
   */
  public void setNbPlace(final Integer nbPlace) {
    this.nbPlace = nbPlace;
  }

  /**
   * Retrieves the number of places available at an EventDTO.
   *
   * @return nbPlaceRest Integer.
   */
  public Integer getNbPlaceRest() {
    return nbPlaceRest;
  }

  /**
   * Set the number of places available at an EventDTO.
   *
   * @param nbPlaceRest Integer.
   */
  public void setNbPlaceRest(final Integer nbPlaceRest) {
    this.nbPlaceRest = nbPlaceRest;
  }

  /**
   * Retrieves the city of the EventDTO.
   *
   * @return city String.
   */
  public String getCity() {
    return city;
  }

  /**
   * Set the city of the EventDTO.
   *
   * @param city String.
   */
  public void setCity(final String city) {
    this.city = city;
  }
}
