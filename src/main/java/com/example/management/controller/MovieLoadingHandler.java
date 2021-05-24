package com.example.management.controller;

import com.example.management.dao.*;
import com.example.management.dto.*;
import com.example.management.dto.mapper.*;
import com.example.management.model.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.*;

/**
 * This controller is for dispatching a movie's information
 * from movie loading DAO to the movie list page.
 */
public class MovieLoadingHandler extends HttpServlet {

    private final String MOVIES = "movies";
    private final String GENRES = "genres";
    private final String MOVIE_LIST_PAGE = "/movies.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> movies = new MovieDao().getAll();
        
        MovieDto[] movieDtos = movies.stream().map(MovieMapper::from)
            .toArray(MovieDto[]::new);

        request.setAttribute(MOVIES, movieDtos);
        request.setAttribute(GENRES, new GenreDao().getAll());
        request.getRequestDispatcher(MOVIE_LIST_PAGE).forward(request, response);
    }
}
