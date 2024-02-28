package com.example.demo.Services.Interfaces;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface{
    private final UserServiceInterface repo;
    @Autowired
    public UserService(UserServiceInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAll() {
        return repo.getAll();
    }

    @Override
    public User getById(UUID id) {
        return repo.getById(id);
    }

    @Override
    public User create(User user) {
        return repo.create(user);
    }

    @Override
    public List<User> getByNumber(String number) {
        return repo.getByNumber(number);
    }
}
