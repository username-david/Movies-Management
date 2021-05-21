package com.example.management.dto;

import com.example.management.models.Movie;
import com.example.management.models.Rate;

public class MovieMapper {
    public MovieDto from(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        int avgRate = (int) Math.round(movie.getRates().stream()
                .mapToInt(Rate::getRatingValue)
                .average()
                .orElse(0));

        movieDto.setRatingAvg(avgRate);
        movieDto.setImg(movie.getImage());
        movieDto.setName(movie.getName());
        return movieDto;
    }


    public Movie from(MovieDto movieDto){

        return new Movie();
    }
}
