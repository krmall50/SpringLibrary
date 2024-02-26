package com.example.demo.Library.Actions;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Interfaces.IOOperation;
import com.example.demo.Library.Items.Book;
import com.example.demo.Library.Users.User;

import java.util.Scanner;

public class AddBook implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Name: ");
        book.setName(s.next());
        System.out.println("author: ");
        book.setAuthor(s.next());
        System.out.println("publisher: ");
        book.setPublisher(s.next());
        System.out.println("adress: ");
        book.setAdress(s.next());
        System.out.println("status: ");
        book.setStatus(s.next());
        System.out.println("qty: ");
        book.setQty(s.nextInt());
        System.out.println("price: ");
        book.setPrice(s.nextDouble());
        System.out.println("brwcopies: ");
        book.setBrwcopies(s.nextInt());
        database.addBook(book);
        database.saveBook(book.getName(), book.getAuthor(), book.getPublisher(), book.getAdress(), book.getStatus(),
                book.getQty(), book.getPrice(), book.getBrwcopies());
        user.menu(database, user);
    }
}
