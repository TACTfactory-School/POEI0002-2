package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.demo.entities.User;
import com.example.demo.entities.UserEventOrganisator;
import com.example.demo.entities.UserEventParticipant;
import com.example.demo.entities.dtos.EventDTO;
import com.example.demo.repository.UserEventOrganisatorRepository;
import com.example.demo.services.userservices.UserCrudService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.UserEventParticipant;
import com.example.demo.entities.dtos.EventDTO;
import com.example.demo.exeptions.BadRequestException;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.UserEventParticipantRepository;
import com.example.demo.services.Mapper;
import com.example.demo.services.eventservices.EventCrudService;
import com.example.demo.services.userservices.UserCrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/event")
@Api(value="Event Management System", tags = "Events")
public class EventController {


  @Autowired
  private EventCrudService service;

  @Autowired
  private UserCrudService userService;

  @Autowired
  private UserEventParticipantRepository eventParticipantRepository;
      
  @Autowired
  private UserEventOrganisatorRepository eventOrganisatorRepository;

  @Autowired
  private ModelMapper mapper;

  @Autowired
  private Mapper mapperDto;

  @GetMapping("/public")
  @ApiOperation(value = "Retrieves all events")
  public Page<EventDTO> getAll(Pageable pageable){
    Page<Event> eventPage = this.service.getAll(pageable);
    eventPage.getTotalElements();
    return new PageImpl<>(eventPage.stream()
        .map(event->mapperDto.eventToDTO(event))
        .collect(Collectors.toList()), pageable, eventPage.getTotalElements());
  }

  @GetMapping("/public/participants/{id}")
  @ApiOperation(value = "Retrieves all users participating to the event")
  public List<User> getAllParticipants(@PathVariable final Long id) throws NotFoundException{
    Event event = this.service.getOne(id);
    List<UserEventParticipant> evepart = event.getParticipants();
    List<User> result = new ArrayList<>();
    for(UserEventParticipant u : evepart) {
      result.add(u.getUserParticipant());
    }
    return result;
  }
      
    @GetMapping("/public/organisators/{id}")
    @ApiOperation(value = "Retrieves all users organisators to the event")
    public List<User> getAllOrganisators(@PathVariable final Long id) throws NotFoundException{
        Event event = this.service.getOne(id);
        List<UserEventOrganisator> eventOrganisators = event.getOrganisators();
        List<User> result = new ArrayList<>();
        for(UserEventOrganisator u : eventOrganisators) {
            result.add(u.getUserOrganisator());
        }
        return result;
    }

    @PostMapping("/organisators")
    @ApiOperation(value = "Add a user as organizer of an event")
    public void addOrganisator(@RequestParam(value = "id") final Long id,
                                     @RequestParam(value = "username") final String username) throws NotFoundException {
        User user = this.userService.getByUserName(username);
        Event event = this.service.getOne(id);
        UserEventOrganisator userEventOrganisator = new UserEventOrganisator();
        userEventOrganisator.setEventOrganisator(event);
        userEventOrganisator.setUserOrganisator(user);

        this.eventOrganisatorRepository.save(userEventOrganisator);
    }

  @PostMapping
  @ApiOperation(value = "Create an event")
  @ResponseStatus(HttpStatus.CREATED)
  public Event create(@Valid @RequestBody final Event event)
      throws BadRequestException, NotFoundException {
    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String username = loggedInUser.getName();
    User user = this.userService.getByUserName(username);
    event.setAuthor(user);
    return this.service.create(event);
  }

  @PutMapping("{id}")
  @ApiOperation(value = "Update an event")
  public Event update(@PathVariable final Long id, @Valid @RequestBody final Event event)
      throws BadRequestException, NotFoundException {

    final Event entity = this.service.getOne(id);

    this.mapper.map(event, entity);
    this.service.update(entity);

    return entity;
  }

  @GetMapping("/join/{id}")
  @ApiOperation(value = "Add a user to an event as participant")
  public void join(@PathVariable final Long id) throws NotFoundException {
    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String username = loggedInUser.getName();
    User user = this.userService.getByUserName(username);
    Event event = this.service.getOne(id);

    UserEventParticipant usereventpart = new UserEventParticipant();
    usereventpart.setUserParticipant(user);
    usereventpart.setEventParticipant(event);

    this.eventParticipantRepository.save(usereventpart);

    user.addAsParticipant(usereventpart);
    this.userService.update(user);

    event.addParticipant(usereventpart);
    this.service.update(event);

  }

  @DeleteMapping("{id}")
  @ApiOperation(value = "Delete an event")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable final Long id) {
    this.service.delete(id);
  }

  @GetMapping("/public/{id}")
  @ApiOperation(value = "Retrieve an event")
  public EventDTO getOne(@PathVariable final Long id) throws NotFoundException {
    return mapperDto.eventToDTO(this.service.getOne(id));
  }
}
