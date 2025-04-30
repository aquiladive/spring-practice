package com.example.library.web.controller;

import com.example.library.data.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rent")
public class rentController {
    @Autowired
    BookOpController bookOpController;

    @GetMapping
    public String getPage(Model model) {
        Iterable<Book> books = bookOpController.getBooks();
        model.addAttribute("books", books);
        return "rent";
    }
}
