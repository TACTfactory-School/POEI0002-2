package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "ovg_user_hobbie",
        uniqueConstraints={@UniqueConstraint(columnNames = {"hobbie_id" , "user_id"})})
public class UserHobbie extends EntityBase {

  @ManyToOne(optional = false)
  @JoinColumn(name = "hobbie_id")
  private Hobbie hobbie;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id")
  private User user;

  public Hobbie getHobbie() {
    return hobbie;
  }

  public void setHobbie(final Hobbie hobbie) {
    this.hobbie = hobbie;
  }

  public User getUser() {
    return user;
  }

  public void setUser(final User user) {
    this.user = user;
  }
}
