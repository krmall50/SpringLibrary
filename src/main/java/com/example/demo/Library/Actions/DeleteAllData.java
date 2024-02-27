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

import java.util.Objects;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class DeleteAllData implements IOOperation {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Are you sure? (y/n)");
        String wish = s.next();
        if (Objects.equals(wish, "y")){
            database.deleteAllData();
            user.menu(database, user);
        }
        else {
            user.menu(database, user);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
