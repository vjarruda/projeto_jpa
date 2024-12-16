package br.com.AulaJPA.main;

import br.com.AulaJPA.entities.Category;
import br.com.AulaJPA.entities.Product;
import br.com.AulaJPA.entities.Review;
import br.com.AulaJPA.entities.Type;
import br.com.AulaJPA.persistence.ProductDAO;

import java.util.ArrayList;

public class MainProduct {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		
		Type type = new Type();
		type.setType("Produto");
		
		Product product = new Product();
		product.setNome("café");
		product.setDescricao("Café preto em pó");
		product.setPreco(10.50);
		product.setType(type);
		
		Category category1 = new Category();
		category1.setComentario("Muito bom");
		category1.setProduct(product);
		
		Category category2 = new Category();
		category2.setComentario("Ruim");
		category2.setProduct(product);
		
		Review review1 = new Review();
		review1.setNota(5);
		review1.setProduct(product);
		
		Review review2 = new Review();
		review2.setNota(1);
		review2.setProduct(product);
		
		product.setComments(new ArrayList<Category>());
		product.getComments().add(category1);
		product.getComments().add(category2);
		
		
		product.setReviews(new ArrayList<Review>());
		product.getReviews().add(review1);
		product.getReviews().add(review2);
		
		dao.salvar(product);
		
		
	}
}
