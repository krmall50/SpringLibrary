package com.example.demo.Library.Controller;

import com.example.demo.Library.Service.UserService;
import com.example.demo.Library.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Library.Users.Admin;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public User getUser(){
        return userService.getUser();
    }
}
