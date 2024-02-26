package com.example.demo.Library.Database;


import com.example.demo.Library.Users.Admin;
import com.example.demo.Library.Users.User;
import com.example.demo.Library.Users.NormalUser;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.demo.Library.Items.Book;

public class Database {
    private Connection conn;
    public Connection connectToDB() {
        if (conn == null) {
            try {
                // Connect to the PostgresSQL database
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
                System.out.println("Connected to the database");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Exception: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> booksNames = new ArrayList<String>();
    public void addUser(User s){
        users.add(s);
        usernames.add(s.getName());
    }
    public int login(String number, String email) {
        try {
            String query = "SELECT * FROM users WHERE number = ? AND email = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, number);
            pstmt.setString(2, email);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // User exists, return the user_id or any unique identifier
                return 1;
            } else {
                // User doesn't exist
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
            return -1;
        }
    }

    public User getUser(String number) {
        try {
            String query = "SELECT * FROM users WHERE number = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, number);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve other user information
                String name = rs.getString("name");
                String email = rs.getString("email");

                // Retrieve boolean value
                boolean isAdmin = rs.getBoolean("isAdmin");

                // Create and return a User object
                if (isAdmin)
                    return new Admin(name, email, number);
                else return new NormalUser(name, email, number);
            } else {
                // User doesn't exist
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
            return null; // Handle the exception according to your needs
        }
    }

    public void addBook(Book book){
        books.add(book);
        booksNames.add(book.getName());
    }
    public void getUsers() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Process the ResultSet (retrieve and print data, etc.)
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String number = rs.getString("number");

                // Process the retrieved data as needed
                System.out.println("Name: " + name + ", Email: " + email + ", Number: " + number);
            }

            // Close the ResultSet and Statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public void getBooks() {
        try {
            connectToDB();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM book");

            // Process the ResultSet (retrieve and print data, etc.)
            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String adress = rs.getString("address");
                String qty = rs.getString("qty");
                String price = rs.getString("price");
                String brwcopies = rs.getString("brwcopies");

                // Process the retrieved data as needed
                System.out.println("Name: " + name + ", author: " + author + ", publisher: " + publisher
                        + "address: " + adress + ", qty: " + qty + ", price: " + price + ", brwcopies: " + brwcopies);
            }

            // Close the ResultSet and Statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public void saveBook(String name, String author, String publisher,
                         String address, String status, int qty, double price, int brwcopies) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO book (name, author, publisher, address, status, qty, price, brwcopies) " +
                    "VALUES ('" + name + "', '" + author + "', '" + publisher + "', '" + address + "', '" + status + "', " +
                    qty + ", " + price + ", " + brwcopies + ")");
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public void deleteBook(String name) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM book WHERE name = '" + name + "'");
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public Book getBook(String bookName) {
        try {
            String sql = "SELECT * FROM book WHERE name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, bookName);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Retrieve book details from the result set and create a Book object
                        String name = rs.getString("name");
                        String author = rs.getString("author");
                        String publisher = rs.getString("publisher");
                        String address = rs.getString("address");
                        String status = rs.getString("status");
                        int qty = rs.getInt("qty");
                        double price = rs.getDouble("price");
                        int brwcopies = rs.getInt("brwcopies");

                        // Create a Book object with the retrieved details
                        Book book = new Book(name, author, publisher, address, status, qty, price, brwcopies);
                        return book;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return null; // Return null if the book with the specified ID is not found or an error occurs
    }



    public void saveUser(String name, String email, String number, boolean isAdmin){
        try{
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate("INSERT INTO users (name, email, number, isAdmin) VALUES ('" + name + "', '" + email + "', '" + number + "', " + isAdmin + ")");
        }catch (SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }

    }
    public void borrowBook(User user, String name){
        try{
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate("UPDATE book " +
                    "SET status = 'Borrowed by " + user.getName() + "'" +
                    "WHERE name = '" + name + "';");
        }catch (SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }

    }
    public void returnBook(User user, String name){
        try{
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate("UPDATE book " +
                    "SET status = 'Available' " +
                    "WHERE name = '" + name + "';");
        }catch (SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public void deleteAllData(){
        try{
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate("DELETE FROM book");
            stmt.executeUpdate("DELETE FROM users");
        }catch (SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
