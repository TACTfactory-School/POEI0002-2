package com.example.demo.entities;

import com.example.demo.contracts.HobbieContract;
import com.example.demo.contracts.UserHobbieContract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


/**
 * Hobbies of a User.
 * @author Cedrick Pennec
 */
@Entity
@Table(name = HobbieContract.TABLE)
@AttributeOverride(name = HobbieContract.COL_ID,
        column = @Column(name=HobbieContract.COL_ID))
@AttributeOverride(name = HobbieContract.COL_UPDATED_AT,
        column = @Column(name=HobbieContract.COL_CREATED_AT))
@AttributeOverride(name = HobbieContract.COL_UPDATED_AT,
        column = @Column(name=HobbieContract.COL_UPDATED_AT))
@AttributeOverride(name = HobbieContract.COL_ENABLE,
        column = @Column(name=HobbieContract.COL_ENABLE))
public class Hobbie extends EntityBase{

  /**
 * Label of the Hobby.
 */
@Column(length = HobbieContract.LENGTH, nullable = false, unique = true, name = HobbieContract.COL_LABEL)
  @NotBlank
  private String label;

  /**
 * List of Users associated to the Hobby.
 */
@JsonIgnore
@OneToMany(mappedBy = UserHobbieContract.USER_HOBBIE)
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
