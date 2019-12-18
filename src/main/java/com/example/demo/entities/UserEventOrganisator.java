package com.example.demo.entities;

import javax.persistence.*;

/**
 * Association between User and Event describing which User is organistor of which Event.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = "ovg_user_event_organisator",
        uniqueConstraints={@UniqueConstraint(columnNames = {"organisator_id" , "event_id"})})
public class UserEventOrganisator extends EntityBase {

  /**
 * The User of the association.
 */
@ManyToOne
  @JoinColumn(name = "organisator_id")
  private User userOrganisator;

  /**
 * The Event of the association.
 */
@ManyToOne
  @JoinColumn(name = "event_id")
  private Event eventOrganisator;


  /**
 * Check if the User has validated his status as organisator. False by default.
 */
@Column(nullable = false)
  private Boolean validation = false;

  /**
   * Check whether the User has validated his status as organisator.
 * @return validation Boolean.
 */
public Boolean getValidation() {
    return validation;
  }

  /**
   * Set whether the User has validated his status as organisator.
 * @param validation Boolean.
 */
public void setValidation(final Boolean validation) {
    this.validation = validation;
  }

  /**
   * Retrieves the User of the association.
 * @return userOrganisator User.
 */
public User getUserOrganisator() {
    return userOrganisator;
  }

  /**
   * Set the User of the association.
 * @param userOrganisator User.
 */
public void setUserOrganisator(final User userOrganisator) {
    this.userOrganisator = userOrganisator;
  }

  /**
   * Retrieves the Event of the association.
 * @return eventOrganisator Event.
 */
public Event getEventOrganisator() {
    return eventOrganisator;
  }

  /** set the Event of the association.
 * @param eventOrganisator Event.
 */
public void setEventOrganisator(final Event eventOrganisator) {
    this.eventOrganisator = eventOrganisator;
  }
}
