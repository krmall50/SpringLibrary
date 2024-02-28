package com.example.demo.Models;

import jakarta.persistence.Table;

@Table(name = "user")
public class Admin extends User{
    public Admin(String name) {
        super(name);
    }
    public Admin(String name, String email, String number){
        super(name, email, number);
    }
}
