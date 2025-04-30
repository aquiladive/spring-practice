package com.example.library.web.controller;

import com.example.library.data.entity.Book;
import com.example.library.data.entity.User;
import com.example.library.data.repository.BookRepository;
import com.example.library.data.repository.UserRepository;
import com.example.library.service.RentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class orderController {
    @Autowired
    UserOpController userOpController;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/order/{bookId}")
    @Transactional
    public String orderBook(@PathVariable Integer bookId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            String userName = ((UserDetails) authentication.getPrincipal()).getUsername();
            model.addAttribute("name", userName);
            Integer userId = userOpController.getUserId(userName);
            User user = userRepository.findUserById(userId);
            if(user.getHeldBooksCount() > 2)
                model.addAttribute("orderMessage", "You have already rented two books. Please return them before renting a new one.");
            else {
                Book book = bookRepository.findBookById(bookId);
                book.setBookCount(book.getBookCount()-1);
                bookRepository.save(book);
                user.getHeldBooks().add(book);
                user.setHeldBooksCount(user.getHeldBooksCount()+1);
                userRepository.save(user);
                model.addAttribute("orderMessage", "Your renting has been successful. Enjoy your new book!");
            }
        }
        return "order";
    }
}
