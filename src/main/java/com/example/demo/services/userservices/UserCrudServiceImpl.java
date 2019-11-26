package com.example.demo.services.userservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserCrudServiceImpl implements UserCrudService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserCreateService createService;

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public User getOne(long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public User create(User user) {
        return this.createService.create(user);
    }

    @Override
    public void delete(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public User update(User user) {
        return this.repository.save(user);
    }

}
