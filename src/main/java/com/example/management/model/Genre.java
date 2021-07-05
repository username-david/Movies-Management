package com.example.management.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre extends BaseEntity implements Comparable<Genre> {

    @Column(nullable = false)
    private String name;

    public Genre() {}

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Genre) obj).getName());
    }

    @Override
    public int compareTo(Genre genre) {
        return name.compareTo(genre.getName());
    }
}