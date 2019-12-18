package com.example.demo.repository;

import com.example.demo.entities.UserEventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository of the UserEventParticipant Entity.
 * @author Cedrick Pennec.
 */
public interface UserEventParticipantRepository extends JpaRepository<UserEventParticipant, Long> {

}
