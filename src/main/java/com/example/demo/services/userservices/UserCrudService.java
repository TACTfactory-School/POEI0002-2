package com.example.demo.services.userservices;

import java.util.List;

import com.example.demo.entities.User;
import com.example.demo.exeptions.NotFoundException;

public interface UserCrudService {

    List<User> getAll();

    User getOne(long id) throws NotFoundException;
    User getByUserName(String username)throws NotFoundException;

    User create(User user);

    void delete(long id);

    User update(User user);

}
