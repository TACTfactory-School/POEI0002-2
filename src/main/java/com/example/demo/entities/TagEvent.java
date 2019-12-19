package com.example.demo.entities;

import com.example.demo.contracts.TagEventContract;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Association between Tag and User.
 * @author Cedrick Pennec.
 */
@Entity
@Table(name = TagEventContract.TABLE,
        uniqueConstraints = {@UniqueConstraint(columnNames =
                {TagEventContract.COL_EVENT, TagEventContract.COL_TAG})})
public class TagEvent extends EntityBase {


  /**
 * Event of the association.
 */
  @ManyToOne
  @JoinColumn(name = TagEventContract.COL_EVENT)
  private Event event;

  /**
 * Tag of the association.
 */
  @ManyToOne
  @JoinColumn(name = TagEventContract.COL_TAG)
  private Tag tag;

  /**
   * Retrieve the Event of the Association.
 * @return the Event of the Association.
 */
  public Event getEvent() {
    return event;
  }

  /**
   * Set the Event of the Association.
 * @param event the Event of the Association.
 */
  public void setEvent(final Event event) {
    this.event = event;
  }

  /**
   * Retrieves the Tag of the association.
 * @return the Tag of the association.
 */
  public Tag getTag() {
    return tag;
  }

  /**
   * Set the Tag of the association.
 * @param tag the Tag of the association.
 */
  public void setTag(final Tag tag) {
    this.tag = tag;
  }
}
