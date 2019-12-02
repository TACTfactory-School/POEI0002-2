package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.demo.services.eventservices.EventCrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("event")
@Api(value="Event Management System", tags = "Events")
public class EventController {

    @Autowired
    private EventCrudService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @ApiOperation(value = "Retrieves all events")
    public List<Event> getAll() {
        return this.service.getAll();
    }

    @PostMapping
    @ApiOperation(value = "Create an event")
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@Valid @RequestBody final Event event) throws BadRequestException {
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
    public Event getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }
}
