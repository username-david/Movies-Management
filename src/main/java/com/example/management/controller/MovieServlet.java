package com.example.management.controller;

import com.example.management.models.Movie;
import com.example.management.service.MovieService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {

    private MovieService movieService = new MovieService();
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException{
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList = movieService.getAllMovie();
        req.setAttribute("movieRecord", movieList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("movie.jsp");


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
