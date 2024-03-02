package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Getter
@Setter
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int ID;
    private String name;
    private String author;
    private String publisher;
    private String address;
    private String status;	//Borrowing Status
    private int qty;	//Copies for sale
    private double price;
    private int brwcopies;	//Copies for borrowing
    public Book(){};
    public Book(String name, String author, String publisher,
                String adress, String status, int qty, double price, int brwcopies) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.address = adress;
        this.qty = qty;
        this.price = price;
        this.brwcopies = brwcopies;
    }

    public String toString() {
        String text = "Book Name: " + name+"\n"+
                "Book Author: " + author+"\n"+
                "Book Publisher: " + publisher+"\n"+
                "Book Collection Adress: " + address+"\n"+
                "Qty: " + String.valueOf(qty)+"\n"+
                "Price: " + String.valueOf(price)+"\n"+
                "Borrowing Copies: " + String.valueOf(brwcopies);
        return text;
    }
}