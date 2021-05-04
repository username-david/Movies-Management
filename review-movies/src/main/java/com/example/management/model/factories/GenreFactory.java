package com.example.management.model.factories;

import com.example.management.model.Genre;
import com.example.management.model.genres.*;

public class GenreFactory {
    public static Genre createGenre(String genreName) {
        Genre genre;

        switch (genreName.toLowerCase()) {
            case "action":
                genre = new Action();
                break;
            case "comedy":
                genre = new Comedy();
                break;
            default:
                genre = null;
                break;
        };

        return genre;
    }
}
