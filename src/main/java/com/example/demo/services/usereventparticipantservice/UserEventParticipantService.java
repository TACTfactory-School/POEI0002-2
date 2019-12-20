package com.example.demo.services.usereventparticipantservice;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.UserEventParticipant;
import com.example.demo.exeptions.NotFoundException;

/**
 * The interface to be implemented by the Service of
 * the UserEventParticipant Entity.
 * @author Cheikh E.
 */
public interface UserEventParticipantService {
  /**
   * Get a UserEventParticipant by participant and event.
   * @param user the participant.
   * @param event the event.
   * @return the UserEventParticipant.
   * @throws NotFoundException the UserEventParticipant was not found.
   */
  UserEventParticipant getOne(User user, Event event) throws NotFoundException;

  /**
   * Delete a UserEventParticipant.
   * @param userEventParticipant the UserEventParticipant to be deleted.
   */
  void delete(UserEventParticipant userEventParticipant);

  /**
   * Persist a UserEventParticipant in the DB.
   * @param userEventParticipant to be saved.
   * @return the UserEventParticipant saved with her id.
   */
  UserEventParticipant save(UserEventParticipant userEventParticipant);
}
