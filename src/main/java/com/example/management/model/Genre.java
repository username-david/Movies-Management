package com.example.management.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre extends BaseEntity {

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
}
