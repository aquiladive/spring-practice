package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CLRunner implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public CLRunner(CustomerRepository customerRepo) {
        this.customerRepository = customerRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customers = this.customerRepository.findCustomerById(1);
    }
}
