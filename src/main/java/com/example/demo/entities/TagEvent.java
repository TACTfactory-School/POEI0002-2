package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ovg_tag_event")
public class TagEvent extends EntityBase {

    @ManyToOne
    private Event event;
    @ManyToOne
    private Tag tag;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}