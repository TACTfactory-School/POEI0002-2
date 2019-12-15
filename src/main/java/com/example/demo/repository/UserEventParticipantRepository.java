package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserEventParticipant;

public interface UserEventParticipantRepository extends JpaRepository<UserEventParticipant, Long>{

}
