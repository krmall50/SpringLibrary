package com.example.demo.Repositories;

import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryInterface extends JpaRepository<User, Integer> {
    User findByID(UUID id);
    List<User> findByNumber(String number);
    List<User> findByEmail(String email);
    List<User> findByName(String name);
}
