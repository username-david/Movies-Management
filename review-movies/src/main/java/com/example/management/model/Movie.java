package com.example.management.model;

import java.util.*;

import com.example.management.model.factories.GenreFactory;

/**
 * Movie
 */

public class Movie {
    private int id;
    private String name;
    private Set<Genre> genreSet;

    public static class Builder {
        // Required parameters
        private int id;
        private String name;

        // Optional parameters - initialized to default values
        private Set<Genre> genreSet;  
        
        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
            genreSet = new HashSet<>();
        }

        // For adding a genre.
        public Builder genre(String genreName) {
            genreSet.add(GenreFactory.createGenre(genreName));
            return this;
        }

        // For building a real Movie instance.
        public Movie build() {
            return new Movie(this);
        }
    }

    private Movie(Builder builder) {
        id = builder.id;
        name = builder.name;
        genreSet = builder.genreSet;
    }
}
