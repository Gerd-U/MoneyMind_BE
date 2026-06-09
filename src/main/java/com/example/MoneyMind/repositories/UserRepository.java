package com.example.MoneyMind.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyMind.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    default List<User> getAll() {
        return findAll();
    }

    default User addUser(User user) {
        return save(user);
    }

    Optional<User> findByEmail(String email);
}