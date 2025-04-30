package com.example.library.web.controller;

import com.example.library.data.entity.Book;
import com.example.library.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/availableBooks")
public class availableBooksController {
    @Autowired
    BookOpController bookOpController;

    @GetMapping
    public String getPage(Model model) {
        List<Book> books = bookOpController.getAvailable();
        model.addAttribute("books", books);
        return "availableBooks";
    }
}
