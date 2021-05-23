package com.example.management.dao;

import com.example.management.dto.MovieDto;
import com.example.management.dto.MovieMapper;
import com.example.management.models.Movie;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDao extends EntityDao<Movie> {

    @Override
    Class<Movie> getModelClazz() {
        return Movie.class;
    }
}
