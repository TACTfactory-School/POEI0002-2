package com.example.demo.services.eventservices;

import java.util.List;

import com.example.demo.entities.Event;
import com.example.demo.exeptions.NotFoundException;

public interface EventCrudService {

    List<Event> getAll();

    Event getOne(long id) throws NotFoundException;

    Event create(Event event);

    Event update(Event event);

    void delete(long id);
}
