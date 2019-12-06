package com.example.demo.services.fixtures;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class EventFixtureService implements Fixture {

    @Autowired
    private EventRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Value("${number.fakeevent:25}")
    int nbFakeEvent;

    @Override
    public void load() {

        Faker faker = new Faker();

        for(int i = 0; i < this.nbFakeEvent; i++) {
            Event event = new Event();
            Long authorId = Long.valueOf(faker.random().nextInt(1,userRepository.findAll().size()));
            User user = userRepository.getOne( authorId);
            event.setAuthor(user);
            event.setCity(faker.address().city());
            event.setDescription(faker.harryPotter().quote());
            event.setTitle(faker.space().constellation());
            event.setDueAt(LocalDateTime.now());
            event.setNbPlace(5);


            this.repository.save(event);
        }
    }
}
