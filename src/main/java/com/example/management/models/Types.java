package com.example.management.models;

import javax.persistence.*;

@Entity
@Table(name = "types")
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

    public void setType(String type) {
        this.type = type;
    }
}
