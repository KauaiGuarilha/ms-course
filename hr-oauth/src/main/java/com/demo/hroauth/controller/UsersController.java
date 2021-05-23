package com.demo.hroauth.controller;

import com.demo.hroauth.model.entity.Users;
import com.demo.hroauth.model.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired private UsersService service;

    @GetMapping(value = "/search")
    public ResponseEntity<Users> findByEmail(@RequestParam String email){
        return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
    }
}
