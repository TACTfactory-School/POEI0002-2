package com.example.demo.services.eventservices;

import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Transactional
public class EventCreateService {

  private static final Logger LOGGER = LoggerFactory.getLogger(EventCreateService.class);

  @Autowired
  private EventRepository event;

  Event create(final Event event) {
    LOGGER.debug("Create employee");

    return this.event.save(event);
  }
}
