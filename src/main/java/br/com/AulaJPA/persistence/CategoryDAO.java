package br.com.AulaJPA.persistence;

import br.com.AulaJPA.entities.Category;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
	EntityManager em = emf.createEntityManager();
	
	public void salvar(Category category) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizar(Category category) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(category);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Category category = em.find(Category.class, id);
		if(category != null) {
			em.remove(category);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Category> listar() {
		EntityManager em = emf.createEntityManager();
		List<Category> categories = em.createQuery("FROM Comment", Category.class).getResultList();
		em.close();
		return categories;
	}
	
	public Category buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Category category = em.find(Category.class, id);
		em.close();
		return category;
	}
}
