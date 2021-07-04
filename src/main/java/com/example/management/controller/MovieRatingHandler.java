package com.example.management.controller;

import java.io.*;

import com.example.management.dao.*;
import com.example.management.model.*;

import jakarta.servlet.http.*;

public class MovieRatingHandler extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Movie ratedMovie = new MovieDao()
            .getById(Integer.parseInt(request.getParameter("movieId")));
        byte ratingValue = Byte.parseByte(request.getParameter("userRating"));

        ratedMovie.getRatings().add(new Rating(ratedMovie, ratingValue));
        
        new MovieDao().update(ratedMovie);

        response.sendRedirect("movies");
    }
}