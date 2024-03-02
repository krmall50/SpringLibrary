package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Services.Interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserServiceInterface service;

    public UserController(UserServiceInterface service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public List<User> getAll(){
        return service.getAll();
    }
    @GetMapping({"/{id}","/{id}/"})
    public ResponseEntity<User> getById(@PathVariable("id") UUID id){
        User user = service.getById(id);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping({"/create","/create/"})
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = service.create(user);

            if (createdUser != null) {
                return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/number/{number}","/number/{number}/"})
    public List<User> getAllByNumber(@PathVariable("number") String number){
        return service.getByNumber(number);
    }

}
