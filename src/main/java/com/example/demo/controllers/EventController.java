package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

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

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventCrudService service;

    @GetMapping
    public List<Event> getAll() {
        return this.service.getAll();
    }

    @PostMapping
    public Event create(@Valid @RequestBody Event event) throws BadRequestException {
        return this.service.create(event);
    }

    /*@PutMapping("{id}")
    public Event update(@PathVariable Long id, @Valid @RequestBody Event event)
            throws BadRequestException, NotFoundException {

        final Event entity = this.service.findById(id)
                .orElseThrow(() -> new NotFoundException());

        // TODO: Use mapper.
        // ObjectMapper mapper = new ObjectMapper();
        // ---------
        entity.setAuthor(event.getAuthor());
        entity.setDescription(event.getDescription());
        entity.setLabel(event.getLabel());

        return this.service.save(entity);
    }*/

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }

    @GetMapping("{id}")
    public Event getOne(@PathVariable Long id) throws NotFoundException {
        return this.service.getOne(id);
    }
}
