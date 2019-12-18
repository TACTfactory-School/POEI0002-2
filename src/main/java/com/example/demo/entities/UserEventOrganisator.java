package com.example.demo.entities;

import com.example.demo.contracts.UserEventOrganisatorContract;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Association between User and Event describing which User is organistor of which Event.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = UserEventOrganisatorContract.TABLE,
        uniqueConstraints = {@UniqueConstraint(columnNames =
                {UserEventOrganisatorContract.COL_USER, UserEventOrganisatorContract.COL_EVENT})})
@AttributeOverride(name = UserEventOrganisatorContract.COL_ID,
        column = @Column(name = UserEventOrganisatorContract.COL_ID))
@AttributeOverride(name = UserEventOrganisatorContract.COL_UPDATED_AT,
        column = @Column(name = UserEventOrganisatorContract.COL_CREATED_AT))
@AttributeOverride(name = UserEventOrganisatorContract.COL_UPDATED_AT,
        column = @Column(name = UserEventOrganisatorContract.COL_UPDATED_AT))
@AttributeOverride(name = UserEventOrganisatorContract.COL_ENABLE,
        column = @Column(name = UserEventOrganisatorContract.COL_ENABLE))
public class UserEventOrganisator extends EntityBase {

  /**
 * The User of the association.
 */
  @ManyToOne
  @JoinColumn(name = UserEventOrganisatorContract.COL_USER)
  private User userOrganisator;

  /**
 * The Event of the association.
 */
  @ManyToOne
  @JoinColumn(name = UserEventOrganisatorContract.COL_EVENT)
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
