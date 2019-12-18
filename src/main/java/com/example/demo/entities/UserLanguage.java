package com.example.demo.entities;

import com.example.demo.contracts.UserLanguageContract;

import javax.persistence.*;

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

  @ManyToOne
  @JoinColumn(name = UserLanguageContract.COL_LANGUAGE)
  private Language language;

  @ManyToOne
  @JoinColumn(name = UserLanguageContract.COL_USER)
  private User user;

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}