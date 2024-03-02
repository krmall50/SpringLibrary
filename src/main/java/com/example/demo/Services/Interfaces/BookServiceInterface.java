package com.example.demo.Services.Interfaces;

import com.example.demo.Models.Book;
import com.example.demo.Models.User;

import java.util.List;
import java.util.UUID;

public interface BookServiceInterface {
    List<Book> getAll();
    Book getById(int id);
    Book create(Book book);
    Book getByName(String name);
    List<Book> getByAuthor(String author);
    List<Book> getByPublisher(String Publisher);
    List<Book> getByAddress(String address);
    List<Book> getByStatus(String status);
    List<Book> getByQty(int qty);
    List<Book> getByPrice(double price);
    List<Book> getByBrwcopies(int brwcopies);
}
