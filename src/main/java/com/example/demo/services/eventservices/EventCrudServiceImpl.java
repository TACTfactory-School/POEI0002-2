package com.example.demo.services.eventservices;

import com.example.demo.entities.Event;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Event crud service implementation.
 * @author Cedrick Pennec
 */
@Service
public class EventCrudServiceImpl implements EventCrudService {

  /**
 * EventRepository
 */
@Autowired
  private EventRepository repository;

  /**
 * EventCreateService
 */
@Autowired
  private EventCreateService createService;

  /**
   * Retrieve all Events according to the pageable parameter.
   * @param pageable Pageable
   * @return Page
  */
@Transactional(readOnly = true)
  @Override
  public Page getAll(final Pageable pageable) {

    Page pagedResult = this.repository.findAll(pageable);

    if (pagedResult.hasContent()) {
      return pagedResult;
    } else {
      return null;
    }
  }

    /**
     * Retrieve an event by its id.
    * @param id long
    * @return Event
    * @throws NotFoundException Event not found.
    */
@Transactional(readOnly = true)
  @Override
  public Event getOne(final long id) throws NotFoundException {
    return this.repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException());
  }

    /**
     * Create an event.
    * @param event Event
    * @return Event
    */
  @Transactional()
  @Override
  public Event create(final Event event) {
    return this.createService.create(event);
  }

  /**
   * Update an Event.
 * @param event Event
 * @return Event
 */
  @Override
  public Event update(final Event event) {
    return this.repository.save(event);
  }

  /**
   * Delete an event by its id.
 * @param id long
 */
  @Override
  public void delete(final long id) {
    this.repository.deleteById(id);
  }
}
