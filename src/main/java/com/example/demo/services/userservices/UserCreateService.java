package com.example.demo.services.userservices;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.eventservices.EventCreateService;
import tools.HASH;

@Component
@Transactional
public class UserCreateService {

    private static final Logger logger = LoggerFactory.getLogger(EventCreateService.class);

    @Autowired
    private UserRepository user;

    User create(final User user) {
        logger.debug("Creation utilisateur");
        user.setPassword(HASH.hash().encode(user.getPassword()));
        return this.user.save(user);
    }


}
