package com.assignement.controller;

import com.assignement.dto.LoginDto;
import com.assignement.dto.Response;
import com.assignement.dto.UserDto;
import com.assignement.jwtutil.Jwtutil;
import com.assignement.repo.UserRepo;
import com.assignement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService us;

    public UserController(UserService us, UserService userService){
        this.us = us;

    }

    @PostMapping("/signup")
    public ResponseEntity<Response<String>> signup(@RequestBody UserDto userdto){
        return us.Signup(userdto);
    }

    @PostMapping("/login")
    public ResponseEntity<Response<String>> Login(@RequestBody LoginDto logindto){
        return us.Login(logindto);
    }


}
