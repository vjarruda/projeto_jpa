package br.com.AulaJPA.persistence;

import br.com.AulaJPA.entities.Brand;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BrandDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();

    public void salvar(Brand brand) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(brand);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Brand brand) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(brand);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Brand brand = em.find(Brand.class, id);
        if(brand != null) {
            em.remove(brand);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Brand> listar() {
        EntityManager em = emf.createEntityManager();
        List<Brand> brands = em.createQuery("FROM Brand", Brand.class).getResultList();
        em.close();
        return brands;
    }

    public Brand buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Brand brand  = em.find(Brand.class, id);
        em.close();
        return brand;
    }
}
