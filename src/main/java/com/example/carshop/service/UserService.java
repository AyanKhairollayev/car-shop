package com.example.carshop.service;

import com.example.carshop.controller.dto.UserDto;
import com.example.carshop.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    User registration(UserDto dto);
    Optional<User> findByUsername(String username);
    ResponseEntity<?> login(UserDto dto);
}
