package com.example.management.dto.mapper;

import java.util.*;
import java.util.stream.Collectors;

import com.example.management.dto.*;
import com.example.management.model.*;

public class MovieMapper {

    public static MovieDto from(Movie movie) {
        MovieDto movieDto = new MovieDto();

        movieDto.setId(movie.getId());
        movieDto.setName(movie.getName());
        movieDto.setDescription(movie.getDescription());
        movieDto.setManufactureYear(movie.getManufactureYear());

        GregorianCalendar releaseDate = movie.getReleaseDate();
        String releaseDateString = null;

        if (releaseDate != null) {
            int month = releaseDate.get(Calendar.MONTH);
            int date = releaseDate.get(Calendar.DATE);
    
            String monthString = (++month) < 10 ? ("0" + month) : ("" + month);
            String dateString = date < 10 ? ("0" + date) : ("" + date);
    
            releaseDateString = releaseDate.get(Calendar.YEAR) + "-" + monthString + "-" + dateString;
        } 
        
        movieDto.setReleaseDate(releaseDateString);

        Set<String> genres = movie.getGenres().stream()
            .map(Genre::getName).collect(Collectors.toSet());

        movieDto.setGenres(genres);
        movieDto.setImage(movie.getImage());

        byte avgRating = (byte) Math.round(
            movie.getRatings().stream()
            .mapToInt(Rating::getRatingValue)
            .average().orElse(0)
        );

        movieDto.setAvgRating(avgRating);
        
        return movieDto;
    }
}
