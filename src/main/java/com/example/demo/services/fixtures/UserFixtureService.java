package com.example.demo.services.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.github.javafaker.Faker;

@Component
public class UserFixtureService implements Fixture {

    @Autowired
    private UserRepository repository;

    @Value("${number.fakeuser:100}")
    int nbFakeUser;

    @Override
    public void load() {

        Faker faker = new Faker();

        for(int i = 0; i < nbFakeUser; i++) {
            User user = new User();
            user.setCity(faker.lordOfTheRings().location());
            user.setPassword(faker.elderScrolls().dragon());
            user.setUsername(faker.harryPotter().character());
            user.setProfession(faker.overwatch().hero());
            user.setDescription(faker.witcher().quote());

            this.repository.save(user);
        }
    }
}
