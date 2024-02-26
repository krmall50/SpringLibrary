package com.example.demo.Library.Actions;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;
import com.example.demo.Library.Users.User;

import java.util.Scanner;

public class BorrowBook implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter name of the book");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        database.borrowBook(user, name);
        user.menu(database, user);
    }
}
