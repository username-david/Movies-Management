package com.example.management.dao;

import com.example.management.model.*;

import javax.persistence.*;
import java.util.*;

public abstract class EntityDao<T extends BaseEntity> {

    private EntityManager entityManager = 
        Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa")
        .createEntityManager();

    abstract Class<T> getModelClass();

    public void update(T t) {
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
    }

    public void delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
        entityManager.getTransaction().commit();
    }

    public void create(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    public T getById(int id) {
        return entityManager.find(getModelClass(), id);
    }

    public List<T> getAll() {
        return entityManager
            .createQuery("from " + getModelClass().getName())
            .getResultList();
    }
}