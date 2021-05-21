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

    public Map<Integer, Integer> getRatings() {
        Map<Integer, Integer> ratings = new HashMap<>();
        List<Movie> movies = getAll();

        for ( Movie movie : movies ) {
            MovieDto movieDto = new MovieMapper().from(movie);
            ratings.put(movie.getId(), movieDto.getRatingAvg());
        }

        return ratings;
    }

}
