package com.example.demo.Controllers;

import com.example.demo.Models.Book;
import com.example.demo.Models.User;
import com.example.demo.Services.Interfaces.BookServiceInterface;
import com.example.demo.Services.Interfaces.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("book")
public class BookController {
    public final BookServiceInterface service;

    public BookController(BookServiceInterface service) {
        this.service = service;
    }
    @GetMapping({"", "/"})
    public List<Book> getAll(){
        return service.getAll();
    }
    @GetMapping({"/{id}","/{id}/"})
    public ResponseEntity<Book> getById(@PathVariable("id") int id){
        Book book = service.getById(id);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @PostMapping({"/create","/create/"})
    public ResponseEntity<Book> createUser(@RequestBody Book book) {
        try {
            Book createdBook = service.create(book);

            if (createdBook != null) {
                return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping({"/name/{name}","/name/{name}/"})
    public ResponseEntity<Book> getAllByName(@PathVariable("name") String name){
        Book book = service.getByName(name);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping({"/author/{author}","/author/{author}/"})
    public ResponseEntity<List<Book>> getAllByAuthor(@PathVariable("author") String author){
        List<Book> book = service.getByAuthor(author);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping({"/publisher/{publisher}","/publisher/{publisher}/"})
    public ResponseEntity<List<Book>> getAllByPublisher(@PathVariable("publisher") String publisher){
        List<Book> book = service.getByPublisher(publisher);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping({"/address/{address}","/address/{address}/"})
    public ResponseEntity<List<Book>> getAllByAddress(@PathVariable("address") String address){
        List<Book> book = service.getByAddress(address);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping({"/status/{status}","/status/{status}/"})
    public ResponseEntity<List<Book>> getAllByStatus(@PathVariable("status") String status){
        List<Book> book = service.getByStatus(status);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping({"/qty/{qty}","/qty/{qty}/"})
    public ResponseEntity<List<Book>> getAllByQty(@PathVariable("qty") int qty){
        List<Book> book = service.getByQty(qty);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping({"/price/{price}","/price/{price}/"})
    public ResponseEntity<List<Book>> getAllByPrice(@PathVariable("price") int price){
        List<Book> book = service.getByPrice(price);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping({"/brwcopies/{brwcopies}","/brwcopies/{brwcopies}/"})
    public ResponseEntity<List<Book>> getAllByBrwcopies(@PathVariable("brwcopies") int brwcopies){
        List<Book> book = service.getByBrwcopies(brwcopies);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
