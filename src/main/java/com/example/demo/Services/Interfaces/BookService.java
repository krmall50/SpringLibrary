package com.example.demo.Services.Interfaces;

import com.example.demo.Models.Book;
import com.example.demo.Models.User;
import com.example.demo.Repositories.BookRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService implements BookServiceInterface {
    private final BookRepositoryInterface repo;

    public BookService(BookRepositoryInterface repo) {
        this.repo = repo;
    }


    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Book getById(int id) {
        return repo.findByID(id);
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public List<Book> getByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return repo.findByAuthor(author);
    }

    @Override
    public List<Book> getByPublisher(String publisher) {
        return repo.findByPublisher(publisher);
    }

    @Override
    public List<Book> getByAddress(String address) {
        return repo.findByAddress(address);
    }

    @Override
    public List<Book> getByStatus(String status) {
        return repo.findByStatus(status);
    }

    @Override
    public List<Book> getByQty(int qty) {
        return repo.findByQty(qty);
    }

    @Override
    public List<Book> getByPrice(double price) {
        return repo.findByPrice(price);
    }

    @Override
    public List<Book> getByBrwcopies(int brwcopies) {
        return repo.findByBrwcopies(brwcopies);
    }
}
