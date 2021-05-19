package com.example.management.service;

import com.example.management.models.Movie;

import java.util.ArrayList;

public class MovieService {

    private ArrayList<Movie> list = new ArrayList();

    public ArrayList<Movie> getAllMovie() {
        Movie mv1 = new Movie.Builder("noname1").description("no name").build();
        Movie mv2 = new Movie.Builder("noname1").description("no name").build();
        Movie mv3 = new Movie.Builder("noname1").description("no name").build();
        Movie mv4 = new Movie.Builder("noname1").description("no name").build();
        Movie mv5 = new Movie.Builder("noname1").description("no name").build();
        Movie mv6 = new Movie.Builder("noname1").description("no name").build();

        list.add(mv1);
        list.add(mv2);
        list.add(mv3);
        list.add(mv4);
        list.add(mv5);
        list.add(mv6);

        return list;
    }
}
