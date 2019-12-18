package com.example.demo.entities;

import com.example.demo.contracts.LanguageContract;
import com.example.demo.contracts.UserLanguageContract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Languages spoken by Users.
 * @author Cedrick Pennec.
 */
@Entity
@Table(name = LanguageContract.TABLE)
@AttributeOverride(name = LanguageContract.COL_ID,
        column = @Column(name =  LanguageContract.COL_ID))
@AttributeOverride(name = LanguageContract.COL_UPDATED_AT,
        column = @Column(name =  LanguageContract.COL_CREATED_AT))
@AttributeOverride(name = LanguageContract.COL_UPDATED_AT,
        column = @Column(name = LanguageContract.COL_UPDATED_AT))
@AttributeOverride(name = LanguageContract.COL_ENABLE,
        column = @Column(name = LanguageContract.COL_ENABLE))
public class Language extends EntityBase {

  /**
   * Label of the Language.
   */
  @Column(length = LanguageContract.LENGTH, nullable = false,
          unique = true, name = LanguageContract.COL_LABEL)
  @NotBlank
  private String label;

  /**
   * List of User associated to this Language.
   */
  @JsonIgnore
  @OneToMany(mappedBy = UserLanguageContract.LANGUAGE)
  private List<UserLanguage> speakers;

  /**
   * Retrieves the label of the Language.
   * @return the label of the Language.
   */
  public String getLabel() {
    return label;
  }

  /**
   * Set the label of the Language.
   * @param label the label of the Language.
   */
  public void setLabel(final String label) {
    this.label = label;
  }

  /**
   * Retrieves the speakers of the Language.
   * @return the speakers of the Language.
   */
  public List<UserLanguage> getSpeakers() {
    return speakers;
  }

  /**
   * Set the speakers of the Language.
   * @param speakers the speakers of the Language.
   */
  public void setSpeakers(final List<UserLanguage> speakers) {
    this.speakers = speakers;
  }
}

