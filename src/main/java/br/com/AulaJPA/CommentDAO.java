package br.com.AulaJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CommentDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
	EntityManager em = emf.createEntityManager();
	
	public void salvar(Comment comment) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizar(Comment comment) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(comment);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Comment comment = em.find(Comment.class, id);
		if(comment != null) {
			em.remove(comment);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Comment> listar() {
		EntityManager em = emf.createEntityManager();
		List<Comment> comments = em.createQuery("FROM Comment", Comment.class).getResultList();
		em.close();
		return comments;
	}
	
	public Comment buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Comment comment = em.find(Comment.class, id);
		em.close();
		return comment;
	}
}
