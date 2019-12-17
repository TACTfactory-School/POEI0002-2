package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ovg_user_event_participant")
public class UserEventParticipant extends EntityBase {

  @ManyToOne
  private User userParticipant;

  @ManyToOne
  private Event eventParticipant;


  @Column(nullable = false)
  private Boolean validation = false;

  public Boolean getValidation() {
    return validation;
  }

  public void setValidation(final Boolean validation) {
    this.validation = validation;
  }

  public User getUserParticipant() {
    return userParticipant;
  }

  public void setUserParticipant(final User userParticipant) {
    this.userParticipant = userParticipant;
  }

  public Event getEventParticipant() {
    return eventParticipant;
  }

  public void setEventParticipant(final Event eventParticipant) {
    this.eventParticipant = eventParticipant;
  }
}
