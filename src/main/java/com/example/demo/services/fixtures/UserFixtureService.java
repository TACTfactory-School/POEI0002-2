package com.example.demo.services.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Component
public class UserFixtureService implements Fixture {

    @Autowired
    private UserRepository repository;

    @Override
    public void load() {
        User user = new User();

        user.setCity("Rennes");
        user.setPassword("dec");
        user.setUsername("Hyquare");

        this.repository.save(user);
    }

}
