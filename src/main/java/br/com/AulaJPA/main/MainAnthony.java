package br.com.AulaJPA.main;

import br.com.AulaJPA.entities.*;
import br.com.AulaJPA.persistence.ProductDAO;
import br.com.AulaJPA.persistence.BrandDAO;
import br.com.AulaJPA.persistence.CategoryDAO;
import br.com.AulaJPA.persistence.ShopDAO;
import br.com.AulaJPA.persistence.TypeDAO;

import java.util.List;

public class MainAnthony {
    public static void main(String[] args) {
        BrandDAO brandDAO = new BrandDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        ShopDAO shopDAO = new ShopDAO();
        TypeDAO typeDAO = new TypeDAO();
        ProductDAO productDAO = new ProductDAO();

        // Criar e salvar entidades auxiliares (Brand, Category, Shop, Type)
        Brand brand = new Brand();
        brand.setName("Apple");
        brandDAO.salvar(brand);

        Category category = new Category();
        category.setName("Tecnologia");
        categoryDAO.salvar(category);

        Shop shop = new Shop();
        shop.setName("Amazon");
        shop.setCnpj("98765432109876");
        shopDAO.salvar(shop);

        Type type = new Type();
        type.setName("Laptop");
        typeDAO.salvar(type);

        // Criar e salvar um produto
        Product product = new Product();
        product.setName("MacBook Pro 16");
        product.setDescription("Laptop de alta performance");
        product.setPrice(15000.00);
        product.setBrand(brand);
        product.setCategory(category);
        product.setShop(shop);
        product.setType(type);
        productDAO.salvar(product);
        System.out.println("Produto salvo com sucesso!");

        // Atualizar o produto
        product.setPrice(14500.00);
        productDAO.atualizar(product);
        System.out.println("Produto atualizado com sucesso!");

        // Buscar o produto pelo ID
        Product foundProduct = productDAO.buscarPorId(product.getId());
        if (foundProduct != null) {
            System.out.println("Produto encontrado: " + foundProduct.getName());
            System.out.println("Descrição: " + foundProduct.getDescription());
            System.out.println("Preço: " + foundProduct.getPrice());
        } else {
            System.out.println("Produto não encontrado!");
        }

        // Listar todos os produtos
        List<Product> products = productDAO.listar();
        System.out.println("Lista de produtos:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + ": " + p.getDescription() + " (R$ " + p.getPrice() + ")");
        }

        // Remover o produto
        productDAO.remover(product.getId());
        System.out.println("Produto removido com sucesso!");

        // Listar novamente para confirmar a remoção
        products = productDAO.listar();
        System.out.println("Lista de produtos após remoção:");
        if (products.isEmpty()) {
            System.out.println("Nenhum produto encontrado!");
        } else {
            for (Product p : products) {
                System.out.println("- " + p.getName());
            }
        }
    }
}

