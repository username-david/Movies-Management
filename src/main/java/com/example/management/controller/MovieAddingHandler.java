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
public class MovieAddingHandler extends HttpServlet {

    static final String DOWNLOAD_DIR = "image";
    static final String DEFAULT_POSTER = "no-poster-available.jpg";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Movie.Builder builder = new Movie.Builder(request.getParameter("movieName"))
            .description(request.getParameter("description"))
            .manufactureYear(Integer.parseInt(request.getParameter("manufactureYear")));
        
        GregorianCalendar calendar = createCalendar(request);
        if (calendar != null) {
            builder = builder.releaseDate(calendar);
        }

        Part part = request.getPart("image");
        String fileName = part.getSubmittedFileName();

        if (fileName == null || fileName.equals("")) {
            builder = builder.image(DOWNLOAD_DIR + "/" + DEFAULT_POSTER);
        } else {
            String downloadPath = getServletContext().getRealPath("") 
                + DOWNLOAD_DIR + File.separator + fileName;
            part.write(downloadPath);

            builder = builder.image(DOWNLOAD_DIR + "/" + fileName);
        }

        ArrayList<String> addedGenreList = new ArrayList<>(
                Arrays.asList(request.getParameterValues("genres")));
                
        Map<String, Genre> existingGenres = new GenreDao().getAll()
            .stream().collect(Collectors.toMap(Genre::getName, eGenre -> eGenre));

        if (existingGenres != null) {
            for (int i = 0; i < addedGenreList.size(); i++) {
                String addedGenre = addedGenreList.get(i);

                if (existingGenres.containsKey(addedGenre)) {
                    continue;
                } else {
                    builder = builder.genre(new Genre(addedGenre));
                    addedGenreList.remove(addedGenre);
                }
            }
        } else {
            for (int i = 0; i < addedGenreList.size(); i++) {
                String addedGenre = addedGenreList.get(i);
                builder = builder.genre(new Genre(addedGenre));
                addedGenreList.remove(addedGenre);
            }
        }

        MovieDao movieDao = new MovieDao();
        Movie movie = builder.build();
        movieDao.create(movie);

        if (addedGenreList.size() != 0) {
            for (String addedGenre : addedGenreList) {
                movie.addGenre(existingGenres.get(addedGenre));
            }
            movieDao.update(movie);
        }
        
        response.sendRedirect("movies");
    }
    
    static GregorianCalendar createCalendar(HttpServletRequest request) {
        String releaseDateString = request.getParameter("releaseDate");
        
        if (releaseDateString != null && !releaseDateString.equals("")) {
            String[] releaseDateTokens = releaseDateString.split("-");

            int year = Integer.parseInt(releaseDateTokens[0]);
            int month = (Integer.parseInt(releaseDateTokens[1]) - 1);
            int date = Integer.parseInt(releaseDateTokens[2]);

            return new GregorianCalendar(year, month, date);
        }
        return null;
    }
}