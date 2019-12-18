package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Association between User and Language describing which User speaks which Language.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = "ovg_user_language",
        uniqueConstraints={@UniqueConstraint(columnNames = {"language_id" , "user_id"})})
public class UserLanguage extends EntityBase {

  /**
 * Language of the association.
 */
@ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;

  /**
 * User of the association.
 */
@ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  /**
   * Retrieves the Language of the association.
 * @return language Language.
 */
public Language getLanguage() {
    return language;
  }

  /**
   * Set the Language of the association.
 * @param language Language.
 */
public void setLanguage(final Language language) {
    this.language = language;
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
