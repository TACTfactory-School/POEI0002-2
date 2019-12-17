package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.demo.entities.Event;
import com.example.demo.entities.dtos.UserDTO;
import com.example.demo.services.Mapper;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.entities.UserEventParticipant;
import com.example.demo.exeptions.BadRequestException;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.services.userservices.UserCrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/user")
@Api(value = "User Management System", tags = "Users")
public class UserController {

    @Autowired
    private UserCrudService service;

    @Autowired
    private Mapper mapperDto;

    @Autowired
    private ModelMapper mapper;

    /**
     * @param pageable
     * @return Return a Page of user
     */
    @GetMapping("/public")
    @ApiOperation(value = "Retrieves all user")
    public Page<UserDTO> getAll(final Pageable pageable) {
        Page<User> userPage = this.service.getAll(pageable);
        userPage.getTotalElements();
        return new PageImpl<>(userPage.stream()
                .map(user -> mapperDto.userToDto(user))
                .collect(Collectors.toList()), pageable, userPage.getTotalElements());
    }

    /**
     * @param id
     * @return Return a List of Event
     * @throws NotFoundException
     *
     * Retrieves all events the user, determined by its id,  takes part in.
     */
    @GetMapping("/public/participating/{id}")
    @ApiOperation(value = "Retrieves all events the user takes part in.")
    public List<Event> getAllEvents(@PathVariable final Long id) throws NotFoundException {
        User user = this.service.getOne(id);
        List<UserEventParticipant> evepart = user.getAsParticipant();
        List<Event> result = new ArrayList<>();
        for(UserEventParticipant u : evepart) {
            result.add(u.getEventParticipant());
        }
        return result;
    }

    /**
     * @return Return a List of Event
     * @throws BadRequestException
     * @throws NotFoundException
     *
     * Retrieves all events the user, determined by its authentication token, takes part in.
     */
    @GetMapping("/participating")
    @ApiOperation(value = "Retrieves all events the user takes part in.")
    public List<Event> getAllMeEvents() throws BadRequestException, NotFoundException {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        User user = this.service.getByUserName(username);
        List<UserEventParticipant> evepart = user.getAsParticipant();
        List<Event> result = new ArrayList<>();
        for(UserEventParticipant u : evepart) {
            result.add(u.getEventParticipant());
        }
        return result;
    }

    /**
     * @param user
     * @return Return a User
     * @throws BadRequestException
     *
     * Create a new User and return it.
     */
    @PostMapping
    @ApiOperation(value = "Creates a new user")
    @ResponseStatus(value = HttpStatus.CREATED)
    public User create(@Valid @RequestBody final User user) throws BadRequestException {
        return this.service.create(user);
    }



    /**
     * @return Return a User
     * @throws BadRequestException
     * @throws NotFoundException
     *
     * Get the current User, determined by its authentication token.
     */
    @GetMapping("/me")
    @ApiOperation(value = "Get the curent user")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDTO me() throws BadRequestException, NotFoundException {
        UserDTO result = new UserDTO();
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        User user = this.service.getByUserName(username);
        result = mapperDto.userToDto(user);
        return result;
    }

    /**
     * @param id of a User
     *
     * Delete a user, determined by its id.
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete a user")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        this.service.delete(id);
    }

    /**
     * @param id of a User
     * @return Return a User
     * @throws NotFoundException
     *
     * Retrieve a user, determined by its id.
     */
    @GetMapping("/public/{id}")
    @ApiOperation(value = "Retrieve a user")
    public User getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    /**
     * @param userDTO
     * @return Return an updated User
     * @throws BadRequestException
     * @throws NotFoundException
     *
     * Update a User, determined by its authentication token
     */
    @PutMapping("/me/edit")
    @ApiOperation(value = "Update a user")
    public User update(@Valid @RequestBody final UserDTO userDTO)
        throws BadRequestException, NotFoundException {

      Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
      String username = loggedInUser.getName();
      User user = this.service.getByUserName(username);
      this.service.update(this.mapperDto.dtoToUser(user,userDTO));
      System.out.println("");
      return user;
    }

    /**
     * @param id of a User
     * @param User
     * @return Return an updated User.
     * @throws NotFoundException
     *
     * Updates a user, determined by its id.
     */
    @PutMapping("{id}")
    @ApiOperation(value = "Updates a user")
    public User update(@PathVariable final Long id, @Valid @RequestBody final User user)
            throws NotFoundException {
        final User entity = this.service.getOne(id);

        this.mapper.map(user, entity);
        this.service.update(entity);

        return entity;
    }

}
