package com.assignement.controller;

import com.assignement.dto.LoginDto;
import com.assignement.dto.Response;
import com.assignement.dto.UserDto;
import com.assignement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
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

    @GetMapping("/testget")
    public String TestGet(){
        return "test";
    }

    @PostMapping("/testpost")
    public String TestPost()
    {
        return "testpost";
    }

}
