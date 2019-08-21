package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.entity.RentalType;
import com.cpe.backend.repository.RentalTypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RentalTypeController {

    @Autowired
    private final RentalTypeRepository rentalTypeRepository;

    public RentalTypeController(RentalTypeRepository rentalTypeRepository) {
        this.rentalTypeRepository = rentalTypeRepository;
    }

    @GetMapping("/rentalType")
    public Collection<RentalType> RentalType() {
        return rentalTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}