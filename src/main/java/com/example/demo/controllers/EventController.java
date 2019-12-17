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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Event;
import com.example.demo.exeptions.BadRequestException;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.UserEventParticipantRepository;
import com.example.demo.services.Mapper;
import com.example.demo.services.eventservices.EventCrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/event")
@Api(value = "Event Management System", tags = "Events")
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

  /**
 * @param pageable containing a page number and a number of elements.
 * @return Return a page of users.
 */
@GetMapping("/public")
  @ApiOperation(value = "Retrieves all events")
  public Page<EventDTO> getAll(Pageable pageable) {
    Page<Event> eventPage = this.service.getAll(pageable);
    eventPage.getTotalElements();
    return new PageImpl<>(eventPage.stream()
        .map(event -> mapperDto.eventToDTO(event))
        .collect(Collectors.toList()), pageable, eventPage.getTotalElements());
  }

  /**
 * @param id of an event
 * @return Return a list of users participating to the event with the defined id.
 * @throws NotFoundException
 */
@GetMapping("/public/participants/{id}")
  @ApiOperation(value = "Retrieves all users participating to the event")
  public List<User> getAllParticipants(@PathVariable final Long id) throws NotFoundException {
    Event event = this.service.getOne(id);
    List<UserEventParticipant> evepart = event.getParticipants();
    List<User> result = new ArrayList<>();
    for (UserEventParticipant u : evepart) {
      result.add(u.getUserParticipant());
    }
    return result;
  }

    /**
     * @param id of an event
     * @return Return a list of users organizing the event with the defined id.
     * @throws NotFoundException
     */
    @GetMapping("/public/organisators/{id}")
    @ApiOperation(value = "Retrieves all users organisators to the event")
    public List<User> getAllOrganisators(@PathVariable final Long id) throws NotFoundException {
        Event event = this.service.getOne(id);
        List<UserEventOrganisator> eventOrganisators = event.getOrganisators();
        List<User> result = new ArrayList<>();
        for (UserEventOrganisator u : eventOrganisators) {
            result.add(u.getUserOrganisator());
        }
        return result;
    }

    /**
     * @param id of an event
     * @param username
     *
     * Set a user defined by his username as organizer of an event defined by his id.
     *
     * @throws NotFoundException
     */
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

  /**
 * @param event
 * @return Return the event created.
 * @throws BadRequestException
 * @throws NotFoundException
 */
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

  /**
 * @param id
 * @param eventDTO
 * @return return the event updated
 * @throws BadRequestException
 * @throws NotFoundException
 */
@PutMapping("{id}")
  @ApiOperation(value = "Update an event")
  public Event update(@PathVariable final Long id, @Valid @RequestBody final EventDTO eventDTO)
      throws BadRequestException, NotFoundException {

    final Event event = this.service.getOne(id);
    this.service.update(this.mapperDto.dtoToEvent(event, eventDTO));
    return event;
  }

  /**
 * @param id of an Event
 * @throws NotFoundException
 *
 * Add a user determined by an authentication token, to an event determined by its id.
 */
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

  /**
 * @param id of an Event
 *
 * Delete an event
 */
@DeleteMapping("{id}")
  @ApiOperation(value = "Delete an event")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable final Long id) {
    this.service.delete(id);
  }

  /**
 * @param id
 * @return Return an event
 * @throws NotFoundException
 */
@GetMapping("/public/{id}")
  @ApiOperation(value = "Retrieve an event")
  public EventDTO getOne(@PathVariable final Long id) throws NotFoundException {
    return mapperDto.eventToDTO(this.service.getOne(id));
  }
}
