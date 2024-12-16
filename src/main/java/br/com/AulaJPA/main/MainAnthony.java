package br.com.AulaJPA.main;

import br.com.AulaJPA.entities.*;
import br.com.AulaJPA.persistence.ProductDAO;
import br.com.AulaJPA.persistence.BrandDAO;
import br.com.AulaJPA.persistence.CategoryDAO;
import br.com.AulaJPA.persistence.ShopDAO;
import br.com.AulaJPA.persistence.TypeDAO;

import java.util.ArrayList;
import java.util.List;

public class MainAnthony {
    public static void main(String[] args) {
        BrandDAO brandDAO = new BrandDAO();
        Brand brand = new Brand();
        brand.setName("Apple");
        brandDAO.salvar(brand);

        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName("Tecnologia");
        categoryDAO.salvar(category);

        ShopDAO shopDAO = new ShopDAO();
        Shop shop = new Shop();
        shop.setName("Amazon");
        shop.setCnpj("98765432109876");
        shopDAO.salvar(shop);

        TypeDAO typeDAO = new TypeDAO();
        Type type = new Type();
        type.setName("Laptop");
        typeDAO.salvar(type);

        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product.setName("MacBook Pro 16");
        product.setDescription("Laptop de alta performance");
        product.setPrice(15000.00);
        product.setBrand(brand);
        product.setCategory(category);
        product.setShop(shop);
        product.setType(type);


        Review review1 = new Review();
        review1.setName("João");
        review1.setComment("Excelente desempenho");
        review1.setRating(5);
        review1.setProduct(product);

        Review review2 = new Review();
        review2.setName("Ana");
        review2.setComment("Ótimo para trabalhos");
        review2.setRating(4);
        review2.setProduct(product);

        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);
        product.setReviews(reviews);


        productDAO.salvar(product);
        System.out.println("Produto salvo com sucesso!");


//        List<Product> products = productDAO.listar();
//        System.out.println("Lista de produtos:");
//        for (Product p : products) {
//            System.out.println("- " + p.getName() + ": " + p.getDescription());
//        }


        //product.setPrice(14500.00);
        //productDAO.atualizar(product);
        //System.out.println("Produto atualizado com sucesso!");


//        Product foundProduct = productDAO.buscarPorId(product.getId());
//        if (foundProduct != null) {
//            System.out.println("Produto encontrado: " + foundProduct.getName());
//        }
    }
}

