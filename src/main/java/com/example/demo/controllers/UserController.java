package com.example.demo.controllers;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.UserEventParticipant;
import com.example.demo.entities.dtos.UserDto;
import com.example.demo.exeptions.BadRequestException;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.services.Mapper;
import com.example.demo.services.userservices.UserCrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of the User entity.
 *
 * @author Cedrick Pennec
 */
@RestController
@RequestMapping("api/v1/user")
@Api(value = "User Management System", tags = "Users")
public class UserController {

  /**
   * CRUD service of a User.
   */
  @Autowired
  private UserCrudService service;

  /**
   * Mapper used to convert entities to their DTO.
   */
  @Autowired
  private Mapper mapperDto;

  /**
   * Retrieves all users according to the specified page.
   *
   * @param pageable contains the page number and the number of elements per page.
   * @return Return a Page of user
   */
  @GetMapping("/public")
  @ApiOperation(value = "Retrieves all users according to the specified page")
  public Page<UserDto> getAll(final Pageable pageable) {
    Page<User> userPage = this.service.getAll(pageable);
    userPage.getTotalElements();
    return new PageImpl<>(userPage.stream()
      .map(user -> mapperDto.userToDto(user))
      .collect(Collectors.toList()), pageable, userPage.getTotalElements());
  }

  /**
   * Retrieves all events the user, determined by its id,  takes part in.
   *
   * @param id of a User
   * @return Return a List of Event
   * @throws NotFoundException User was not found.
   */
  @GetMapping("/public/participating/{id}")
  @ApiOperation(value = "Retrieves all events the user takes part in.")
  public List<Event> getAllEvents(@PathVariable final Long id) throws NotFoundException {
    User user = this.service.getOne(id);
    List<UserEventParticipant> evepart = user.getAsParticipant();
    List<Event> result = new ArrayList<>();
    for (UserEventParticipant u : evepart) {
      result.add(u.getEventParticipant());
    }
    return result;
  }

  /**
   * Retrieves all events the user, determined by its authentication token, takes part in.
   *
   * @return Return a List of Event
   * @throws NotFoundException   User was not found.
   * @throws BadRequestException Bad request.
   */
  @GetMapping("/participating")
  @ApiOperation(value = "Retrieves all events the user takes part in.")
  public List<Event> getAllMeEvents() throws BadRequestException, NotFoundException {
    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String username = loggedInUser.getName();
    User user = this.service.getByUserName(username);
    List<UserEventParticipant> evepart = user.getAsParticipant();
    List<Event> result = new ArrayList<>();
    for (UserEventParticipant u : evepart) {
      result.add(u.getEventParticipant());
    }
    return result;
  }

  /**
   * Create a new User and return it.
   *
   * @param user User to be created
   * @return Return a User
   * @throws BadRequestException Bad request
   */
  @PostMapping
  @ApiOperation(value = "Creates a new user")
  @ResponseStatus(value = HttpStatus.CREATED)
  public User create(@Valid @RequestBody final User user) throws BadRequestException {
    return this.service.create(user);
  }


  /**
   * Get the current User, determined by its authentication token.
   *
   * @return Return a User
   * @throws NotFoundException   User was not found.
   * @throws BadRequestException Bad request.
   */
  @GetMapping("/me")
  @ApiOperation(value = "Get the curent user")
  @ResponseStatus(value = HttpStatus.OK)
  public UserDto me() throws BadRequestException, NotFoundException {
    UserDto result = new UserDto();
    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String username = loggedInUser.getName();
    User user = this.service.getByUserName(username);
    result = mapperDto.userToDto(user);
    return result;
  }

  /**
   * Delete a user, determined by its id.
   *
   * @param id of a User
   */
  @DeleteMapping("{id}")
  @ApiOperation(value = "Delete a user")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable final Long id) {
    this.service.delete(id);
  }

  /**
   * Retrieve a user, determined by its id.
   *
   * @param id of a User
   * @return Return a User
   * @throws NotFoundException User was not found.
   */
  @GetMapping("/public/{id}")
  @ApiOperation(value = "Retrieve a user")
  public UserDto getOne(@PathVariable final Long id) throws NotFoundException {
    return mapperDto.userToDto(this.service.getOne(id));
  }

  /**
   * Update a User, determined by its authentication token.
   *
   * @param userDto DTO of a user.
   * @return Return an updated User
   * @throws NotFoundException   User was not found.
   * @throws BadRequestException Bad request.
   */
  @PutMapping("/me/edit")
  @ApiOperation(value = "Update a user")
  public User update(@Valid @RequestBody final UserDto userDto)
      throws BadRequestException, NotFoundException {

    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String username = loggedInUser.getName();
    User user = this.service.getByUserName(username);
    user = this.mapperDto.dtoToUser(user, userDto);
    this.service.update(user);
    return user;
  }

  /**
   * Updates a user, determined by its id.
   *
   * @param id      of a User
   * @param userDto DTO of a User.
   * @return Return an updated User.
   * @throws NotFoundException User was not found.
   */
  @PutMapping("{id}")
  @ApiOperation(value = "Updates a user")
  public User update(@PathVariable final Long id, @Valid @RequestBody final UserDto userDto)
      throws NotFoundException {
    User entity = this.service.getOne(id);

    System.out.println(userDto.getBirthDate());

    entity = this.mapperDto.dtoToUser(entity, userDto);
    this.service.update(entity);

    return entity;
  }

}
