package com.example.demo.entities;

import com.example.demo.contracts.EventContract;
import com.example.demo.contracts.TagEventContract;
import com.example.demo.contracts.UserEventOrganisatorContract;
import com.example.demo.contracts.UserEventParticipantContract;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = EventContract.TABLE)
@AttributeOverride(name = EventContract.COL_ID,
        column = @Column(name=EventContract.COL_ID))
@AttributeOverride(name = EventContract.COL_UPDATED_AT,
        column = @Column(name=EventContract.COL_CREATED_AT))
@AttributeOverride(name = EventContract.COL_UPDATED_AT,
        column = @Column(name=EventContract.COL_UPDATED_AT))
@AttributeOverride(name = EventContract.COL_ENABLE,
        column = @Column(name=EventContract.COL_ENABLE))
public class Event extends EntityBase {

  @ManyToOne(optional = false)
  private User author;

  @Column(length = EventContract.STRING_LENGTH, nullable = false)
  @NotBlank
  private String title;

  @Column(length = EventContract.DESC_LENGTH, nullable = false)
  @NotBlank
  private String description;

  @Column(nullable = false)
  private LocalDateTime dueAt;

  @Column(nullable = false)
  private Integer nbPlace;

  @Column(length = EventContract.STRING_LENGTH, nullable = true)
  private String photo;

  @Column(length = EventContract.STRING_LENGTH, nullable = true)
  private String adresse;

  @Column(nullable = true)
  private Integer cp;

  @Column(length = EventContract.STRING_LENGTH, nullable = false)
  @NotBlank
  private String city;

  @JsonIgnore
  @OneToMany(mappedBy = TagEventContract.EVENT)
  private List<TagEvent> tagEvents;

  @JsonIgnore
  @OneToMany(mappedBy = UserEventParticipantContract.EVENT_PARTICIPANT)
  private List<UserEventParticipant> participants;

  @JsonIgnore
  @OneToMany(mappedBy = UserEventOrganisatorContract.EVENT_ORGANISATOR)
  private List<UserEventOrganisator> organisators;

  public User getAuthor() {
    return author;
  }

  public void setAuthor(final User author) {
    this.author = author;
  }

  public List<TagEvent> getTagEvents() {
    return tagEvents;
  }

  public void setTagEvents(List<TagEvent> tagEvents) {
    this.tagEvents = tagEvents;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public LocalDateTime getDueAt() {
    return dueAt;
  }

  public void setDueAt(final LocalDateTime dueAt) {
    this.dueAt = dueAt;
  }

  public Integer getNbPlace() {
    return nbPlace;
  }

  public void setNbPlace(final Integer nbPlace) {
    this.nbPlace = nbPlace;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(final String photo) {
    this.photo = photo;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(final String adresse) {
    this.adresse = adresse;
  }

  public Integer getCp() {
    return cp;
  }

  public void setCp(final Integer cp) {
    this.cp = cp;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public List<UserEventOrganisator> getOrganisators() {
    return organisators;
  }

  public void setOrganisators(final List<UserEventOrganisator> organisators) {
    this.organisators = organisators;
  }

  public List<UserEventParticipant> getParticipants() {
    return participants;
  }

  public void setParticipants(final List<UserEventParticipant> participants) {
    this.participants = participants;
  }

  public void addParticipant(final UserEventParticipant usereventparticipant) {
    this.participants.add(usereventparticipant);
  }

}
