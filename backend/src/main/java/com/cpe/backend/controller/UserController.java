package com.cpe.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cpe.backend.model.User;
import com.cpe.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/VIP")
    public Collection<User> VIP() {
        return userRepository.findAll().stream().filter(this::VIP).collect(Collectors.toList());
    }

    private boolean VIP(User user) {
        return user.getUsername().equals("Sitthichai") || user.getUsername().equals("Tanapon");
    }

    // ทดสอบโดย ใช้คำสั่ง curl -X POST localhost:8080/Regit/nanti
    @PostMapping("/Regit/{userName}")
    // @RequestMapping(path="Regit", method=RequestMethod.POST,
    // consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User newnameUser(@PathVariable String userName) {
        User newUser = new User();
        newUser.setUsername(userName);
        return userRepository.save(newUser); // บันทึก Objcet ชื่อ user
    }

    // ref https://jira.spring.io/browse/SPR-15582
    // ทดสอบโดย ใช้คำสั่ง curl -iX POST -H 'Content-Type:application/json' -d
    // {\"userName\":\"johnny\"} http://localhost:8080/Regit
    // %7BuserName%3Ajohnny%7D not decode

    @PostMapping("/Regit")
    public void newUser(@RequestBody User newUser) {
        userRepository.save(newUser);
    }

    @GetMapping("/Users")
    public Collection<User> User() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

}