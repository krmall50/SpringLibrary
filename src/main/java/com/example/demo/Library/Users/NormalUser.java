package com.example.demo.Library.Users;

import com.example.demo.Library.Actions.*;
import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;

import java.util.Scanner;

public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
        this.operations = new IOOperation[]{
                new ViewBooks(),
                new Search(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
        };
    }
    public NormalUser(String name, String email, String number){
        super(name, email, number);
        this.operations = new IOOperation[]{
                new ViewBooks(),
                new Search(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
        };
    }
    @Override
    public void menu(Database database, User user) {
        System.out.println("1. View Books");
        System.out.println("2. Search");
        System.out.println("3. Borrow Book");
        System.out.println("4. Calculate Fine");
        System.out.println("5. Return book");
        System.out.println("6. Exit");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
    }

    @Override
    public String toString() {
        return getName() + ", " + getEmail() + ", " + getNumber() + ": Normal User";
    }
}
