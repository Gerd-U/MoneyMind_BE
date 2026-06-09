package com.example.MoneyMind.services;

import java.util.List;

import com.example.MoneyMind.dtos.UserRequestDto;
import com.example.MoneyMind.entities.User;

public interface IUserService {

    List<User> getAll();

    User addUser(UserRequestDto userDto);

    User updateUser(String email, UserRequestDto userDto);

    User getByEmail(String email);

    void removeUser(String email);

}