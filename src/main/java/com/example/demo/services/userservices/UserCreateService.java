package com.example.demo.services.userservices;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.eventservices.EventCreateService;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tools.Hash;

/**
 * User creation service.
 * @author Cedrick Pennec
 */
@Component
@Transactional
public class UserCreateService {

  private static final Logger LOGGER = LoggerFactory.getLogger(EventCreateService.class);

  /**
 * User repository
 */
@Autowired
  private UserRepository user;

  /**
   * Create a User.
 * @param user User
 * @return User
 */
User create(final User user) {
    LOGGER.debug("Creation utilisateur");
    user.setPassword(Hash.hash().encode(user.getPassword()));
    return this.user.save(user);
  }
}
