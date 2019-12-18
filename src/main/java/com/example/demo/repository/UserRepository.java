package com.example.demo.repository;

import com.example.demo.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository of the User Entity.
 * @author Cedrick Pennec.
 */
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
