package com.example.management.controller;

import java.io.*;

import com.example.management.dao.*;
import com.example.management.dto.*;
import com.example.management.dto.mapper.*;
import com.example.management.model.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MovEditFormReqHdlr extends HttpServlet {
    
    private final String EDIT = "Edit";
    private final String MOVIE = "movie";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int movieId = Integer.parseInt(request.getParameter("movieId"));

        Movie movie = new MovieDao().getById(movieId);
        MovieDto movieDto = MovieMapper.from(movie);
        
        request.setAttribute(MovAddingFormReqHdlr.IS_VALID_USER, request.getParameter("isValidUser"));
        request.setAttribute(MovAddingFormReqHdlr.FORM_TYPE, EDIT);
        request.setAttribute(MOVIE, movieDto);
        request.getRequestDispatcher(MovAddingFormReqHdlr.MOVIE_ADDING_FORM)
            .forward(request, response);
    }
}