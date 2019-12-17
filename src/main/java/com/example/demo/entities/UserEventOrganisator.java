package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "ovg_user_event_organisator",
        uniqueConstraints={@UniqueConstraint(columnNames = {"organisator_id" , "event_id"})})
public class UserEventOrganisator extends EntityBase {

  @ManyToOne
  @JoinColumn(name = "organisator_id")
  private User userOrganisator;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event eventOrganisator;


  @Column(nullable = false)
  private Boolean validation = false;

  public Boolean getValidation() {
    return validation;
  }

  public void setValidation(Boolean validation) {
    this.validation = validation;
  }

  public User getUserOrganisator() {
    return userOrganisator;
  }

  public void setUserOrganisator(User userOrganisator) {
    this.userOrganisator = userOrganisator;
  }

  public Event getEventOrganisator() {
    return eventOrganisator;
  }

  public void setEventOrganisator(Event eventOrganisator) {
    this.eventOrganisator = eventOrganisator;
  }
}