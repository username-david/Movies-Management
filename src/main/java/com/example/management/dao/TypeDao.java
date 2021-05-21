package com.example.management.dao;

import com.example.management.models.Type;

public class TypeDao extends EntityDao<Type> {

    @Override
    Class<Type> getModelClazz() {
        return Type.class;
    }
}
