package com.example.MoneyMind.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyMind.dtos.UserDto;
import com.example.MoneyMind.facade.IUserFacade;
import com.example.MoneyMind.mappers.UserMapper;
import com.example.MoneyMind.models.LoginRequestModel;
import com.example.MoneyMind.models.UserRequestModel;
import com.example.MoneyMind.models.UserResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserFacade userFacade;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserResponseModel>> findAll() {

        return ResponseEntity.ok(
                userMapper.toUserResponseModelList(
                        userFacade.getAll()));
    }

    @PostMapping
    public UserDto save(@RequestBody UserRequestModel userRequestModel) {

        var dto = userMapper.toUserRequestDto(userRequestModel);

        return userFacade.addUser(dto);
    }

    @PutMapping(path = "/{email}")
    public UserDto update(
            @PathVariable("email") String email,
            @RequestBody UserRequestModel userRequestModel) {

        var dto = userMapper.toUserRequestDto(userRequestModel);

        return userFacade.updateUser(email, dto);
    }

    @GetMapping(path = "/{email}")
    public UserDto findByEmail(
            @PathVariable("email") String email) {

        return userFacade.getByEmail(email);
    }

    @DeleteMapping(path = "/{email}")
    public void remove(
            @PathVariable("email") String email) {

        userFacade.removeUser(email);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody LoginRequestModel loginRequestModel) {
        try {
            UserDto user = userFacade.login(loginRequestModel.email(), loginRequestModel.password());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }
}
