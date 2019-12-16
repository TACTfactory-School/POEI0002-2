package com.example.demo.services.fixtures;

import javax.transaction.Transactional;

public interface Fixture {
  @Transactional
    void load();
}
