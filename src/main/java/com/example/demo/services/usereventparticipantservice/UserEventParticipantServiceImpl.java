package com.example.demo.services.usereventparticipantservice;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.UserEventParticipant;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.UserEventParticipantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Service of the UserEventParticipant Entity.
 * @author Cheikh E.
 */
@Service
public class UserEventParticipantServiceImpl implements UserEventParticipantService {

  /**
   * Repository of a UserEventParticipant.
   */
  @Autowired
  private UserEventParticipantRepository repository;

  /**
   * Get a UserEventParticipant by participant and event.
   * @param user the participant.
   * @param event the event.
   * @return the UserEventParticipant.
   * @throws NotFoundException the UserEventParticipant was not found.
   */
  @Override
  public UserEventParticipant getOne(final User user, final Event event) throws NotFoundException {
    UserEventParticipant result = new UserEventParticipant();
    result = this.repository.getByUserParticipantAndEventParticipant(user, event);
    return result;
  }

  /**
   * Delete a UserEventParticipant.
   * @param userEventParticipant the UserEventParticipant to be deleted.
   */
  @Override
  public void delete(final UserEventParticipant userEventParticipant) {
    this.repository.delete(userEventParticipant);
  }

  /**
   * Persist a UserEventParticipant in the DB.
   * @param userEventParticipant to be saved.
   * @return the UserEventParticipant saved with her id.
   */
  @Override
  public UserEventParticipant save(final UserEventParticipant userEventParticipant) {
    UserEventParticipant result = new UserEventParticipant();
    result = this.repository.save(userEventParticipant);
    return result;
  }
}
