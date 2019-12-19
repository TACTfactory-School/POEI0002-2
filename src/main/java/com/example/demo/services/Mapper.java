package com.example.demo.services;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.dtos.EventDto;
import com.example.demo.entities.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

  public UserDto userToDto(final User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setUsername(user.getUsername());
    userDto.setCity(user.getCity());
    userDto.setName(user.getName());
    userDto.setEmail(user.getEmail());
    userDto.setSex(user.getSex());
    userDto.setPicture(user.getPicture());
    userDto.setMaritalStatus(user.getMaritalStatus());
    userDto.setBirthDate(user.getBirthDate());
    userDto.setDescription(user.getDescription());
    userDto.setLastConnectionDate(user.getLastConnectionDate());
    userDto.setProfession(user.getProfession());
    userDto.setLastConnectionDate(user.getLastConnectionDate());
    userDto.setCreatedAt(user.getCreatedAt());
    userDto.setUpdatedAt(user.getUpdatedAt());
    userDto.setMaritalStatus(user.getMaritalStatus());
    return userDto;
  }

  public EventDto eventToDto(final Event event) {
    EventDto result = new EventDto();
    result.setId(event.getId());
    result.setAuthor(event.getAuthor().getUsername());
    result.setTitle(event.getTitle());
    result.setCity(event.getCity());
    result.setDescription(event.getDescription());
    result.setDueAt(event.getDueAt());
    result.setNbPlace(event.getNbPlace());
    result.setAdresse(event.getAdresse());
    result.setPhoto(event.getPhoto());
    result.setCp(event.getCp());
    return result;
  }

  public Event dtoToEvent(final Event event, final EventDto eventDto) {
    event.setId(eventDto.getId());
    event.setTitle(eventDto.getTitle());
    event.setCity(eventDto.getCity());
    event.setDescription(eventDto.getDescription());
    event.setDueAt(eventDto.getDueAt());
    event.setNbPlace(eventDto.getNbPlace());
    event.setAdresse(eventDto.getAdresse());
    event.setPhoto(eventDto.getPhoto());
    event.setCp(eventDto.getCp());
    return event;
  }

  public User dtoToUser(final User user, final UserDto userDto) {
    user.setUsername(userDto.getUsername());
    user.setCity(userDto.getCity());
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setSex(userDto.getSex());
    user.setPicture(userDto.getPicture());
    user.setMaritalStatus(userDto.getMaritalStatus());
    user.setBirthDate(userDto.getBirthDate());
    user.setDescription(userDto.getDescription());
    user.setProfession(userDto.getProfession());
    user.setLastConnectionDate(userDto.getLastConnectionDate());
    user.setMaritalStatus(userDto.getMaritalStatus());
    return user;
  }
}
