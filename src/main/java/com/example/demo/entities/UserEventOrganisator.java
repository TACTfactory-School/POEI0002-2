package com.example.demo.entities;

import com.example.demo.contracts.UserEventOrganisatorContract;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = UserEventOrganisatorContract.TABLE,
        uniqueConstraints={@UniqueConstraint(columnNames =
                {UserEventOrganisatorContract.COL_USER , UserEventOrganisatorContract.COL_EVENT})})
@AttributeOverride(name = UserEventOrganisatorContract.COL_ID,
        column = @Column(name=UserEventOrganisatorContract.COL_ID))
@AttributeOverride(name = UserEventOrganisatorContract.COL_UPDATED_AT,
        column = @Column(name=UserEventOrganisatorContract.COL_CREATED_AT))
@AttributeOverride(name = UserEventOrganisatorContract.COL_UPDATED_AT,
        column = @Column(name=UserEventOrganisatorContract.COL_UPDATED_AT))
@AttributeOverride(name = UserEventOrganisatorContract.COL_ENABLE,
        column = @Column(name=UserEventOrganisatorContract.COL_ENABLE))
public class UserEventOrganisator extends EntityBase {

  @ManyToOne
  @JoinColumn(name = UserEventOrganisatorContract.COL_USER)
  private User userOrganisator;

  @ManyToOne
  @JoinColumn(name = UserEventOrganisatorContract.COL_EVENT)
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
