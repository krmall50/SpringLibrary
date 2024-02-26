package com.example.demo.Library.Users;

import com.example.demo.Library.Actions.*;
import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;

import java.util.Scanner;

public class Admin extends User {

    public Admin(String name) {
        super(name);
        this.operations = new IOOperation[]{
                new AddBook(),
                new ViewBooks(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new Exit()
        };
    }

    public Admin(String name, String email, String number) {
        super(name, email, number);
        this.operations = new IOOperation[]{
                new ViewBooks(),
                new AddBook(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new Exit()
        };
    }

    @Override
    public void menu(Database database, User user) {
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Search");
        System.out.println("5. Delete all data");
        System.out.println("6. Exit");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
        s.close();

    }

    @Override
    public String toString() {
        return getName() + ", " + getEmail() + ", " + getNumber() + ": Admin";
    }
}
