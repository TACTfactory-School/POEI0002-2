package com.example.demo.services.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixtureService implements Fixture {

  /**
 * event fixtures.
 */
@Autowired
  private EventFixtureService eventFixture;

  /**
 * user Fixtures.
 */
@Autowired
  private UserFixtureService userFixture;

  /**
 * Load fixtures.
 */
public void load() {
    this.userFixture.load();
    this.eventFixture.load();
  }
}
