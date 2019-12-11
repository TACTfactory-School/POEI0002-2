package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.entities.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public UserDTO userToDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setCity(user.getCity());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setSex(user.getSex());
        userDTO.setPicture(user.getPicture());
        userDTO.setMaritalStatus(user.getMaritalStatus());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setDescription(user.getDescription());
        userDTO.setLastConnectionDate(user.getLastConnectionDate());
        userDTO.setProfession(user.getProfession());

        return userDTO;
    }
}
