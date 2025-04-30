package com.example.library.data.repository;

import com.example.library.data.entity.Book;
import com.example.library.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookById(Integer id);

    Book findBookByName(String bookName);
}