package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;

public interface EventRepository extends JpaRepository<Event, Long> {



}
