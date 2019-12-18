package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Association between User and Hobby describing which User possess which Hobby.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = "ovg_user_hobbie",
        uniqueConstraints={@UniqueConstraint(columnNames = {"hobbie_id" , "user_id"})})
public class UserHobbie extends EntityBase {

  /**
 * Hobby of the association.
 */
@ManyToOne(optional = false)
  @JoinColumn(name = "hobbie_id")
  private Hobbie hobbie;

  /**
 * User of the association.
 */
@ManyToOne(optional = false)
  @JoinColumn(name = "user_id")
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
