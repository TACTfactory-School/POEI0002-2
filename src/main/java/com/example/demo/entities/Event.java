package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Entity of an event
 * @author ckp
 */
@Entity
@Table(name = "ovg_event")
public class Event extends EntityBase {


  private static final int DESC_LENGTH = 5000;
  private static final int STRING_LENGTH = 255;

  /**
 * User who created the event.
 */
@ManyToOne(optional = false)
  private User author;

  /**
 * Title of the event.
 */
@Column(length = STRING_LENGTH, nullable = false)
  @NotBlank
  private String title;

  /**
 * Description of the event.
 */
@Column(length = DESC_LENGTH, nullable = false)
  @NotBlank
  private String description;

  /**
 * Date at wich the event takes place.
 */
@Column(nullable = false)
  private LocalDateTime dueAt;

  /**
 * Maximum amount of participants.
 */
@Column(nullable = false)
  private Integer nbPlace;

  /**
 * Photo of the event.
 */
@Column(length = STRING_LENGTH, nullable = true)
  private String photo;

  /**
 * Adress of the event.
 */
@Column(length = STRING_LENGTH, nullable = true)
  private String adresse;

  /**
 * Postal code of the event.
 */
@Column(nullable = true) //modifier en cp pour checkstyle
  private Integer cp;

  /**
 * City where the events takes place.
 */
@Column(length = STRING_LENGTH, nullable = false)
  @NotBlank
  private String city;

  /**
 * Tags of the event.
 */
@JsonIgnore
  @OneToMany(mappedBy = "event")
  private List<TagEvent> tagEvents;

  /**
 * Participating Users.
 */
@JsonIgnore
  @OneToMany(mappedBy = "eventParticipant")
  private List<UserEventParticipant> participants;

  /**
 * Organistaors of the event.
 */
@JsonIgnore
  @OneToMany(mappedBy = "eventOrganisator")
  private List<UserEventOrganisator> organisators;

  /**
 * @return the author.
 */
public User getAuthor() {
    return author;
  }

  /**
   * Set a User as the author.
 * @param author User.
 */
public void setAuthor(final User author) {
    this.author = author;
  }

  /**
 * @return a List of tagEvents
 */
public List<TagEvent> getTagEvents() {
    return tagEvents;
  }

  /**
   * Set the tags of the events.
 * @param tagEvents, a List of TagEvents.
 */
public void setTagEvents(final List<TagEvent> tagEvents) {
    this.tagEvents = tagEvents;
  }

  /**
   * Get the title.
 * @return the title.
 */
public String getTitle() {
    return title;
  }

  /**
   * Set the title.
 * @param title as String
 */
public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Get the description.
 * @return the description.
 */
public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public LocalDateTime getDueAt() {
    return dueAt;
  }

  public void setDueAt(final LocalDateTime dueAt) {
    this.dueAt = dueAt;
  }

  public Integer getNbPlace() {
    return nbPlace;
  }

  public void setNbPlace(final Integer nbPlace) {
    this.nbPlace = nbPlace;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(final String photo) {
    this.photo = photo;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(final String adresse) {
    this.adresse = adresse;
  }

  public Integer getCp() {
    return cp;
  }

  public void setCp(final Integer cp) {
    this.cp = cp;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public List<UserEventOrganisator> getOrganisators() {
    return organisators;
  }

  public void setOrganisators(final List<UserEventOrganisator> organisators) {
    this.organisators = organisators;
  }

  public List<UserEventParticipant> getParticipants() {
    return participants;
  }

  public void setParticipants(final List<UserEventParticipant> participants) {
    this.participants = participants;
  }

  public void addParticipant(final UserEventParticipant usereventparticipant) {
    this.participants.add(usereventparticipant);
  }

}
