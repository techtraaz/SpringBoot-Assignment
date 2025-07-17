package com.assignement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data  // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor

public class Movie {

    @Id
    private String imdb;

    @NotBlank(message = "title cannot be blank")
    private String title;

    
    private String description;
    private double rating;
    private String year;


    private String imageUrl;





}
