package com.assignement.service;

import com.assignement.dto.Response;
import com.assignement.entity.Movie;
import com.assignement.repo.MovieRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepo movierepo;


    public MovieService(MovieRepo movierepo){
        this.movierepo = movierepo;
    }

    public ResponseEntity<Response<List<Movie>>> getAllMovies(){

        List<Movie> movie = movierepo.findAll();

        if(movie.isEmpty()){
            Response<List<Movie>> response = new Response<>("11","success",null);
        }

        Response<List<Movie>> movies = new Response<>("00","movies",movie);

        return ResponseEntity.status(HttpStatus.OK).body(movies);

    }

    public ResponseEntity<Response<Movie>> findByImdb(String imdb){
        Movie movies = movierepo.findByImdb(imdb);
        if(movies == null){
            Response<Movie> response = new Response<>("00","no movies",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Response<Movie> response = new Response<>("00","movie by imdb",movies);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }

    public ResponseEntity<Response<String>> addMovie(Movie movie){
        movierepo.save(movie);
        Response<String> response = new Response<>("00","movie add",null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    public ResponseEntity<Response<String>> updateMovie(Movie movie){
        Movie movietoupdate = movierepo.findByImdb(movie.getImdb());
        if(movietoupdate == null){
            Response<String> response = new Response<>("00","movie not found",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        movietoupdate.setDescription(movie.getDescription());
        movietoupdate.setTitle(movie.getTitle());
        movietoupdate.setYear(movie.getYear());
        movietoupdate.setRating(movie.getRating());
        movietoupdate.setImageUrl(movie.getImageUrl());

        movierepo.save(movie);
        Response<String> response = new Response<>("00","movie updated",null);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    public ResponseEntity<Response<String>> deleteMovie(String imdb){
        Movie movietodelete = movierepo.findByImdb(imdb);
        if(movietodelete == null){
            Response<String> response = new Response<>("00","movie not found",null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        movierepo.delete(movietodelete);
        Response<String> response = new Response<>("00","movie deleted",null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
