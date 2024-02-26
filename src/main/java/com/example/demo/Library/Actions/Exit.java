package com.example.demo.Library.Actions;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;
import com.example.demo.Library.Users.User;
import com.example.demo.Library.Users.NormalUser;
import com.example.demo.Library.Users.Admin;

import java.util.Scanner;

public class Exit implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        System.out.println("Exiting...");
    }
}

