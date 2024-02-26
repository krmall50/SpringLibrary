package com.example.demo.Library.Service;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Users.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser(){
        Database database = new Database();
        database.connectToDB();
        return database.getUser("789");
    }
}
