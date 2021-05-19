package com.example.management.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.example.management.MovieHelper;
import com.example.management.model.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This controller is for dispatching a movie's information
 * from movie loading DAO to the movie list page. 
 */

public class MovieLoadingHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<Movie> movies = MovieHelper.getMovies();
        Map<Integer, Integer> ratings = MovieHelper.getRatings();

        request.setAttribute("movies", movies);
        request.setAttribute("ratings", ratings);
        request.getRequestDispatcher("/movies.jsp").forward(request, response);
    }
}
