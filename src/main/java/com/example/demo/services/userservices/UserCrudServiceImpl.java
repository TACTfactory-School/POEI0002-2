package com.example.demo.services.userservices;

import com.example.demo.entities.User;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserCrudServiceImpl implements UserCrudService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private UserCreateService createService;

  @Override
  public Page getAll(final Pageable pageable) {

    Page pagedResult = this.repository.findAll(pageable);

    if (pagedResult.hasContent()) {
      return pagedResult;
    } else {
      return null;
    }
  }

  @Override
  public User getOne(final long id) throws NotFoundException {
    return this.repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public User create(final User user) {
    return this.createService.create(user);
  }

  @Override
  public void delete(final long id) {
    this.repository.deleteById(id);
  }

  @Override
  public User update(final User user) {
    return this.repository.save(user);
  }

  @Override
  public User getByUserName(final String username) throws NotFoundException {
    return this.repository.findByUsername(username);
  }

}
