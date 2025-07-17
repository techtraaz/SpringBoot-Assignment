package com.assignement.controller;


import com.assignement.dto.Response;
import com.assignement.entity.Movie;
import com.assignement.service.MovieService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/movies")


public class MovieController {

    private final MovieService ms;

    public MovieController(MovieService ms) {
        this.ms = ms;
    }


    @GetMapping("")
    public ResponseEntity<Response<List<Movie>>> getAllMovies(){
      return  ms.getAllMovies();

    }


    @GetMapping("/{imdb}")
    public ResponseEntity<Response<Movie>> getAllMoviesByImdb(@PathVariable String imdb){
        return ms.findByImdb(imdb);
    }

    @PostMapping("")
    public ResponseEntity<Response<String>> addMovie(@Valid @RequestBody Movie movie){
        return ms.addMovie(movie);
    }


    @DeleteMapping("/{imdb}")
    public ResponseEntity<Response<String>> deleteMovie(@PathVariable String imdb){
        return ms.deleteMovie(imdb);
    }


    @PutMapping("")
    public ResponseEntity<Response<String>> updateMovie(@RequestBody Movie movie){
        return ms.updateMovie(movie);
    }


}
