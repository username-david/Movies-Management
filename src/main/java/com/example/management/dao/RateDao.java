package com.example.management.dao;

import com.example.management.models.Rate;

public class RateDao extends EntityDao<Rate> {

    @Override
    Class<Rate> getModelClazz() {
        return Rate.class;
    }
}
