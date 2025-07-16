package com.assignement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor

public class Movie {

    @Id
    private String imdb;


    private String title;
    private String description;
    private double rating;
    private String year;

    private String imageUrl;


}
