package com.example.management.dao;

import com.example.management.models.Movie;

import javax.persistence.EntityManager;

public class MovieDao extends EntityDao<Movie> {

    @Override
    Class<Movie> getModelClazz() {
        return Movie.class;
    }
}
