package com.example.demo.entities;

import com.example.demo.contracts.HobbieContract;
import com.example.demo.contracts.UserHobbieContract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = HobbieContract.TABLE)
public class Hobbie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = HobbieContract.LENGTH, nullable = false, unique = true)
  @NotBlank
  private String label;

  @JsonIgnore
  @OneToMany(mappedBy = UserHobbieContract.USER_HOBBIE)
  private List<UserHobbie> userHobbies;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(final String label) {
    this.label = label;
  }

  public List<UserHobbie> getUserHobbies() {
    return userHobbies;
  }

  public void setUserHobbies(final List<UserHobbie> userHobbies) {
    this.userHobbies = userHobbies;
  }
}
