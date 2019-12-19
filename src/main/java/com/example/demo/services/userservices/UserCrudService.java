package com.example.demo.services.userservices;

import com.example.demo.entities.User;
import com.example.demo.exeptions.NotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * User crud service interface.
 * @author Cedrick Pennec
 */
public interface UserCrudService {

  /**
   * Retrieves all Users according to pageable parameters.
 * @param pageable Pageable
 * @return Page
 */
Page getAll(Pageable pageable);

  /**
   * Retrieves one User according to its id.
 * @param id long
 * @return User
 * @throws NotFoundException User not found
 */
User getOne(long id) throws NotFoundException;

  /**
   * Retrieves one User according to its name.
 * @param username String
 * @return User
 * @throws NotFoundException User not found.
 */
User getByUserName(String username)throws NotFoundException;

  /**
   * Create a User.
 * @param user User
 * @return User
 */
User create(User user);

  /**
   * Delete a User according to its id.
 * @param id long.
 */
void delete(long id);

  /**
   * Update a User.
 * @param user User
 * @return User
 */
User update(User user);

}
