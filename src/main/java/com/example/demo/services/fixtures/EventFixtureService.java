package com.example.demo.services.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;
import com.github.javafaker.Faker;

@Component
public class EventFixtureService implements Fixture {

    @Autowired
    private EventRepository repository;

    @Value("${number.fakeevent:25}")
    int nbFakeEvent;

    @Override
    public void load() {
    this.repository.save(event);


//        Faker faker = new Faker();
//
//        for(int i = 0; i < this.nbFakeEvent; i++) {
//            Event event = new Event();
//
//            event.setLabel("bar");
//            event.setAuthor("John");
//            event.setDescription("bar du 15eme");
//
//            this.repository.save(event);
//        }
    }
}
