package com.example.demo.repository;

import com.example.demo.entities.UserEventOrganisator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventOrganisatorRepository extends JpaRepository<UserEventOrganisator, Long> {
}
