package com.example.library.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String author;
    private Integer bookCount;
    @ManyToMany
    @JoinTable(
            name = "books_users",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonManagedReference
    private Set<User> holdingUsers = new HashSet<>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getBookCount() { return this.bookCount; }
    public void setBookCount(Integer count) { this.bookCount = count; }

    public Set<User> getHoldingUsers() { return this.holdingUsers; }
    public void setHoldingUsers(Set<User> holdingUsers) { this.holdingUsers = holdingUsers; }

}
