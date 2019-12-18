package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


/**
 * Hobbies of a User.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = "ovg_hobbies")
public class Hobbie extends EntityBase{

  /**
 * Label of the Hobby.
 */
@Column(length = 255, nullable = false, unique = true)
  @NotBlank
  private String label;

  /**
 * List of Users associated to the Hobby.
 */
@JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<UserHobbie> userHobbies;

  /**
   * Retrieves the label of the Hobby.
 * @return label the label of the Hobby.
 */
public String getLabel() {
    return label;
  }

  /**
   * Set the label of the Hobby.
 * @param label the label of the Hobby.
 */
public void setLabel(final String label) {
    this.label = label;
  }

  /**
   * Retrieves the List of Users associated to the Hobby.
 * @return the List of Users associated to the Hobby.
 */
public List<UserHobbie> getUserHobbies() {
    return userHobbies;
  }

  /**
   * Set the List of Users associated to the Hobby.
 * @param userHobbies the List of Users associated to the Hobby.
 */
public void setUserHobbies(final List<UserHobbie> userHobbies) {
    this.userHobbies = userHobbies;
  }
}
