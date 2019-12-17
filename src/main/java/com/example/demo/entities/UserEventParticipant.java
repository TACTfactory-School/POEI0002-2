package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "ovg_user_event_participant",
        uniqueConstraints={@UniqueConstraint(columnNames = {"participant_id" , "event_id"})})
public class UserEventParticipant extends EntityBase {

  @ManyToOne
  @JoinColumn(name = "participant_id")
  private User userParticipant;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event eventParticipant;


  @Column(nullable = false)
  private Boolean validation = false;

  public Boolean getValidation() {
    return validation;
  }

  public void setValidation(Boolean validation) {
    this.validation = validation;
  }

  public User getUserParticipant() {
    return userParticipant;
  }

  public void setUserParticipant(User userParticipant) {
    this.userParticipant = userParticipant;
  }

  public Event getEventParticipant() {
    return eventParticipant;
  }

  public void setEventParticipant(Event eventParticipant) {
    this.eventParticipant = eventParticipant;
  }
}
