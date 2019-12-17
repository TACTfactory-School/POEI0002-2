package com.example.demo.services;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.dtos.EventDTO;
import com.example.demo.entities.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

  public UserDTO userToDto(final User user) {

    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setUsername(user.getUsername());
    userDTO.setCity(user.getCity());
    userDTO.setName(user.getName());
    userDTO.setEmail(user.getEmail());
    userDTO.setSex(user.getSex());
    userDTO.setPicture(user.getPicture());
    userDTO.setMaritalStatus(user.getMaritalStatus());
    userDTO.setBirthDate(user.getBirthDate());
    userDTO.setDescription(user.getDescription());
    userDTO.setLastConnectionDate(user.getLastConnectionDate());
    userDTO.setProfession(user.getProfession());
    return userDTO;
  }
  public EventDTO eventToDTO(final Event event) {
    EventDTO result = new EventDTO();
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

  public Event dtoToEvent(final Event event, final EventDTO eventDTO) {
    event.setId(eventDTO.getId());
    event.setTitle(eventDTO.getTitle());
    event.setCity(eventDTO.getCity());
    event.setDescription(eventDTO.getDescription());
    event.setDueAt(eventDTO.getDueAt());
    event.setNbPlace(eventDTO.getNbPlace());
    event.setAdresse(eventDTO.getAdresse());
    event.setPhoto(eventDTO.getPhoto());
    event.setCp(eventDTO.getCp());
    return event;
  }

  public User dtoToUser(final User user, final UserDTO userDTO) {
      user.setId(userDTO.getId());
      user.setUsername(userDTO.getUsername());
      user.setCity(userDTO.getCity());
      user.setName(userDTO.getName());
      user.setEmail(userDTO.getEmail());
      user.setSex(userDTO.getSex());
      user.setPicture(userDTO.getPicture());
      user.setMaritalStatus(userDTO.getMaritalStatus());
      user.setBirthDate(userDTO.getBirthDate());
      user.setDescription(userDTO.getDescription());
      user.setLastConnectionDate(userDTO.getLastConnectionDate());
      user.setProfession(userDTO.getProfession());
      return user;
  }
}
