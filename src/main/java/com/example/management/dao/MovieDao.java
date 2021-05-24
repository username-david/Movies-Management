package com.example.management.dao;

import com.example.management.model.*;

public class MovieDao extends EntityDao<Movie> {

    @Override
    Class<Movie> getModelClass() {
        return Movie.class;
    }
}