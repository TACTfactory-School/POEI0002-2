package com.example.demo.services.fixtures;

import javax.transaction.Transactional;

/**
 * Fixture interface.
 * @author Cedrick Pennec
 */
public interface Fixture {
  @Transactional
    void load();
}
