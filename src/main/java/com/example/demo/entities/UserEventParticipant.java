package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Association between User and Event describing which User is participating to which Event.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = "ovg_user_event_participant",
        uniqueConstraints={@UniqueConstraint(columnNames = {"participant_id" , "event_id"})})
public class UserEventParticipant extends EntityBase {

  /**
 * User of the association.
 */
@ManyToOne
  @JoinColumn(name = "participant_id")
  private User userParticipant;

  /**
 * Event of the association.
 */
@ManyToOne
  @JoinColumn(name = "event_id")
  private Event eventParticipant;


  /**
 * Check if an organisator has validated his the User participation to the Event. False by default.
 */
@Column(nullable = false)
  private Boolean validation = false;

  /**
   * Retrieves the participation status of the User.
 * @return validation Boolean.
 */
public Boolean getValidation() {
    return validation;
  }

  /**
   * Set the participation status of the User.
 * @param validation Boolean.
 */
public void setValidation(final Boolean validation) {
    this.validation = validation;
  }

  /**
   * Retrieves the User of the association.
 * @return userParticipant User.
 */
public User getUserParticipant() {
    return userParticipant;
  }

  /**
   * Set the User of the association.
 * @param userParticipant User.
 */
public void setUserParticipant(final User userParticipant) {
    this.userParticipant = userParticipant;
  }

  /**
   * Retrieves the Event of the association.
 * @return eventParticipant User.
 */
public Event getEventParticipant() {
    return eventParticipant;
  }

  /**
   * Set the Event of the association.
 * @param eventParticipant Event.
 */
public void setEventParticipant(final Event eventParticipant) {
    this.eventParticipant = eventParticipant;
  }
}
