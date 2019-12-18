package com.example.demo.entities;

import com.example.demo.contracts.UserEventOrganisatorContract;
import com.example.demo.contracts.UserHobbieContract;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * Association between User and Hobby describing which User possess which Hobby.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = UserHobbieContract.TABLE,
        uniqueConstraints={@UniqueConstraint(columnNames =
                {UserHobbieContract.COL_HOBBIE, UserHobbieContract.COL_USER})})
@AttributeOverride(name = UserHobbieContract.COL_ID,
        column = @Column(name=UserHobbieContract.COL_ID))
@AttributeOverride(name = UserHobbieContract.COL_UPDATED_AT,
        column = @Column(name=UserHobbieContract.COL_CREATED_AT))
@AttributeOverride(name = UserHobbieContract.COL_UPDATED_AT,
        column = @Column(name=UserHobbieContract.COL_UPDATED_AT))
@AttributeOverride(name = UserHobbieContract.COL_ENABLE,
        column = @Column(name=UserEventOrganisatorContract.COL_ENABLE))
public class UserHobbie extends EntityBase {

  /**
 * Hobby of the association.
 */
@ManyToOne(optional = false)
@JoinColumn(name = UserHobbieContract.COL_HOBBIE)
  private Hobbie hobbie;

  /**
 * User of the association.
 */
@ManyToOne(optional = false)
@JoinColumn(name = UserHobbieContract.COL_USER)
  private User user;

  /**
   * Retrieves the Hobby of the association.
 * @return hobbie Hobby.
 */
public Hobbie getHobbie() {
    return hobbie;
  }

  /**
   * Set the Hobby of the association.
 * @param hobbie Hobby.
 */
public void setHobbie(final Hobbie hobbie) {
    this.hobbie = hobbie;
  }

  /**
   * Retrieves the User of the association.
 * @return user User.
 */
public User getUser() {
    return user;
  }

  /**
   * Set the User of the association.
 * @param user User.
 */
public void setUser(final User user) {
    this.user = user;
  }
}
