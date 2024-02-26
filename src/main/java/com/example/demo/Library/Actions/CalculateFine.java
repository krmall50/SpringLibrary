package com.example.demo.Library.Actions;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;
import com.example.demo.Library.Users.User;

public class CalculateFine implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        System.out.println("You have no fine :)");
        user.menu(database, user);
    }
}
