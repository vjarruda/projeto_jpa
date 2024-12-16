package br.com.AulaJPA.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
private static 
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();
}
