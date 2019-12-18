package com.example.demo.entities;

import com.example.demo.contracts.TagEventContract;

import javax.persistence.*;

@Entity
@Table(name = TagEventContract.TABLE,
        uniqueConstraints={@UniqueConstraint(columnNames =
                {TagEventContract.COL_EVENT, TagEventContract.COL_TAG})})
public class TagEvent extends EntityBase {

  @ManyToOne
  @JoinColumn(name = TagEventContract.COL_EVENT)
  private Event event;

  @ManyToOne
  @JoinColumn(name = TagEventContract.COL_TAG)
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
