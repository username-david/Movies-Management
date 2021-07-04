package com.example.management.controller;

import java.io.*;

import com.example.management.dao.*;
import com.example.management.model.*;

import jakarta.servlet.http.*;

public class MovieDeletingHandler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        Movie movie = new MovieDao().getById(movieId);

        // delete the relation of the movie to its genre set.
        movie.setGenres(null);

        String downloadPath = getServletContext().getRealPath("") 
            + MovieAddingHandler.DOWNLOAD_FOLDER + File.separator;

        // delete the movie's poster.
        MovieEditHandler.deleteMoviePoster(movie, downloadPath);
        
        // delete the movie from the database.
        new MovieDao().delete(movie);

        response.sendRedirect("movies");
    }
}