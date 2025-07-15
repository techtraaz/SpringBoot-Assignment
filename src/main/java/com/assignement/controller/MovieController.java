package com.assignement.controller;

import com.assignement.dto.MovieTest;
import com.assignement.entity.Movie;
import com.assignement.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController


public class MovieController {

    private final MovieService ms;

    public MovieController(MovieService ms) {
        this.ms = ms;
    }


    @GetMapping("/test")
    public String tetst(){
        return "server running";
    }

    @GetMapping("/movie")
    public List<Movie> getAllMovies(){
      return  ms.getAllMovies();

    }

    @GetMapping("/movie1")
    public ResponseEntity<MovieTest> getAllMovies1(){
        MovieTest movieTest = new MovieTest();
        movieTest.setName("ABC");
        movieTest.setQty(5);
        return ResponseEntity.ok().body(movieTest);
    }








}
