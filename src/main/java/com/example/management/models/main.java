package com.example.management.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {
    public static void main(String [] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Types type1 = new Types("Comedy");

        Types type2 = new Types("Horror");
        Movie movie = new Movie.Builder("Lord").description("nothing").type(type1).type(type2).rates(5).build();

        Rate rate = new Rate();
        rate.setMovie(movie);
        rate.setRatingValue(5);

        entityManager.getTransaction().begin();

        entityManager.persist(type1);
        entityManager.persist(type2);
        entityManager.persist(movie);
        entityManager.persist(rate);

        entityManager.getTransaction().commit();
        entityManagerFactory.close();

    }
}
