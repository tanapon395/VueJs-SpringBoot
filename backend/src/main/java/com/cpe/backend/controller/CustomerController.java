package com.cpe.backend.controller;

import com.cpe.backend.entity.Customer;
import com.cpe.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CustomerController {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer")
    public Collection<Customer> Customers() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> Customers(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

}