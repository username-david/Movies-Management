package com.example.management.dao;

import com.example.management.models.BaseEntity;

import javax.persistence.*;
import java.util.List;

public abstract class EntityDao<T extends BaseEntity> {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    abstract Class<T> getModelClazz();

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

    public T findOne(int id) {
        return entityManager.find(getModelClazz(), id);
    }

    public List<T> findAll(){
        return entityManager.createQuery( "from " + getModelClazz().getName())
                .getResultList();
    }


}
