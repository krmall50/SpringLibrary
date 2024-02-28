package com.example.demo.Models;

import jakarta.persistence.Table;

@Table(name = "user_table")
public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
    }
    public NormalUser(String name, String email, String number){
        super(name, email, number);
    }
}

