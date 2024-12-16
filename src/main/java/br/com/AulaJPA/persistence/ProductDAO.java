package br.com.AulaJPA.persistence;

import br.com.AulaJPA.entities.Product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
	EntityManager em = emf.createEntityManager();
	
	public void salvar(Product product) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizar(Product product) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Product product = em.find(Product.class, id);
		if(product != null) {
			em.remove(product);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Product> listar() {
		EntityManager em = emf.createEntityManager();
		List<Product> products = em.createQuery("FROM Product", Product.class).getResultList();
		em.close();
		return products;
	}
	
	public Product buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Product product  = em.find(Product.class, id);
		em.close();
		return product;
	}
}
