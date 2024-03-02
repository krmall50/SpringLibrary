package com.example.demo.Repositories;

import com.example.demo.Models.Book;
import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepositoryInterface extends JpaRepository<Book, Integer> {
    Book findByID(int Id);
    List<Book> findByName(String name);
    List<Book> findByAuthor(String author);
    List<Book> findByPublisher(String publisher);
    List<Book> findByAddress(String address);
    List<Book> findByStatus(String status);
    List<Book> findByQty(int qty);
    List<Book> findByPrice(double price);
    List<Book> findByBrwcopies(int brwcopies);
}
