package com.example.MoneyMind.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.MoneyMind.dtos.UserDto;
import com.example.MoneyMind.dtos.UserRequestDto;
import com.example.MoneyMind.entities.User;
import com.example.MoneyMind.models.UserRequestModel;
import com.example.MoneyMind.models.UserResponseModel;

@Component
public class UserMapper {

    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRegistrationDate(),
                user.getActive());
    }

    public List<UserDto> toUserDtoList(List<User> users) {
        if (users == null) {
            return null;
        }

        return users.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    public UserResponseModel toUserResponseModel(UserDto userDto) {

        if (userDto == null) {
            return null;
        }

        return new UserResponseModel(
                userDto.firstName(),
                userDto.lastName(),
                userDto.email(),
                userDto.registrationDate(),
                userDto.active());
    }

    public List<UserResponseModel> toUserResponseModelList(List<UserDto> userDtos) {

        if (userDtos == null) {
            return null;
        }

        return userDtos.stream()
                .map(this::toUserResponseModel)
                .collect(Collectors.toList());
    }

    public UserRequestDto toUserRequestDto(UserRequestModel user) {

        if (user == null) {
            return null;
        }

        UserRequestDto userDto = new UserRequestDto();

        userDto.setFirstName(user.firstName());
        userDto.setLastName(user.lastName());
        userDto.setEmail(user.email());
        userDto.setPassword(user.password());
        userDto.setActive(user.active());

        return userDto;
    }
}