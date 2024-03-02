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
    public List<Book> getAllByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @GetMapping({"/author/{author}","/author/{author}/"})
    public List<Book> getAllByAuthor(@PathVariable("author") String author){
        return service.getByAuthor(author);
    }
    @GetMapping({"/publisher/{publisher}","/publisher/{publisher}/"})
    public List<Book> getAllByPublisher(@PathVariable("publisher") String publisher){
        return service.getByPublisher(publisher);
    }
    @GetMapping({"/address/{address}","/address/{address}/"})
    public List<Book> getAllByAddress(@PathVariable("address") String address){
        return service.getByAddress(address);
    }
    @GetMapping({"/status/{status}","/status/{status}/"})
    public List<Book> getAllByStatus(@PathVariable("status") String status){
        return service.getByStatus(status);
    }
    @GetMapping({"/qty/{qty}","/qty/{qty}/"})
    public List<Book> getAllByQty(@PathVariable("qty") int qty){
        return service.getByQty(qty);
    }
    @GetMapping({"/price/{price}","/price/{price}/"})
    public List<Book> getAllByPrice(@PathVariable("price") int price){
        return service.getByPrice(price);
    }
    @GetMapping({"/brwcopies/{brwcopies}","/brwcopies/{brwcopies}/"})
    public List<Book> getAllByBrwcopies(@PathVariable("brwcopies") int brwcopies){
        return service.getByBrwcopies(brwcopies);
    }

}
