package com.example.management.models;

import javax.persistence.*;
import java.util.*;
/**
 * Movie
 */
@Entity
@Table(name = "movie")
public class Movie extends BaseEntity{

    private String name;
    private String description;
    private int year;
    private Date releaseDay;
    private String image;

    @ManyToMany
    @JoinTable(
            name = "movie_type",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<Types> typesSet = new HashSet<>();

    @OneToMany(
            mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Rate> rates = new ArrayList();

    private Movie(Builder builder) {
        //id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.year = builder.year;
        this.releaseDay = builder.releaseDay;
        this.image = builder.image;
        this.typesSet = builder.typesSet;
//        this.rates = builder.rates;
    }

    public static class Builder {
//         Required parameters
//        private int id;
        private String name;
        private String description;
        private int year;
        private Date releaseDay;
        private String image;
        private Set<Types> typesSet = new HashSet<>();
        private ArrayList rates= new ArrayList();

        public Builder(String name) {
//            this.id = id;
            this.name = name;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder year(int year) {
            this.description = description;
            return this;
        }

        public Builder releaseDay(Date releaseDay) {
            this.releaseDay = releaseDay;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder type(Types type) {
            typesSet.add(type);
            return this;
        }

        public Builder rates(int rate) {
            rates.add(rate);
            return this;
        }

        // For building a real Movie instance.
        public Movie build() {
            return new Movie(this);
        }
    }
}