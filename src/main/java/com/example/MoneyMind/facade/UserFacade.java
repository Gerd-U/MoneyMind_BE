package com.example.MoneyMind.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.MoneyMind.dtos.UserDto;
import com.example.MoneyMind.dtos.UserRequestDto;
import com.example.MoneyMind.mappers.UserMapper;
import com.example.MoneyMind.services.IUserService;

import jakarta.transaction.Transactional;

@Component
public class UserFacade implements IUserFacade {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDtoList(userService.getAll());
    }

    @Override
    @Transactional
    public UserDto addUser(UserRequestDto userDto) {

        var entity = userService.addUser(userDto);

        return userMapper.toUserDto(entity);
    }

    @Override
    @Transactional
    public UserDto updateUser(String email, UserRequestDto userDto) {

        var entity = userService.updateUser(email, userDto);

        return userMapper.toUserDto(entity);
    }

    @Override
    public UserDto getByEmail(String email) {

        var entity = userService.getByEmail(email);

        return userMapper.toUserDto(entity);
    }

    @Override
    @Transactional
    public void removeUser(String email) {

        userService.removeUser(email);
    }

    @Override
    public UserDto login(String email, String password) {
        var entity = userService.getByEmail(email);
        if (!entity.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return userMapper.toUserDto(entity);
    }
}
