package com.example.MoneyMind.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MoneyMind.dtos.UserRequestDto;
import com.example.MoneyMind.entities.User;
import com.example.MoneyMind.exceptions.UserNotFoundException;
import com.example.MoneyMind.repository.UserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(UserRequestDto userDto) {

        var user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .registrationDate(LocalDateTime.now())
                .active(userDto.getActive())
                .build();

        return userRepository.addUser(user);
    }

    @Override
    public User updateUser(String email, UserRequestDto userDto) {

        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setActive(userDto.getActive());

        return userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void removeUser(String email) {

        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        userRepository.delete(user);
    }
}