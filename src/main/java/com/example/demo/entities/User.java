package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ovg_user")
public class User extends EntityBase {

    private static final int LENGTH = 255;

    @Column(length = LENGTH, nullable = false)
    @NotBlank
    private String username;

    @Column(length = LENGTH, nullable = false)
    @NotBlank
    private String password;

    @Column(length = LENGTH, nullable = false)
    @NotBlank
    private String city;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String sex;

    @Column(nullable = true)
    private String picture;

    @Column(nullable = true)
    private String maritalStatus;

    @Column(nullable = true)
    private LocalDateTime birthDate;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private LocalDateTime subscriptionDate;

    @Column(nullable = true)
    private LocalDateTime lastConnectionDate;

    @Column(nullable = true)
    private String profession;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "asc_friendship_table", joinColumns = { @JoinColumn(name = "friend1_id") }, inverseJoinColumns = {
            @JoinColumn(name = "friend2_id") })
    private List<User> friends;

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "asc_events", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "event_id") })
    private List<Event> events;

    @OneToMany(mappedBy = "author")
    private List<Event> eventsAsCreator;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "asc_eventsAsOrganisator", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "event_id") })
    private List<Event> eventsAsOrganisator;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "asc_hobbies", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "hobbie_id") })
    private List<Hobbie> hobbies;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "asc_languages", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "language_id") })
    private List<Language> languages;

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEventsAsCreator() {
        return eventsAsCreator;
    }

    public void setEventsAsCreator(List<Event> eventsAsCreator) {
        this.eventsAsCreator = eventsAsCreator;
    }

    public List<Event> getEventsAsOrganisator() {
        return eventsAsOrganisator;
    }

    public void setEventsAsOrganisator(List<Event> eventsAsOrganisator) {
        this.eventsAsOrganisator = eventsAsOrganisator;
    }

    public List<Hobbie> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobbie> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public LocalDateTime getLastConnectionDate() {
        return lastConnectionDate;
    }

    public void setLastConnectionDate(LocalDateTime lastConnectionDate) {
        this.lastConnectionDate = lastConnectionDate;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

}
