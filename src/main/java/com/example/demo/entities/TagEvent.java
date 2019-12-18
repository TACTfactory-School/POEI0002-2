package com.example.demo.entities;

import javax.persistence.*;

/**
 * Association between Tag and User.
 * @author Cedrick Pennec.
 */
@Entity
@Table(name = "ovg_tag_event",
        uniqueConstraints={@UniqueConstraint(columnNames = {"event_id" , "tag_id"})})
public class TagEvent extends EntityBase {

  /**
 * Event of the association.
 */
@ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  /**
 * Tag of the association.
 */
@ManyToOne
  @JoinColumn(name = "tag_id")
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
