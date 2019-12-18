package com.example.demo.entities;

import com.example.demo.contracts.UserEventParticipantContract;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = UserEventParticipantContract.TABLE,
        uniqueConstraints={@UniqueConstraint(columnNames =
                {UserEventParticipantContract.COL_USER , UserEventParticipantContract.COL_EVENT})})
@AttributeOverride(name = UserEventParticipantContract.COL_ID,
        column = @Column(name=UserEventParticipantContract.COL_ID))
@AttributeOverride(name = UserEventParticipantContract.COL_UPDATED_AT,
        column = @Column(name=UserEventParticipantContract.COL_CREATED_AT))
@AttributeOverride(name = UserEventParticipantContract.COL_UPDATED_AT,
        column = @Column(name=UserEventParticipantContract.COL_UPDATED_AT))
@AttributeOverride(name = UserEventParticipantContract.COL_ENABLE,
        column = @Column(name=UserEventParticipantContract.COL_ENABLE))
public class UserEventParticipant extends EntityBase {

  @ManyToOne
  @JoinColumn(name = UserEventParticipantContract.COL_USER)
  private User userParticipant;

  @ManyToOne
  @JoinColumn(name = UserEventParticipantContract.COL_EVENT)
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
