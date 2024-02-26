package com.example.demo.Library.Actions;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;
import com.example.demo.Library.Users.User;

import java.util.Scanner;

public class Search implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter name");
        String name = s.next();
        System.out.println(database.getBook(name));
        user.menu(database, user);
    }
}
