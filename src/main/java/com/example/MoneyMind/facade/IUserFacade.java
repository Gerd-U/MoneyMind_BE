package com.example.MoneyMind.facade;

import java.util.List;

import com.example.MoneyMind.dtos.UserDto;
import com.example.MoneyMind.dtos.UserRequestDto;

public interface IUserFacade {

    List<UserDto> getAll();

    UserDto addUser(UserRequestDto userDto);

    UserDto updateUser(String email, UserRequestDto userDto);

    UserDto getByEmail(String email);

    void removeUser(String email);

    UserDto login(String email, String password);

}