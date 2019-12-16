package com.example.demo.services.userservices;

import com.example.demo.entities.User;
import com.example.demo.exeptions.NotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserCrudService {

  Page getAll(Pageable pageable);

  User getOne(long id) throws NotFoundException;

  User getByUserName(String username)throws NotFoundException;

  User create(User user);

  void delete(long id);

  User update(User user);

}
