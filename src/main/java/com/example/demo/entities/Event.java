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

  /**
 * @param description of the event
 */
public void setDescription(final String description) {
    this.description = description;
  }

  /**
 * @return the Date at which the event takes place.
 */
public LocalDateTime getDueAt() {
    return dueAt;
  }

  /**
   * Set the date at which the event takes place.
 * @param dueAt Date at which the event takes place.
 */
public void setDueAt(final LocalDateTime dueAt) {
    this.dueAt = dueAt;
  }

  /**
   * Retrieves the number of participants allowed to participate in the event.
 * @return the number of participants allowed.
 */
public Integer getNbPlace() {
    return nbPlace;
  }

  /**
   * Set the number of participants allowed to participate in the event.
 * @param nbPlace the number of participants allowed.
 */
public void setNbPlace(final Integer nbPlace) {
    this.nbPlace = nbPlace;
  }

  /**
   * Retrieves the photo of the event.
 * @return the photo of the Event
 */
public String getPhoto() {
    return photo;
  }

  /**
   * Set the photo of the Event
 * @param photo the photo of the Event
 */
public void setPhoto(final String photo) {
    this.photo = photo;
  }

  /**
   * Retrieves the address of the event.
 * @return the address of the event.
 */
public String getAdresse() {
    return adresse;
  }

  /**
   * Set the address of the event.
 * @param adresse the address of the event.
 */
public void setAdresse(final String adresse) {
    this.adresse = adresse;
  }

  /**
   * Retrieves the postal code of the Event.
 * @return the postal code of the Event.
 */
public Integer getCp() {
    return cp;
  }

  /**
   * Set the postal code of the Event.
 * @param cp the postal code of the Event.
 */
public void setCp(final Integer cp) {
    this.cp = cp;
  }

  /**
   * Retrieves the city of the Event.
 * @return the city of the Event.
 */
public String getCity() {
    return city;
  }

  /**
   * Set the city of the Event.
 * @param city the city of the Event.
 */
public void setCity(final String city) {
    this.city = city;
  }

  /**
   * Retrieves the organisators of the Event.
 * @return the organisators of the Event.
 */
public List<UserEventOrganisator> getOrganisators() {
    return organisators;
  }

  /** Set the organisators of the Event.
 * @param organisators the organisators of the Event.
 */
public void setOrganisators(final List<UserEventOrganisator> organisators) {
    this.organisators = organisators;
  }

  /**
   * Retrieves the participants of the Event.
 * @return the participants of the Event.
 */
public List<UserEventParticipant> getParticipants() {
    return participants;
  }

  /**
   * Set the participants of the Event.
 * @param participants the participants of the Event.
 */
public void setParticipants(final List<UserEventParticipant> participants) {
    this.participants = participants;
  }

  /**
   * Add a participant to the Event.
 * @param usereventparticipant Participant to add.
 */
public void addParticipant(final UserEventParticipant usereventparticipant) {
    this.participants.add(usereventparticipant);
  }

}
