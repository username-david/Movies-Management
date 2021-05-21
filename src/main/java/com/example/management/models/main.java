package com.example.management.models;

import com.example.management.dao.MovieDao;

public class main {
    public static void main(String [] args){

        MovieDao movieDao = new MovieDao();

        Type type1 = new Type("Comedy");
        Type type2 = new Type("Horror");

        Movie movie1 = new Movie.Builder("Dunkirk").description("nothing").type(type1).type(type2).image("image/Dunkirk.jpg").build();
        Movie movie2 = new Movie.Builder("End Game").description("nothing").type(type1).type(type2).image("image/EndGame.jpg").build();
        Movie movie3 = new Movie.Builder("Inside Out").description("nothing").type(type1).type(type2).image("image/InsideOut.jpg").build();
        Movie movie4 = new Movie.Builder("Lalaland").description("nothing").type(type1).type(type2).image("image/Lalaland.jpg").build();
        Movie movie5 = new Movie.Builder("Mat Biec").description("nothing").type(type1).type(type2).image("image/MatBiec.jpg").build();

        System.out.println("Before");

        movieDao.create(movie1);
        movieDao.create(movie2);
        movieDao.create(movie3);
        movieDao.create(movie4);
        movieDao.create(movie5);

//        System.out.println(movieDao.getAll().size());
//        movie1.setDescription("changed");
//        movieDao.update(movie1);

//        System.out.println(movieDao.findOne(movie1.getId()).getDescription());

//        movieDao.findOne(1);
//        movieDao.delete(movie);
        System.out.println("After");
    }
}
