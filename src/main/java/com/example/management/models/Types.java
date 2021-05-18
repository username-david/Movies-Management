package com.example.management.models;

import javax.persistence.*;

@Entity
@Table(name = "movie_types")
public class Types extends BaseEntity{

    private String type;
    public Types() {
    }
    public Types(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(MovieTypes type) {
        this.type = type.toString();
    }
}
