package br.com.AulaJPA.main;

import br.com.AulaJPA.entities.*;
import br.com.AulaJPA.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class MainProduct {
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		BrandDAO brandDAO = new BrandDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		ReviewDAO reviewDAO = new ReviewDAO();
		ShopDAO shopDAO = new ShopDAO();
		TypeDAO typeDAO = new TypeDAO();

		Brand brand = new Brand();
		brand.setName("Samsung");
		brandDAO.salvar(brand);

		Category category = new Category();
		category.setName("Eletrônicos");
		categoryDAO.salvar(category);

		Shop shop = new Shop();
		shop.setName("Magalu");
		shop.setCnpj("12345678901234");
		shopDAO.salvar(shop);

		Type type = new Type();
		type.setName("Smartphone");
		typeDAO.salvar(type);

		Product product = new Product();
		product.setName("Smartphone X");
		product.setDescription("Celular TOP");
		product.setPrice(1200.00);
		product.setBrand(brand);
		product.setCategory(category);
		product.setShop(shop);
		product.setType(type);

		productDAO.salvar(product);

		Review review1 = new Review();
		review1.setName("Vini");
		review1.setComment("Bom produto!");
		review1.setRating(5);
		review1.setProduct(product);

		Review review2 = new Review();
		review2.setName("Anthony");
		review2.setComment("Produto ok");
		review2.setRating(4);
		review2.setProduct(product);

		reviewDAO.salvar(review1);
		reviewDAO.salvar(review2);

		List<Review> reviews = new ArrayList<>();
		reviews.add(review1);
		reviews.add(review2);
		product.setReviews(reviews);

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
