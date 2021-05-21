package com.example.management.controller;

import com.example.management.dao.MovieDao;
import com.example.management.dao.TypeDao;
import com.example.management.dto.MovieDto;
import com.example.management.dto.MovieMapper;
import com.example.management.models.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This controller is for dispatching a movie's information
 * from movie loading DAO to the movie list page.
 */
public class MovieLoadingHandler extends HttpServlet {

    private static final String MOVIES = "movies";
    private static final String TYPES = "types";
    private static final String MOVIES_PAGE = "/movies.jsp";

    private MovieDao movieDao = new MovieDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> movies = movieDao.getAll();
        MovieMapper movieMapper = new MovieMapper();
        List<MovieDto> movieDtos = movies.stream().map(movieMapper::from)
                .collect(Collectors.toList());

        request.setAttribute(MOVIES, movieDtos);
        request.setAttribute(TYPES, new TypeDao().getAll());
        request.getRequestDispatcher(MOVIES_PAGE).forward(request, response);
    }
}
