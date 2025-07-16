package com.assignement.controller;

import com.assignement.dto.MovieTest;
import com.assignement.dto.Response;
import com.assignement.entity.Movie;
import com.assignement.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movie")


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
    public ResponseEntity<Response<List<Movie>>> getAllMovies(){
      return  ms.getAllMovies();

    }

    @GetMapping("/movie1")
    public ResponseEntity<MovieTest> getAllMovies1(){
        MovieTest movieTest = new MovieTest();
        movieTest.setName("ABC");
        movieTest.setQty(5);
        return ResponseEntity.ok().body(movieTest);
    }



    @GetMapping("/imdb/{imdb}")
    public ResponseEntity<Response<Movie>> getAllMoviesByImdb(@PathVariable String imdb){
        return ms.findByImdb(imdb);
    }

    @PostMapping("/add")
    public ResponseEntity<Response<String>> addMovie(@RequestBody Movie movie){
        return ms.addMovie(movie);
    }


    @PostMapping("/delete/{imdb}")
    public ResponseEntity<Response<String>> deleteMovie(@PathVariable String imdb){
        return ms.deleteMovie(imdb);
    }


}
