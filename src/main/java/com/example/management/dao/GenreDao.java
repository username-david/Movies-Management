package com.example.management.dao;

import com.example.management.model.*;

public class GenreDao extends EntityDao<Genre> {

    @Override
    Class<Genre> getModelClass() {
        return Genre.class;
    }
}