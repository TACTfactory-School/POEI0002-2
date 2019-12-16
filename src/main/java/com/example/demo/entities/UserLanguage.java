package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ovg_user_language")
public class UserLanguage extends EntityBase {

  @ManyToOne
  private Language language;

  @ManyToOne
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