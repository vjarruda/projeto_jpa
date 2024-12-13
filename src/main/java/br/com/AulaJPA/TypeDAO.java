package br.com.AulaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TypeDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();

    public void salvar(Type type) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(type);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Type type) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(type);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Type type = em.find(Type.class, id);
        if(type != null) {
            em.remove(type);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Type> listar() {
        EntityManager em = emf.createEntityManager();
        List<Type> types = em.createQuery("FROM Type", Type.class).getResultList();
        em.close();
        return types;
    }

    public Type buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Type type  = em.find(Type.class, id);
        em.close();
        return type;
    }
}