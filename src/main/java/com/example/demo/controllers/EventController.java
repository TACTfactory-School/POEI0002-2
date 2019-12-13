package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.demo.entities.User;
import com.example.demo.entities.dtos.EventDTO;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Event;
import com.example.demo.exeptions.BadRequestException;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.services.Mapper;
import com.example.demo.services.eventservices.EventCrudService;

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
    private ModelMapper mapper;

    @Autowired
    private Mapper mapperDto;

    @GetMapping
    @ApiOperation(value = "Retrieves all events")
    public Page<EventDTO> getAll(Pageable pageable){
        Page<Event> eventPage = this.service.getAll(pageable);
        eventPage.getTotalElements();
        return new PageImpl<>(eventPage.stream()
                .map(event->mapperDto.eventToDTO(event))
                .collect(Collectors.toList()), pageable, eventPage.getTotalElements());
    }

    @PostMapping
    @ApiOperation(value = "Create an event")
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@Valid @RequestBody final Event event) throws BadRequestException, NotFoundException {
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

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete an event")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        this.service.delete(id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Retrieve an event")
    public EventDTO getOne(@PathVariable final Long id) throws NotFoundException {
        return mapperDto.eventToDTO(this.service.getOne(id));
    }
}
