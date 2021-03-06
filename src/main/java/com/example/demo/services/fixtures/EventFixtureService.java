package com.example.demo.services.fixtures;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Event fixtures.
 * @author Cedrick Pennec
 */
@Component
public class EventFixtureService implements Fixture {

  /**
 * Event repository.
 */
@Autowired
  private EventRepository repository;

  /**
 * User repository.
 */
@Autowired
  private UserRepository userRepository;

  /**
 * Number of fake events to create. 25 by default.
 */
@Value("${number.fakeevent:25}")
  int nbFakeEvent;

  /**
 * Load the fakers.
 */
@Override
  public void load() {

    Faker faker = new Faker();
    Random rand = new Random();

    for (int i = 0; i < this.nbFakeEvent; i++) {

      String photo = Integer.toString(rand.nextInt(6)) + ".jpg";
      Event event = new Event();
      Long authorId = Long.valueOf(faker.random().nextInt(1, userRepository.findAll().size()));
      User user = userRepository.getOne(authorId);
      event.setAuthor(user);
      event.setCity(faker.address().city());
      event.setDescription(faker.harryPotter().quote());
      event.setTitle(faker.esports().game());
      event.setDueAt(LocalDateTime.now());
      event.setNbPlace(rand.nextInt(20)+2);
      event.setPhoto(photo);

      this.repository.save(event);
    }
  }
}
