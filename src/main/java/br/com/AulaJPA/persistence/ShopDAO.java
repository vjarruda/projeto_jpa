package br.com.AulaJPA.persistence;

import br.com.AulaJPA.entities.Shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ShopDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();

    public void salvar(Shop shop) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(shop);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Shop shop) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(shop);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Shop shop = em.find(Shop.class, id);
        if(shop != null) {
            em.remove(shop);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Shop> listar() {
        EntityManager em = emf.createEntityManager();
        List<Shop> shops = em.createQuery("FROM Shop", Shop.class).getResultList();
        em.close();
        return shops;
    }

    public Shop buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Shop shop = em.find(Shop.class, id);
        em.close();
        return shop;
    }
}