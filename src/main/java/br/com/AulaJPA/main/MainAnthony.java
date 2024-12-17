package br.com.AulaJPA.main;

import br.com.AulaJPA.entities.*;
import br.com.AulaJPA.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainAnthony {
    public static void main(String[] args) {
        BrandDAO brandDAO = new BrandDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        TypeDAO typeDAO = new TypeDAO();
        ProductDAO productDAO = new ProductDAO();
        ShopDAO shopDAO = new ShopDAO();


        //criarBanco(brandDAO, categoryDAO, shopDAO, typeDAO, productDAO);
        listarProdutosTodasLojas(shopDAO);
        listarProdutosUmaLoja(shopDAO, 1L);
    }

    private static void criarBanco(BrandDAO brandDAO, CategoryDAO categoryDAO, ShopDAO shopDAO, TypeDAO typeDAO, ProductDAO productDAO) {
        Brand samsungBrand = new Brand();
        samsungBrand.setName("Samsung");
        brandDAO.salvar(samsungBrand);

        Brand appleBrand = new Brand();
        appleBrand.setName("Apple");
        brandDAO.salvar(appleBrand);

        Brand xiaomiBrand = new Brand();
        xiaomiBrand.setName("Xiaomi");
        brandDAO.salvar(xiaomiBrand);

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
        System.out.println("Produto salvo com sucesso na Amazon!");

        Product appleProduct = new Product();
        appleProduct.setName("Apple XS");
        appleProduct.setDescription("SmartPhone");
        appleProduct.setPrice(15000.00);
        appleProduct.setBrand(appleBrand);
        appleProduct.setCategory(technologyCategory);
        appleProduct.setShop(amazonShop);
        appleProduct.setType(productType);
        productDAO.salvar(appleProduct);
        System.out.println("Produto salvo com sucesso na Amazon!");

        Product xiaomiProduct = new Product();
        xiaomiProduct.setName("POCO F3 ");
        xiaomiProduct.setDescription("SmartPhone");
        xiaomiProduct.setPrice(1500.00);
        xiaomiProduct.setBrand(xiaomiBrand);
        xiaomiProduct.setCategory(technologyCategory);
        xiaomiProduct.setShop(amazonShop);
        xiaomiProduct.setType(productType);
        productDAO.salvar(xiaomiProduct);
        System.out.println("Produto salvo com sucesso na Amazon!");

        Product samsungTv = new Product();
        samsungTv.setName("Samsung QLED 65");
        samsungTv.setDescription("Smart TV 4K UHD");
        samsungTv.setPrice(4000.00);
        samsungTv.setBrand(samsungBrand);
        samsungTv.setCategory(technologyCategory);
        samsungTv.setShop(americanasShop);
        samsungTv.setType(productType);
        productDAO.salvar(samsungTv);
        System.out.println("Produto salvo com sucesso na Americanas!");

        Product appleWatch = new Product();
        appleWatch.setName("Apple Watch Series 7");
        appleWatch.setDescription("Smartwatch Apple");
        appleWatch.setPrice(2500.00);
        appleWatch.setBrand(appleBrand);
        appleWatch.setCategory(technologyCategory);
        appleWatch.setShop(americanasShop);
        appleWatch.setType(productType);
        productDAO.salvar(appleWatch);
        System.out.println("Produto salvo com sucesso na Americanas!");

        Product xiaomiVacuum = new Product();
        xiaomiVacuum.setName("Xiaomi Vacuum Cleaner");
        xiaomiVacuum.setDescription("Robô aspirador inteligente");
        xiaomiVacuum.setPrice(1200.00);
        xiaomiVacuum.setBrand(xiaomiBrand);
        xiaomiVacuum.setCategory(technologyCategory);
        xiaomiVacuum.setShop(americanasShop);
        xiaomiVacuum.setType(productType);
        productDAO.salvar(xiaomiVacuum);
        System.out.println("Produto salvo com sucesso na Americanas!");

        productType.setProducts(new ArrayList<>());
        productType.getProducts().add(appleProduct);
        productType.getProducts().add(xiaomiProduct);
        productType.getProducts().add(samsungProduct);
        productType.getProducts().add(samsungTv);
        productType.getProducts().add(appleWatch);
        productType.getProducts().add(xiaomiVacuum);
        typeDAO.atualizar(productType);

        technologyCategory.setProducts(new ArrayList<>());
        technologyCategory.getProducts().add(appleProduct);
        technologyCategory.getProducts().add(xiaomiProduct);
        technologyCategory.getProducts().add(samsungProduct);
        technologyCategory.getProducts().add(samsungTv);
        technologyCategory.getProducts().add(appleWatch);
        technologyCategory.getProducts().add(xiaomiVacuum);
        categoryDAO.atualizar(technologyCategory);

        samsungBrand.setProducts(new ArrayList<>());
        samsungBrand.getProducts().add(samsungProduct);
        samsungBrand.getProducts().add(samsungTv);
        brandDAO.atualizar(samsungBrand);

        xiaomiBrand.setProducts(new ArrayList<>());
        xiaomiBrand.getProducts().add(xiaomiProduct);
        xiaomiBrand.getProducts().add(xiaomiVacuum);
        brandDAO.atualizar(xiaomiBrand);

        appleBrand.setProducts(new ArrayList<>());
        appleBrand.getProducts().add(appleProduct);
        appleBrand.getProducts().add(appleWatch);
        brandDAO.atualizar(appleBrand);

        amazonShop.setProducts(new ArrayList<>());
        amazonShop.getProducts().add(appleProduct);
        amazonShop.getProducts().add(xiaomiProduct);
        amazonShop.getProducts().add(samsungProduct);
        shopDAO.atualizar(amazonShop);

        americanasShop.setProducts(new ArrayList<>());
        americanasShop.getProducts().add(samsungTv);
        americanasShop.getProducts().add(appleWatch);
        americanasShop.getProducts().add(xiaomiVacuum);
        shopDAO.atualizar(americanasShop);

        System.out.println("Banco criado e dados salvos com sucesso!");

    }

    private static void listarProdutosUmaLoja(ShopDAO shopDAO, Long id) {
        Shop foundShop = shopDAO.buscarPorId(id);
        System.out.println("Loja "+foundShop.getName());
        for (Product product : foundShop.getProducts()) {
            System.out.println(product.getName());
        }
    }

    private static void listarProdutosTodasLojas(ShopDAO shopDAO) {
        List<Shop> shops = shopDAO.listar();
        System.out.println("\nLista de lojas e seus produtos:");
        for (Shop shop : shops) {
            System.out.println("Loja: " + shop.getId() + " " + shop.getName());
            List<Product> products = shop.getProducts();
            for (Product product : products) {
                System.out.println(
                        product.getId() + " | " +
                                product.getName() + " | " +
                                product.getBrand().getName() + " | " +
                                product.getCategory().getName() + " | " +
                                product.getType().getName() + " | " +
                                "R$" + product.getPrice() + " | " +
                                product.getDescription()
                );
            }
        }
    }
}
