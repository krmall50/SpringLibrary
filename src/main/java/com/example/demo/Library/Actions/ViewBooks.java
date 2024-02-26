package com.example.demo.Library.Actions;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;
import com.example.demo.Library.Users.User;

public class ViewBooks implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        Database database1 = new Database();
        database1.getBooks();
        user.menu(database, user);
    }
}
