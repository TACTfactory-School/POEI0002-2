package com.example.demo.services.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixtureService implements Fixture {

    @Autowired
    private EventFixtureService eventFixture;

    @Autowired
    private UserFixtureService userFixture;

    public void load() {
//        this.eventFixture.load();
        this.userFixture.load();
    }
}
