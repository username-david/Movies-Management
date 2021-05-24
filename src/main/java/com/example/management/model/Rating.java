package com.example.management.model;

import javax.persistence.*;

@Entity
public class Rating extends BaseEntity{
    
    @ManyToOne
    private Movie movie;

    private byte ratingValue;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public byte getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(byte ratingValue) {
        this.ratingValue = ratingValue;
    }
}
