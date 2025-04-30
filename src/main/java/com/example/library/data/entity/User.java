package com.example.library.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Date joinDate;
    private Integer heldBooksCount;
    private String phoneNumber;
    @ManyToMany(mappedBy = "holdingUsers")
    @JsonBackReference
    private Set<Book> heldBooks = new HashSet<>();

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

    public Date getJoinDate() {
        return this.joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getHeldBooksCount() { return this.heldBooksCount; }
    public void setHeldBooksCount(Integer heldBooks) { this.heldBooksCount = heldBooksCount; }

    public Set<Book> getHeldBooks() { return this.heldBooks; }
    public void setHeldBooks(Set<Book> heldBooks) { this.heldBooks = heldBooks; }

    public String getPhoneNumber() { return this.phoneNumber; }
    public void setPhoneNumber(Integer heldBooks) { this.phoneNumber = phoneNumber; }
}