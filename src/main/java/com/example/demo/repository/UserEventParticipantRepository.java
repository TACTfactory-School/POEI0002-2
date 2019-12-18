package com.example.demo.repository;

import com.example.demo.entities.Event;
import com.example.demo.entities.User;
import com.example.demo.entities.UserEventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventParticipantRepository extends JpaRepository<UserEventParticipant, Long> {
    UserEventParticipant getByUserParticipantAndEventParticipant(User user, Event event);

}
