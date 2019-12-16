package com.example.demo.entities;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ovg_user_hobbie")
public class UserHobbie extends EntityBase {

  @ManyToOne(optional = false)
  private Hobbie hobbie;

  @ManyToOne(optional = false)
  private User user;

  public Hobbie getHobbie() {
    return hobbie;
  }

  public void setHobbie(Hobbie hobbie) {
    this.hobbie = hobbie;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


}