package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listings")
public class CustListController {

    public CustListController() {

    }

    @GetMapping
    public String getList() {
        return "customerlist";
    }
}
