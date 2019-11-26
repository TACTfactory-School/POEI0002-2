package com.example.demo.services.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;

@Component
public class EventFixtureService implements Fixture {

    @Autowired
    private EventRepository repository;

    @Override
    public void load() {
        Event event = new Event();

        event.setLabel("bar");
        event.setAuthor("John");
        event.setDescription("bar du 15eme");


        this.repository.save(event);
    }
}
