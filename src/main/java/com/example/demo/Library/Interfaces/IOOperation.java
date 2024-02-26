package com.example.demo.Library.Interfaces;

import com.example.demo.Library.Database.Database;
import com.example.demo.Library.Users.User;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

public interface IOOperation {
    public void oper(Database database, User user);
}
