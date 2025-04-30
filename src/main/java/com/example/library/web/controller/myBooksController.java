package com.example.library.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myBooks")
public class myBooksController {
    @Autowired
    UserOpController userOpController;

    @GetMapping
    public String getPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            String userName = ((UserDetails) authentication.getPrincipal()).getUsername();
            model.addAttribute("name", userName);
            model.addAttribute("heldBooks", userOpController.getHeldBooks(userOpController.getUserId(userName)));
        }
        else
            model.addAttribute("name", "null");
        return "myBooks";
    }
}
