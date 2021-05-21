package com.example.management.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {
    private String name;
    private String description;
    private int year;
    private Date releaseDay;
    private String image;

    public Movie() {
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_type",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<Type> typeSet = new HashSet<>();

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Rate> rates = new ArrayList();

    private Movie(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.year = builder.year;
        this.releaseDay = builder.releaseDay;
        this.image = builder.image;
        this.typeSet = builder.typeSet;
        this.rates = builder.rates;
    }

    public static class Builder {
        private String name;
        private String description;
        private int year;
        private Date releaseDay;
        private String image;
        private Set<Type> typeSet = new HashSet<>();
        private ArrayList rates = new ArrayList();

        public Builder(String name) {
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

        public Builder type(Type type) {
            typeSet.add(type);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(Date releaseDay) {
        this.releaseDay = releaseDay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Type> getTypesSet() {
        return typeSet;
    }

    public void setTypesSet(Set<Type> typeSet) {
        this.typeSet = typeSet;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}