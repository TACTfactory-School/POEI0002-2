package com.example.demo.entities;

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
@Table(name = "ovg_tags")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 255, nullable = false, unique = true)
  @NotBlank
  private String label;

  @JsonIgnore
  @OneToMany(mappedBy = "tag")
  private List<TagEvent> tagEvents;

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

  public List<TagEvent> getTagEvents() {
    return tagEvents;
  }

  public void setTagEvents(final List<TagEvent> tagEvents) {
    this.tagEvents = tagEvents;
  }

}
