package com.example.demo.entities;

import com.example.demo.contracts.UserLanguageContract;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


/**
 * Association between User and Language describing which User speaks which Language.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = UserLanguageContract.TABLE,
        uniqueConstraints={@UniqueConstraint(columnNames =
                {UserLanguageContract.COL_LANGUAGE , UserLanguageContract.COL_USER})})
@AttributeOverride(name = UserLanguageContract.COL_ID,
        column = @Column(name=UserLanguageContract.COL_ID))
@AttributeOverride(name = UserLanguageContract.COL_UPDATED_AT,
        column = @Column(name=UserLanguageContract.COL_CREATED_AT))
@AttributeOverride(name = UserLanguageContract.COL_UPDATED_AT,
        column = @Column(name=UserLanguageContract.COL_UPDATED_AT))
@AttributeOverride(name = UserLanguageContract.COL_ENABLE,
        column = @Column(name= UserLanguageContract.COL_ENABLE))
public class UserLanguage extends EntityBase {


  /**
 * Language of the association.
 */
@ManyToOne
@JoinColumn(name = UserLanguageContract.COL_LANGUAGE)
  private Language language;

  /**
 * User of the association.
 */
@ManyToOne
@JoinColumn(name = UserLanguageContract.COL_USER)
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
