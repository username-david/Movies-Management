package com.example.management.controller;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LogoutHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.logout();
        response.sendRedirect("movies");      
    }
}