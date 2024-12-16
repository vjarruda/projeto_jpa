package br.com.AulaJPA.main;

import br.com.AulaJPA.entities.*;
import br.com.AulaJPA.persistence.ProductDAO;

import java.util.ArrayList;
import java.util.List;

public class MainProduct {
	public static void main(String[] args) {
		Brand brand = new Brand();
		brand.setName("Brand A");

		Category category = new Category();
		category.setName("Electronics");

		Shop shop = new Shop();
		shop.setName("Tech Store");
		shop.setCnpj("12345678901234");

		Type type = new Type();
		type.setName("Smartphone");

		Product product = new Product();
		product.setName("Smartphone X");
		product.setDescription("A high-end smartphone with amazing features.");
		product.setPrice(1200.00);
		product.setBrand(brand);
		product.setCategory(category);
		product.setShop(shop);
		product.setType(type);

		Review review1 = new Review();
		review1.setName("John Doe");
		review1.setComment("Great product!");
		review1.setRating(5);
		review1.setProduct(product);

		Review review2 = new Review();
		review2.setName("Jane Smith");
		review2.setComment("Good value for money.");
		review2.setRating(4);
		review2.setProduct(product);

		List<Review> reviews = new ArrayList<>();
		reviews.add(review1);
		reviews.add(review2);
		product.setReviews(reviews);

		ProductDAO productDAO = new ProductDAO();

		productDAO.salvar(product);
		System.out.println("Produto salvo com sucesso!");

		List<Product> products = productDAO.listar();
		System.out.println("Lista de produtos:");
		for (Product p : products) {
			System.out.println("- " + p.getName() + ": " + p.getDescription());
		}

		product.setPrice(1100.00);
		productDAO.atualizar(product);
		System.out.println("Produto atualizado com sucesso!");
		
		Product foundProduct = productDAO.buscarPorId(product.getId());
		if (foundProduct != null) {
			System.out.println("Produto encontrado: " + foundProduct.getName());
		}
		
		
	}
}
