package com.example.demo.Library.Actions;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;
import com.example.demo.Library.Users.User;

import java.util.Objects;
import java.util.Scanner;

public class DeleteAllData implements IOOperation {

    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Are you sure? (y/n)");
        String wish = s.next();
        if (Objects.equals(wish, "y")){
            database.deleteAllData();
            user.menu(database, user);
        }
        else {
            user.menu(database, user);
        }
    }
}
