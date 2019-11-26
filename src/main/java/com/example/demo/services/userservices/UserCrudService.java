package com.example.demo.services.userservices;

import java.util.List;

import com.example.demo.entities.User;
import com.example.demo.exeptions.NotFoundException;

public interface UserCrudService {

    List<User> getAll();

    User getOne(long id) throws NotFoundException;

    User create(User employee);

    void delete(long id);

}
