package com.example.demo.services.eventservices;

import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * Creation event service.
 * @author Cedrick Pennec
 */
@Component
@Transactional
public class EventCreateService {

  private static final Logger LOGGER = LoggerFactory.getLogger(EventCreateService.class);

  /**
 * EventRepository
 */
@Autowired
  private EventRepository event;

  /**
   * Create an event and return it.
 * @param event Event
 * @return Event
 */
Event create(final Event event) {
    LOGGER.debug("Create employee");

    return this.event.save(event);
  }
}
