package com.example.management.dao;

import com.example.management.model.*;

public class RatingDao extends EntityDao<Rating> {

    @Override
    Class<Rating> getModelClass() {
        return Rating.class;
    }
}