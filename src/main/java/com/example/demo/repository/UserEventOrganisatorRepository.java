package com.example.demo.repository;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.UserEventOrganisator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository of the UserEventOrganisator Entity.
 * @author Cedrick Pennec.
 */
public interface UserEventOrganisatorRepository extends JpaRepository<UserEventOrganisator, Long> {
  UserEventOrganisator getByUserOrganisatorAndEventOrganisator(User user, Event event);
}
