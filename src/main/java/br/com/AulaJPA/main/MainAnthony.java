package br.com.AulaJPA.main;

import br.com.AulaJPA.entities.AverageRate;
import br.com.AulaJPA.entities.Brand;
import br.com.AulaJPA.entities.Review;
import br.com.AulaJPA.entities.Type;
import br.com.AulaJPA.persistence.AverageRateDAO;
import br.com.AulaJPA.persistence.BrandDAO;
import br.com.AulaJPA.persistence.TypeDAO;

import java.util.ArrayList;

public class MainAnthony {
    public static void main(String[] args) {

        BrandDAO brandDao = new BrandDAO();
        TypeDAO typeDAO = new TypeDAO();
        AverageRateDAO averageRateDAO = new AverageRateDAO();

        Type typeService = new Type();
        typeService.setType("Service");

        Type typeProduct = new Type();
        typeProduct.setType("Product");

        typeDAO.salvar(typeProduct);
        typeDAO.salvar(typeService);

        Brand brand = new Brand();
        brand.setName("Petinho");

        Brand brand1 = new Brand();
        brand1.setName("Ouro Verde");

        brandDao.salvar(brand);
        brandDao.salvar(brand1);

        Review review1 = new Review();
        review1.setNota(5);

        Review review2 = new Review();
        review2.setNota(1);

        AverageRate rate = new AverageRate();
        rate.setReviews(new ArrayList<Review>());
        rate.getReviews().add(review1);
        rate.getReviews().add(review2);

        averageRateDAO.salvar(rate);

    }
}