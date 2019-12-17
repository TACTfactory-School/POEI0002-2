package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "ovg_tag_event",
        uniqueConstraints={@UniqueConstraint(columnNames = {"event_id" , "tag_id"})})
public class TagEvent extends EntityBase {

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  @ManyToOne
  @JoinColumn(name = "tag_id")
  private Tag tag;

  public Event getEvent() {
    return event;
  }

  public void setEvent(final Event event) {
    this.event = event;
  }

  public Tag getTag() {
    return tag;
  }

  public void setTag(final Tag tag) {
    this.tag = tag;
  }
}
