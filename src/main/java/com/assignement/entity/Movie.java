package com.assignement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class Movie {

    @Id
    private String imdb;
    private String title;
    private String description;
    private double rating;
    private String year;
    private String imageUrl;

    public Movie(String imdb, String title, String description, double rating, String year, String imageUrl) {
        this.imdb = imdb;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.year = year;
        this.imageUrl = imageUrl;
    }

    public Movie(){

    }

    public String getImdb() {
        return imdb;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public String getYear() {
        return year;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
