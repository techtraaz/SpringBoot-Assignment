package com.assignement.repo;

import com.assignement.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie,String> {

    @Override
    List<Movie> findAll();

    Movie findByImdb(String imdb);

}

