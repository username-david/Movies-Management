package com.example.management;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.example.management.model.Movie;

public class MovieHelper {
    public static Set<Movie> getMovies() {
        Movie endGame = new Movie.Builder(1, "End Game").image("image/EndGame.jpg").genre("Action").build();
        Movie dunkirk = new Movie.Builder(2, "Dunkirk").image("image/Dunkirk.jpg").genre("Action").build();
        Movie insideOut = new Movie.Builder(3, "Inside Out").image("image/InsideOut.jpg").genre("Action").build();
        Movie lalaland = new Movie.Builder(4, "Lalaland").image("image/Lalaland.jpg").genre("Action").build();
        Movie matBiec = new Movie.Builder(5, "Mat Biec").image("image/MatBiec.jpg").genre("Action").build();

        Set<Movie> movies = new HashSet<>();
        movies.add(endGame);
        movies.add(dunkirk);
        movies.add(insideOut);
        movies.add(lalaland);
        movies.add(matBiec);

        return movies;
    }

    public static byte getRating(int movieID) {
        return (byte) (Math.random()*6);
    }
}
