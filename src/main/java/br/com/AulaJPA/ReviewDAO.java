package br.com.AulaJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReviewDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
	EntityManager em = emf.createEntityManager();
	
	public void salvar(Review review) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(review);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizar(Review review) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(review);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Review review = em.find(Review.class, id);
		if(review != null) {
			em.remove(review);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Review> listar() {
		EntityManager em = emf.createEntityManager();
		List<Review> reviews = em.createQuery("From Review", Review.class).getResultList();
		em.close();
		return reviews;
	}
	
	public Review buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Review review = em.find(Review.class, id);
		em.close();
		return review;
	}
}
