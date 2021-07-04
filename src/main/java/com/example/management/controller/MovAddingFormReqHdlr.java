package com.example.management.controller;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MovAddingFormReqHdlr extends HttpServlet {
    
    public static final String IS_VALID_USER = "isValidUser";
    public static final String FORM_TYPE = "formType";
    public static final String MOVIE_ADDING_FORM = "/WEB-INF/movieAddingForm.jsp";
    private final String ADD = "Add";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(IS_VALID_USER, request.getParameter("isValidUser"));
        request.setAttribute(FORM_TYPE, ADD);
        request.getRequestDispatcher(MOVIE_ADDING_FORM).forward(request, response);        
    }
}