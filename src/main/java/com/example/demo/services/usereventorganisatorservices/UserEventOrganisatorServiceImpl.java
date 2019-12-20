package com.example.demo.services.usereventorganisatorservices;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.UserEventOrganisator;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.UserEventOrganisatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Service of the UserEventOrganisator Entity.
 * @author Cheikh E.
 */
@Service
public class UserEventOrganisatorServiceImpl implements UserEventOrganisatorService {

  /**
   * Repository of a UserEventOrganisator.
   */
  @Autowired
  private UserEventOrganisatorRepository repository;

  /**
   * Get a UserEventOrganisator by organisator and event.
   * @param user the organisator.
   * @param event the event.
   * @return the UserEventOrganisator.
   * @throws NotFoundException the UserEventOrganisator was not found.
   */
  @Override
  public UserEventOrganisator getOne(final User user, final Event event) throws NotFoundException {
    return this.repository.getByUserOrganisatorAndEventOrganisator(user, event);
  }

  /**
   * Delete a UserEventOrganisator.
   * @param userEventOrganisator the UserEventOrganisator to be deleted.
   */
  @Override
  public void delete(final UserEventOrganisator userEventOrganisator) {
    repository.delete(userEventOrganisator);
  }

  /**
   * Persist a UserEventOrganisator in the DB.
   * @param userEventOrganisator to be saved.
   * @return the UserEventOrganisator saved with her id.
   */
  @Override
  public UserEventOrganisator save(final UserEventOrganisator userEventOrganisator) {
    return this.repository.save(userEventOrganisator);
  }
}
