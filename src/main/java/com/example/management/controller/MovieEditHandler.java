package com.example.management.controller;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import com.example.management.dao.*;
import com.example.management.model.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@MultipartConfig
public class MovieEditHandler extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Movie editedMovie = new MovieDao()
            .getById(Integer.parseInt(request.getParameter("movieId")));

        editedMovie.setName(request.getParameter("movieName"));
        editedMovie.setDescription(request.getParameter("description"));
        editedMovie.setManufactureYear(
            Integer.parseInt(request.getParameter("manufactureYear")));
        
        GregorianCalendar calendar = MovieAddingHandler.createCalendar(request);
        if (calendar != null) {
            editedMovie.setReleaseDate(calendar);
        }

        Part part = request.getPart("image");
        String fileName = part.getSubmittedFileName();

        // If there is a new uploaded image file.
        if (fileName != null && !fileName.equals("")) {
            String downloadFolder = getServletContext().getRealPath("") 
                + MovieAddingHandler.DOWNLOAD_DIR + File.separator;
            
            String currentImageName = editedMovie.getImage().split("/")[1];
            
            // If the current image is not the default image, 
            // delete it from the server.
            if (!currentImageName.equals(MovieAddingHandler.DEFAULT_POSTER)) {
                File currentImage = new File(downloadFolder + currentImageName);
                currentImage.delete();
            }

            part.write(downloadFolder + fileName);

            editedMovie.setImage(
                MovieAddingHandler.DOWNLOAD_DIR + "/" + fileName);
        }

        Map<String, Genre> existingGenres = new GenreDao().getAll()
            .stream().collect(Collectors.toMap(Genre::getName, eGenre -> eGenre));

        Set<Genre> addedGenreSet = new HashSet<>(); 
         
        Arrays.stream(request.getParameterValues("genres"))
            .forEach(genreString -> {
                if (existingGenres.containsKey(genreString)) {
                    addedGenreSet.add(existingGenres.get(genreString));
                } else {
                    addedGenreSet.add(new Genre(genreString));
                }
            });
            
        editedMovie.setGenres(addedGenreSet);
        
        new MovieDao().update(editedMovie);

        response.sendRedirect("movies");
    }
}