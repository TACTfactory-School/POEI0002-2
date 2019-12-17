package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "ovg_user_language",
        uniqueConstraints={@UniqueConstraint(columnNames = {"language_id" , "user_id"})})
public class UserLanguage extends EntityBase {

  @ManyToOne
  @JoinColumn(name = "language_id")
  private Language language;

  @ManyToOne
  @JoinColumn(name = "user_id")
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