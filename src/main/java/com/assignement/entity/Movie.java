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

    @NotBlank(message = "title cannot be null")
    private String title;

    @NotBlank(message = "description cannot be null")
    private String description;

    @NotBlank(message = "rating cannot be null")
    private double rating;

    @NotBlank(message = "year cannot be null")
    private String year;

    @NotBlank(message = "imageUrl cannot be null")
    private String imageUrl;





}
