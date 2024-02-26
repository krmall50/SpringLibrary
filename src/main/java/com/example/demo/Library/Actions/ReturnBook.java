package com.example.demo.Library.Actions;
import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;
import com.example.demo.Library.Users.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.awt.print.Book;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ReturnBook implements IOOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter name of the book");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        database.returnBook(user, name);
        user.menu(database, user);
    }
}
