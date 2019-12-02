package com.example.demo.services.fixtures;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<String> usernames;
    private String username;

    @Value("${number.fakeuser:100}")
    int nbFakeUser;

    @Override
    public void load() {

        Faker faker = new Faker();
        usernames = new ArrayList<>();

        for(int i = 0; i < nbFakeUser; i++) {
            User user = new User();
            user.setCity(faker.address().city());
            user.setPassword(faker.elderScrolls().dragon());
            do{
                username = faker.harryPotter().character();
            }while(this.usernames.contains(username));
            usernames.add(username);
            user.setUsername(username);
            user.setEmail(faker.internet().emailAddress());
            user.setName(faker.pokemon().name());
            Date birthday = faker.date().birthday();
            user.setBirthDate(LocalDateTime.ofInstant(birthday.toInstant(), ZoneId.systemDefault()));
            user.setSex(faker.team().creature());
            user.setProfession(faker.job().title());
            user.setDescription(faker.harryPotter().quote());
            user.setMaritalStatus(faker.leagueOfLegends().rank());

            this.repository.save(user);
        }
    }
}
