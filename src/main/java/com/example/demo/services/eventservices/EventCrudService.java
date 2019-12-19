package com.example.demo.services.eventservices;

import com.example.demo.entities.Event;
import com.example.demo.exeptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Event Crud service
 * @author Cedrick Pennec
 */
public interface EventCrudService {

      /**
       * Retrieve all Events according to the pageable parameter.
     * @param pageable Pageable
     * @return Page
     */
    Page getAll(Pageable pageable);

      /**
       * Retrieve an event by its id.
     * @param id long
     * @return Event
     * @throws NotFoundException Event not found.
     */
    Event getOne(long id) throws NotFoundException;

      /**
       * Create an event.
     * @param event Event
     * @return Event
     */
    Event create(Event event);

      /**
       * Update an Event.
     * @param event Event
     * @return Event
     */
    Event update(Event event);

      /**
       * Delete an event by its id.
     * @param id long
     */
    void delete(long id);
}
