package com.example.management.controller;

import com.example.management.dao.*;
import com.example.management.dto.*;
import com.example.management.dto.mapper.*;
import com.example.management.model.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * This controller is for dispatching movies' information
 * from DAO, a movie loader, to the movie list page.
 */
public class MovieLoadingHandler extends HttpServlet {

    private final String MOVIES = "movies";
    private final String SELECTED_GENRE = "selectedGenre";
    private final String GENRES = "usedGenres";
    private final String MOVIE_LIST_PAGE = "/movies.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedGenre = request.getParameter("genreSelection");
        
        List<Movie> movies = new MovieDao().getAll();
        List<MovieDto> movieDtos = movies.stream().map(MovieMapper::from)
            .collect(Collectors.toList());
        List<MovieDto> movieDtoDummies = new ArrayList<>(movieDtos);

        if (selectedGenre != null && !selectedGenre.equals("") && !selectedGenre.equals("All")) {
            Iterator<MovieDto> movieDtosItr = movieDtos.iterator();
            
            while (movieDtosItr.hasNext()) {
                if ( !movieDtosItr.next().getGenres().contains(selectedGenre) ) {
                    movieDtosItr.remove();
                }
            }
        } else if (selectedGenre == null || selectedGenre.equals("")) {
            selectedGenre = "All";
        }
        
        List<Genre> usedGenres = new ArrayList<>();

        (new GenreDao().getAll()).stream().forEach(existingGenre -> {
            boolean isGenreUsed = movieDtoDummies.stream()
                .anyMatch(movDtoDum -> movDtoDum.getGenres().contains(existingGenre.getName()));
            
            if (isGenreUsed) {
                usedGenres.add(existingGenre);
            }
        });
        Collections.sort(usedGenres);

        request.setAttribute(MOVIES, movieDtos);
        request.setAttribute(SELECTED_GENRE, selectedGenre);
        request.setAttribute(GENRES, usedGenres);
        request.getRequestDispatcher(MOVIE_LIST_PAGE).forward(request, response);
    }
}