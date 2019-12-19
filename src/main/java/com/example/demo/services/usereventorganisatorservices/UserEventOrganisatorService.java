package com.example.demo.services.usereventorganisatorservices;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.UserEventOrganisator;

import com.example.demo.exeptions.NotFoundException;

/**
 * The interface to be implemented by the Service of
 * the UserEventOrganisator Entity.
 * @author Cheikh E.
 */
public interface UserEventOrganisatorService {
  /**
   * Get a UserEventOrganisator by organisator and event.
   * @param user the organisator.
   * @param event the event.
   * @return the UserEventOrganisator.
   * @throws NotFoundException the UserEventOrganisator was not found.
   */
  UserEventOrganisator getOne(User user, Event event) throws NotFoundException;

  /**
   * Delete a UserEventOrganisator.
   * @param userEventOrganisator the UserEventOrganisator to be deleted.
   */
  void delete(UserEventOrganisator userEventOrganisator);

  /**
   * Persist a UserEventOrganisator in the DB.
   * @param userEventOrganisator to be saved.
   * @return the UserEventOrganisator saved with her id.
   */
  UserEventOrganisator save(UserEventOrganisator userEventOrganisator);
}
