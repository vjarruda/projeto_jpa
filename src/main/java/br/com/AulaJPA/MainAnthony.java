package br.com.AulaJPA;

public class MainAnthony {
    public static void main(String[] args) {

        BrandDAO brandDao = new BrandDAO();
        TypeDAO typeDAO = new TypeDAO();
        AverageRateDAO averageRateDAO = new AverageRateDAO();

        Type typeService = new Type();
        typeService.setType("Service");

        Type typeProduct = new Type();
        typeProduct.setType("Product");

        Brand brand = new Brand();
        brand.setName("Petinho");

        Brand brand1 = new Brand();
        brand.setName("Ouro Verde");

        AverageRate rate = new AverageRate();

    }
}
