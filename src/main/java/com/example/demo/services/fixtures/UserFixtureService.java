package com.example.demo.services.fixtures;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.github.javafaker.Faker;
import tools.HASH;

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

        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword(HASH.hash().encode("admin"));
        user1.setCity("paris");
        user1.setRole("admin");
        user1.setEnable(true);
        this.repository.save(user1);


        for(int i = 0; i < nbFakeUser; i++) {
            User user = new User();
            user.setCity(faker.address().city());
            user.setEnable(true);
            user.setRole("user");

            user.setPassword(HASH.hash().encode(faker.elderScrolls().dragon()));
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
