package com.example.management.dto;

public class MovieDto {

    private int id;
    private int ratingAvg;
    private String image;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(int ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImg(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
