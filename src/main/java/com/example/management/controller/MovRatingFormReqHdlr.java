package com.example.management.controller;

import java.io.*;

import com.example.management.dao.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MovRatingFormReqHdlr extends HttpServlet {
    
    private final String MOVIE_ID = "movieId";
    private final String MOVIE_NAME = "movieName";
    public static final String MOVIE_RATING_FORM = "/WEB-INF/movieRatingForm.jsp";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        String movieName = new MovieDao().getById(movieId).getName();
        
        request.setAttribute(MovAddingFormReqHdlr.IS_VALID_USER, request.getParameter("isValidUser"));
        request.setAttribute(MOVIE_ID, movieId);
        request.setAttribute(MOVIE_NAME, movieName);

        request.getRequestDispatcher(MOVIE_RATING_FORM).forward(request, response);
    }
}