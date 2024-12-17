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
        CategoryDAO categoryDAO = new CategoryDAO();
        ShopDAO shopDAO = new ShopDAO();
        TypeDAO typeDAO = new TypeDAO();
        ProductDAO productDAO = new ProductDAO();

        Brand samsungBrand = new Brand();
        samsungBrand.setName("Samsung");
        brandDAO.salvar(samsungBrand);

        Brand appleBrand = new Brand();
        appleBrand.setName("Apple");
        brandDAO.salvar(appleBrand);

        Brand xaomiBrand = new Brand();
        xaomiBrand.setName("Xaomi");
        brandDAO.salvar(xaomiBrand);

        Category technologyCategory = new Category();
        technologyCategory.setName("Technology");
        categoryDAO.salvar(technologyCategory);

        Category foodCategory = new Category();
        foodCategory.setName("Food");
        categoryDAO.salvar(foodCategory);

        Category cleaningCategory = new Category();
        cleaningCategory.setName("Cleaning");
        categoryDAO.salvar(cleaningCategory);

        Type productType = new Type();
        productType.setName("Product");
        typeDAO.salvar(productType);

        Type serviceType = new Type();
        serviceType.setName("Service");
        typeDAO.salvar(serviceType);

        Shop amazonShop = new Shop();
        amazonShop.setName("Amazon");
        amazonShop.setCnpj("15.436.940/0001-03");
        amazonShop.setProducts(new ArrayList<>());
        shopDAO.salvar(amazonShop);

        Shop americanasShop = new Shop();
        americanasShop.setName("Americanas");
        americanasShop.setCnpj("33.014.556/0098-19");
        shopDAO.salvar(americanasShop);

        Product samsungProduct = new Product();
        samsungProduct.setName("Samsung S22");
        samsungProduct.setDescription("SmartPhone");
        samsungProduct.setPrice(3500.00);
        samsungProduct.setBrand(samsungBrand);
        samsungProduct.setCategory(technologyCategory);
        samsungProduct.setShop(amazonShop);
        samsungProduct.setType(productType);
        productDAO.salvar(samsungProduct);
        System.out.println("Produto salvo com sucesso!");

        Product appleProduct = new Product();
        appleProduct.setName("Apple XS");
        appleProduct.setDescription("SmartPhone");
        appleProduct.setPrice(15000.00);
        appleProduct.setBrand(appleBrand);
        appleProduct.setCategory(technologyCategory);
        appleProduct.setShop(amazonShop);
        appleProduct.setType(productType);
        productDAO.salvar(appleProduct);
        System.out.println("Produto salvo com sucesso!");

        Product xaomiProduct = new Product();
        xaomiProduct.setName("POCO F3 ");
        xaomiProduct.setDescription("SmartPhone");
        xaomiProduct.setPrice(1500.00);
        xaomiProduct.setBrand(samsungBrand);
        xaomiProduct.setCategory(technologyCategory);
        xaomiProduct.setShop(amazonShop);
        xaomiProduct.setType(productType);
        productDAO.salvar(xaomiProduct);
        System.out.println("Produto salvo com sucesso!");

        productType.setProducts(new ArrayList<>());
        productType.getProducts().add(appleProduct);
        productType.getProducts().add(xaomiProduct);
        productType.getProducts().add(samsungProduct);
        typeDAO.atualizar(productType);

        technologyCategory.setProducts(new ArrayList<>());
        technologyCategory.getProducts().add(appleProduct);
        technologyCategory.getProducts().add(xaomiProduct);
        technologyCategory.getProducts().add(samsungProduct);
        categoryDAO.atualizar(technologyCategory);

        samsungBrand.setProducts(new ArrayList<>());
        samsungBrand.getProducts().add(samsungProduct);
        brandDAO.atualizar(samsungBrand);

        xaomiBrand.setProducts(new ArrayList<>());
        xaomiBrand.getProducts().add(xaomiProduct);
        brandDAO.atualizar(xaomiBrand);

        appleBrand.setProducts(new ArrayList<>());
        appleBrand.getProducts().add(appleProduct);
        brandDAO.atualizar(appleBrand);

        amazonShop.setProducts(new ArrayList<>());
        amazonShop.getProducts().add(appleProduct);
        amazonShop.getProducts().add(xaomiProduct);
        amazonShop.getProducts().add(samsungProduct);
        shopDAO.atualizar(amazonShop);


        List<Shop> shops = shopDAO.listar();
        System.out.println("\nLista de todos produtos:");
        for (Shop shop : shops) {
           List<Product> products = shop.getProducts();
            for (Product product : products){
                System.out.println(
                        product.getId()+" | "+
                        product.getName()+" | "+
                        product.getBrand().getName()+" | "+
                        product.getCategory().getName()+" | "+
                        product.getType().getName()+" | "+
                        "R$"+product.getPrice()+" | "+
                        product.getDescription());
            }
        }

//        System.out.println("\nAtualizando uma Review...");
//        review2.setComment("Mudei de opinião, produto excelente!!");
//        review2.setRating(5);
//        reviewDAO.atualizar(review2);
//
//        System.out.println("\nReviews após atualização:");
//        for (Review r : reviewDAO.listar()) {
//            System.out.println("- " + r.getName() + ": " + r.getComment() + " [Nota: " + r.getRating() + "]");
//        }
//
//        System.out.println("\nRemovendo a Review de Anthony");
//        reviewDAO.remover(review2.getId());
//
//        System.out.println("\nReviews após remoção:");
//        for (Review r : reviewDAO.listar()) {
//            System.out.println("- " + r.getName() + ": " + r.getComment() + " [Nota: " + r.getRating() + "]");
//        }


    }
}

