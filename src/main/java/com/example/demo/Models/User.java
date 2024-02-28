package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
@Data
@Getter
@Setter
@Entity
@Table(name = "user")
public abstract class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected String name;
    protected String email;
    protected String number;

    public User(String name) {
        setName(name);
    }

    public User(String name, String email, String number) {
        setName(name);
        setEmail(email);
        setNumber(number);
    }
}