package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ovg_event")
public class Event extends EntityBase {

  @ManyToOne(optional = false)
  private User author;

  static final int LENGTH = 255;

  @Column(length = LENGTH, nullable = false)
  @NotBlank
  private String title;

  @Column(length = 5000, nullable = false)
  @NotBlank
  private String description;

  @Column(nullable = false)
  private LocalDateTime dueAt;

  @Column(nullable = false)
  private Integer nbPlace;

  @Column(length = LENGTH, nullable = true)
  private String photo;

  @Column(length = LENGTH, nullable = true)
  private String adresse;

  @Column(nullable = true) //modifier en cp pour checkstyle
  private Integer Cp;

  @Column(length = LENGTH, nullable = false)
  @NotBlank
  private String city;

  @JsonIgnore
  @OneToMany(mappedBy = "event")
  private List<TagEvent> tagEvents;

  @JsonIgnore
  @OneToMany(mappedBy = "eventParticipant")
  private List<UserEventParticipant> participants;

  @JsonIgnore
  @OneToMany(mappedBy = "eventOrganisator")
  private List<UserEventOrganisator> organisators;

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
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

  public void setTitle(String title) {
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

  public void setDueAt(LocalDateTime dueAt) {
    this.dueAt = dueAt;
  }

  public Integer getNbPlace() {
    return nbPlace;
  }

  public void setNbPlace(Integer nbPlace) {
    this.nbPlace = nbPlace;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public Integer getCp() {
    return Cp;
  }

  public void setCp(Integer cP) {
    Cp = cP;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<UserEventOrganisator> getOrganisators() {
    return organisators;
  }

  public void setOrganisators(List<UserEventOrganisator> organisators) {
    this.organisators = organisators;
  }

  public List<UserEventParticipant> getParticipants() {
    return participants;
  }

  public void setParticipants(List<UserEventParticipant> participants) {
    this.participants = participants;
  }

  public void addParticipant(UserEventParticipant usereventparticipant) {
    this.participants.add(usereventparticipant);
  }

}
