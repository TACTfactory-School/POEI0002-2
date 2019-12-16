package com.example.demo.repository;

import com.example.demo.entities.UserEventParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventParticipantRepository extends JpaRepository<UserEventParticipant, Long> {

}
