package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.exeptions.BadRequestException;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.services.userservices.UserCrudService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserCrudService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public List<User> getAll() {
        return this.service.getAll();
    }

    @PostMapping
    public User create(@Valid @RequestBody final User event) throws BadRequestException {
        return this.service.create(event);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        this.service.delete(id);
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable final Long id) throws NotFoundException {
        return this.service.getOne(id);
    }

    @PutMapping("{id}")
    public User update(@PathVariable final Long id, @Valid @RequestBody final User user)
            throws NotFoundException {
        final User entity = this.service.getOne(id);

        this.mapper.map(user, entity);
        this.service.update(entity);

        return entity;
    }

}
