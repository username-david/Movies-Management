package com.example.management.model;

import javax.persistence.*;

import java.util.*;

/**
 * 
 * @author Nhat Khanh Le
 * @author Hoai Do
 * @since 1.0
 */

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {
    
    @Column(nullable = false)
    private String name;
    private String description;
    private int manufactureYear;
    private GregorianCalendar releaseDate;
    private String image;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "movie_genre",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "movie",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Rating> ratings;

    /**
     * The {@code Builder} static nested class, which implements the 
     * Builder design pattern, supports creating a new movie through 
     * invoking a constructor, consecutive property-set methods, and 
     * ending with a {@code build()} method. For example: 
     * <blockquote><pre>
     *     Movie movie = new Movie.Builder("Movie Name")
     *          .description("Description for the movie")
     *          .manufactureYear(2020)
     *          .releaseDate(new GregorianCalendar())
     *          .genre("genre1")
     *          .genre("genre2")
     *          .image("poster")
     *          .build();
     * </pre></blockquote><p>
     */
    public static class Builder {
        private String name;
        private String description;
        private int manufactureYear;
        private GregorianCalendar releaseDate;
        private Set<Genre> genres;
        private String image;
        
        /**
         * Initializes a newly created {@code Builder} object with 
         * the name of the being created movie.
         * 
         * @param name the name of the being created movie.
         * 
         * @since 1.0 
         */
        public Builder(String name) {
            genres = new HashSet<>();
            this.name = name;
        }

        /**
         * Adds a description property to the being created movie.
         * 
         * @param description the description of the being created movie.
         * @return the current {@code Builder} invoking this method.
         * 
         * @since 1.0
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Adds the year of manufacture property to the being created movie.
         * 
         * @param manufactureYear the year of manufacture of the being created movie.
         * @return the current {@code Builder} invoking this method.
         * 
         * @since 1.0
         */
        public Builder manufactureYear(int manufactureYear) {
            this.manufactureYear = manufactureYear;
            return this;
        }

        /**
         * Adds the release date property to the being created movie.
         * 
         * @param releaseDate the release date of the being created movie.
         * @return the current {@code Builder} invoking this method.
         * 
         * @since 1.0
         */
        public Builder releaseDate(GregorianCalendar releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }
        
        /**
         * Adds a genre property to the being created movie.
         * 
         * @param genre the genre that the being created movie belongs to.
         * @return the current {@code Builder} invoking this method.
         * 
         * @since 1.0
         */
        public Builder genre(Genre genre) {
            genres.add(genre);
            return this;
        }

        /**
         * Adds an image property to the being created movie.
         * 
         * @param image the image address of the being created movie.
         * @return the current {@code Builder} invoking this method.
         * 
         * @since 1.0
         */
        public Builder image(String image) {
            this.image = image;
            return this;
        }

        /**
         * The {@code build()} method is the last one called in 
         * a sequence of method invocations for creating a new movie.
         * 
         * @return A new movie with at least two attributes that 
         * are ID and Name.
         * 
         * @since 1.0
         */
        public Movie build() {
            return new Movie(this);
        }
    }

    public Movie() {}

    private Movie(Builder builder) {
        name = builder.name;
        description = builder.description;
        manufactureYear = builder.manufactureYear;
        releaseDate = builder.releaseDate;
        genres = builder.genres;
        image = builder.image;
        ratings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public GregorianCalendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(GregorianCalendar releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public boolean addGenre(Genre genre) {
        if (genres == null) {
            genres = new HashSet<>();
        }
        return genres.add(genre);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}