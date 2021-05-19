package com.example.management.models;

import com.example.management.dao.MovieDao;
import com.example.management.dao.TypeDao;

public class main {
    public static void main(String[] args) {

        MovieDao movieDao = new MovieDao();
        TypeDao typeDao = new TypeDao();

        Types type1 = new Types("Comedy");

        Types type2 = new Types("Horror");
        typeDao.create(type1);
        typeDao.create(type2);

        Movie movie = new Movie.Builder("Lord").description("nothing").type(type1).type(type2).rates(5).build();

        System.out.println("Before");
        movieDao.create(movie);
        System.out.println(new MovieDao().findAll().size());

        //test update
        movie.setDescription("changed");
        movieDao.update(movie);

        System.out.println(new MovieDao().findOne(movie.getId()).getDescription());

        movieDao.findOne(1);
        movieDao.delete(movie);
        System.out.println("After");
    }
}
