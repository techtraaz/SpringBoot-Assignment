package com.assignement.service;

import com.assignement.entity.Movie;
import com.assignement.repo.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepo movierepo;


    public MovieService(MovieRepo movierepo){
        this.movierepo = movierepo;
    }

    public List<Movie> getAllMovies(){
        return movierepo.findAll();
    }



}
