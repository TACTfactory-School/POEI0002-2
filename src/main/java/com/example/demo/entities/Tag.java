package com.example.demo.entities;

import com.example.demo.contracts.TagContract;
import com.example.demo.contracts.TagEventContract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


/**
 * Tags of an Event.
 * @author ckp
 */
@Entity
@Table(name = TagContract.TABLE)
@AttributeOverride(name = TagContract.COL_ID,
        column = @Column(name=TagContract.COL_ID))
@AttributeOverride(name = TagContract.COL_UPDATED_AT,
        column = @Column(name=TagContract.COL_CREATED_AT))
@AttributeOverride(name = TagContract.COL_UPDATED_AT,
        column = @Column(name=TagContract.COL_UPDATED_AT))
@AttributeOverride(name = TagContract.COL_ENABLE,
        column = @Column(name=TagContract.COL_ENABLE))
public class Tag extends EntityBase{

  /**
 * Label of the tag.
 */
@Column(length = 255, nullable = false, unique = true, name = TagContract.COL_LABEL)
  @NotBlank
  private String label;


  /**
 * List of associations between the Tag and its associated Events.
 */
  @JsonIgnore
  @OneToMany(mappedBy = TagEventContract.TAG)
  private List<TagEvent> tagEvents;

  /**
   * Retrieves the label of the Tag.
 * @return the label of the Tag.
 */
public String getLabel() {
    return label;
  }

  /**
   * Set the label of the Tag.
 * @param label the label of the Tag.
 */
public void setLabel(final String label) {
    this.label = label;
  }

  /**
   * Retrieves the List of associations between the Tag and its associated Events.
 * @return the List of associations between the Tag and its associated Events.
 */
public List<TagEvent> getTagEvents() {
    return tagEvents;
  }

  /**
   * Set the List of associations between the Tag and its associated Events.
 * @param tagEvents the List of associations between the Tag and its associated Events.
 */
public void setTagEvents(final List<TagEvent> tagEvents) {
    this.tagEvents = tagEvents;
  }
}
