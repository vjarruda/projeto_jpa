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

		System.out.println("Produto salvo: " + product.getName());

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

		reviewDAO.salvar(review1);
		reviewDAO.salvar(review2);

		System.out.println("\nReviews adicionadas ao produto " + product.getName());

		List<Review> reviews = reviewDAO.listar();
		System.out.println("\nLista de todas as Reviews:");
		for (Review r : reviews) {
			System.out.println("- " + r.getName() + ": " + r.getComment() + " [Nota: " + r.getRating() + "]");
		}

		System.out.println("\nAtualizando uma Review...");
		review2.setComment("Mudei de opinião, produto excelente!!");
		review2.setRating(5);
		reviewDAO.atualizar(review2);

		System.out.println("\nReviews após atualização:");
		for (Review r : reviewDAO.listar()) {
			System.out.println("- " + r.getName() + ": " + r.getComment() + " [Nota: " + r.getRating() + "]");
		}

		System.out.println("\nRemovendo a Review de Anthony");
		reviewDAO.remover(review2.getId());

		System.out.println("\nReviews após remoção:");
		for (Review r : reviewDAO.listar()) {
			System.out.println("- " + r.getName() + ": " + r.getComment() + " [Nota: " + r.getRating() + "]");
		}
	}
}
