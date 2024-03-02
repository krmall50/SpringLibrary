package com.example.demo.Services.Interfaces;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface{
    private final UserRepositoryInterface repo;

    public UserService(UserRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(UUID id) {
        return repo.findByID(id);
    }

    @Override
    public User create(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getByNumber(String number) {
        return repo.findByNumber(number);
    }

    @Override
    public List<User> getByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<User> getByEmail(String email) {
        return repo.findByEmail(email);
    }
}
