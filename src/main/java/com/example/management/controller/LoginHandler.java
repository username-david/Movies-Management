package com.example.management.controller;

import java.io.*;

import jakarta.servlet.http.*;

public class LoginHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("movies");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("movies");
    }
}