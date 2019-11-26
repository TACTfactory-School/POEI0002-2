package com.example.demo.services.eventservices;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Event;
import com.example.demo.repository.EventRepository;

@Component
@Transactional
public class EventCreateService {

    private static final Logger logger = LoggerFactory.getLogger(EventCreateService.class);

    @Autowired
    private EventRepository event;

    Event create(final Event event) {
        logger.debug("Create employee");

        return this.event.save(event);
    }
}
