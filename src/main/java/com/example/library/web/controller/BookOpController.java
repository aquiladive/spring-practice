package com.example.library.web.controller;

import com.example.library.data.entity.Book;
import com.example.library.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookOpController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/api/add")
    public String addBook(@RequestParam String name, @RequestParam String author, @RequestParam Integer count) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setBookCount(count);
        bookRepository.save(book);
        return "Added new book to library!";
    }

    @GetMapping("/api/listAllBooks")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/findById/{id}")
    public Book findBookById(@PathVariable Integer id) {
        return bookRepository.findBookById(id);
    }

    @GetMapping("/api/findByName/{name}")
    public String findBookByName(@PathVariable String name) {
        Iterable<Book> bookList = bookRepository.findAll();
        for(Book b: bookList) {
            if(b.getName().equals(name)) {
                if(b.getBookCount()>1)
                    return b.getBookCount() + " copies of " + b.getName() + " are present in the library.";
                if(b.getBookCount()==1)
                    return "1 copy of " + b.getName() + " is present in the library.";
            }
        }
        return "No copies of this book are present in the library.";
    }

    public List<Book> getAvailable() {
        List<Book> bookList = new ArrayList<>();
        for(Book b : bookRepository.findAll()) {
            if(b.getBookCount() >= 1)
                bookList.add(b);
        }
        return bookList;
    }
}
