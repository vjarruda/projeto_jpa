package br.com.AulaJPA;

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
		
		Comment comment1 = new Comment();
		comment1.setComentario("Muito bom");
		comment1.setProduct(product);
		
		Comment comment2 = new Comment();
		comment2.setComentario("Ruim");
		comment2.setProduct(product);
		
		Review review1 = new Review();
		review1.setNota(5);
		review1.setProduct(product);
		
		Review review2 = new Review();
		review2.setNota(1);
		review2.setProduct(product);
		
		product.setComments(new ArrayList<Comment>());
		product.getComments().add(comment1);
		product.getComments().add(comment2);
		
		
		product.setReviews(new ArrayList<Review>());
		product.getReviews().add(review1);
		product.getReviews().add(review2);
		
		dao.salvar(product);
		
		
	}
}
