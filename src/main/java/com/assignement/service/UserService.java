package com.assignement.service;


import com.assignement.dto.LoginDto;
import com.assignement.dto.UserDto;
import com.assignement.dto.Response;
import com.assignement.entity.User;
import com.assignement.jwtutil.Jwtutil;
import com.assignement.repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepo userrepo;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepo userrepo) {
        this.userrepo = userrepo;
    }

    public ResponseEntity<Response<String>> Signup(UserDto userdto){

        String email = userdto.getEmail();

        if(userrepo.existsByEmail(email)){
            Response<String> res = new Response<>("04","User Already Exist",null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
        }

        User newuser = new User();
        newuser.setEmail(email);
        newuser.setFirstName(userdto.getFirstName());
        newuser.setLastName(userdto.getLastName());

        String hashedpw = encoder.encode(userdto.getPassword());
        newuser.setPassword(hashedpw);


        userrepo.save(newuser);

        Response<String> response = new Response<>("00", "Signup Success for email " , email);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    public ResponseEntity<Response<String>> Login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String rawPassword = loginDto.getPassword();

        Optional<User> optionalUser = userrepo.findByEmail(email);

        if (optionalUser.isEmpty()) {
            Response<String> res = new Response<>("01", "User not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }

        User user = optionalUser.get();
        if (encoder.matches(rawPassword, user.getPassword())) {
            String token = Jwtutil.generateToken(email);
            Response<String> response = new Response<>("00", "Login success", token);
            return ResponseEntity.ok(response);
        } else {
            Response<String> res = new Response<>("02", "Invalid credentials", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
        }
    }





}
