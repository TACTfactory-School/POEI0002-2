package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ovg_user_event_organisator")
public class UserEventOrganisator extends EntityBase {

  @ManyToOne
  private User userOrganisator;

  @ManyToOne
  private Event eventOrganisator;


  @Column(nullable = false)
  private Boolean validation = false;

  public Boolean getValidation() {
    return validation;
  }

  public void setValidation(final Boolean validation) {
    this.validation = validation;
  }

  public User getUserOrganisator() {
    return userOrganisator;
  }

  public void setUserOrganisator(final User userOrganisator) {
    this.userOrganisator = userOrganisator;
  }

  public Event getEventOrganisator() {
    return eventOrganisator;
  }

  public void setEventOrganisator(final Event eventOrganisator) {
    this.eventOrganisator = eventOrganisator;
  }
}
