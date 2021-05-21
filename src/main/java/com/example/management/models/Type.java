package com.example.management.models;

import javax.persistence.*;

@Entity
@Table(name = "type")
public class Type extends BaseEntity {
    private String name;

    public Type(String name) {
        this.name = name;
    }

    public Type() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
