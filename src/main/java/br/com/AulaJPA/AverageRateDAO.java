package br.com.AulaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AverageRateDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();

    public void salvar(AverageRate averageRate) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(averageRate);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(AverageRate averageRate) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(averageRate);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        AverageRate averageRate = em.find(AverageRate.class, id);
        if(averageRate != null) {
            em.remove(averageRate);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<AverageRate> listar() {
        EntityManager em = emf.createEntityManager();
        List<AverageRate> averageRates = em.createQuery("FROM AverageRate", AverageRate.class).getResultList();
        em.close();
        return averageRates;
    }

    public AverageRate buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        AverageRate averageRate  = em.find(AverageRate.class, id);
        em.close();
        return averageRate;
    }
}