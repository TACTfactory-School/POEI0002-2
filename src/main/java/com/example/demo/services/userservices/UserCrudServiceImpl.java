package com.example.demo.services.userservices;

import com.example.demo.entities.User;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * User Crud service implementations.
 * @author Cedrick Pennec
 */
@Service
public class UserCrudServiceImpl implements UserCrudService {

  /**
 * UserRepository
 */
@Autowired
  private UserRepository repository;

  /**
 * UserCreateService
 */
@Autowired
  private UserCreateService createService;

/**
 * Retrieves all Users according to pageable parameters.
* @param pageable Pageable
* @return Page
*/
  @Override
  public Page getAll(final Pageable pageable) {

    Page pagedResult = this.repository.findAll(pageable);

    if (pagedResult.hasContent()) {
      return pagedResult;
    } else {
      return null;
    }
  }

  /**
   * Retrieves one User according to its id.
 * @param id long
 * @return User
 * @throws NotFoundException User not found
 */
  @Override
  public User getOne(final long id) throws NotFoundException {
    return this.repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException());
  }

  /**
   * Create a User.
 * @param user User
 * @return User
 */
  @Override
  public User create(final User user) {
    return this.createService.create(user);
  }

  /**
   * Delete a User according to its id.
 * @param id long.
 */
  @Override
  public void delete(final long id) {
    this.repository.deleteById(id);
  }

  /**
   * Update a User.
 * @param user User
 * @return User
 */
  @Override
  public User update(final User user) {
    return this.repository.save(user);
  }

  /**
   * Retrieves one User according to its name.
 * @param username String
 * @return User
 * @throws NotFoundException User not found.
 */
  @Override
  public User getByUserName(final String username) throws NotFoundException {
    return this.repository.findByUsername(username);
  }

}
