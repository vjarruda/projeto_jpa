package br.com.AulaJPA.main;

import br.com.AulaJPA.entities.*;
import br.com.AulaJPA.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class MainProduct {
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		ReviewDAO reviewDAO = new ReviewDAO();

		Product product = new Product();
		product.setName("Smartphone X");
		product.setDescription("Celular TOP");
		product.setPrice(2000.00);
		productDAO.salvar(product);

		Review review1 = new Review();
		review1.setName("Vinícius");
		review1.setComment("Ótimo produto, muito rápido!");
		review1.setRating(5);
		review1.setProduct(product);

		Review review2 = new Review();
		review2.setName("Anthony");
		review2.setComment("Não gostei muito");
		review2.setRating(2);
		review2.setProduct(product);

		List<Review> productReviews = new ArrayList<>();
		productReviews.add(review1);
		productReviews.add(review2);
		product.setReviews(productReviews);

		product.setReviews(productReviews);
		reviewDAO.salvar(review1);
		reviewDAO.salvar(review2);
		System.out.println("Produto salvo com reviews associadas:");
		System.out.println("- Nome: " + product.getName());
		System.out.println("- Descrição: " + product.getDescription());
		System.out.println("- Preço: R$ " + product.getPrice());

		System.out.println("\nReviews associadas ao produto:");
		for (Review review : product.getReviews()) {
			System.out.println("- " + review.getName() + ": " + review.getComment() + " [Nota: " + review.getRating() + "]");
		}

		System.out.println("\nAtualizando uma Review...");
		Review reviewToUpdate = product.getReviews().get(1);
		reviewToUpdate.setComment("Mudei de opinião, produto excelente!!");
		reviewToUpdate.setRating(5);
		reviewDAO.atualizar(reviewToUpdate);

		System.out.println("\nReviews após atualização:");
		for (Review r : reviewDAO.listar()) {
			System.out.println("- " + r.getName() + ": " + r.getComment() + " [Nota: " + r.getRating() + "]");
		}

		System.out.println("\nRemovendo a Review de Anthony...");
		reviewDAO.remover(reviewToUpdate.getId());

		System.out.println("\nReviews após remoção:");
		for (Review r : reviewDAO.listar()) {
			System.out.println("- " + r.getName() + ": " + r.getComment() + " [Nota: " + r.getRating() + "]");
		}
	}
}
