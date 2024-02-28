package com.example.demo.Services.Interfaces;

import com.example.demo.Models.User;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {
    List<User> getAll();
    User getById(UUID id);
    User create(User user);
    List<User> getByNumber(String number);
}
