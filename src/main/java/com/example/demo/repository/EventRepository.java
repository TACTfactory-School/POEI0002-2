package com.example.demo.repository;

import com.example.demo.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository of the Event entity.
 * @author Cedrick Pennec
 */
public interface EventRepository extends JpaRepository<Event, Long> {

}
