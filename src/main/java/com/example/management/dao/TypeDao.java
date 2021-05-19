package com.example.management.dao;

import com.example.management.models.Types;

public class TypeDao extends EntityDao<Types> {

    @Override
    Class<Types> getModelClazz() {
        return Types.class;
    }
}
