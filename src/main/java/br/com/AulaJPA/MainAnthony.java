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

        typeDAO.salvar(typeProduct);
        typeDAO.salvar(typeService);

        Brand brand = new Brand();
        brand.setName("Petinho");

        Brand brand1 = new Brand();
        brand.setName("Ouro Verde");

        brandDao.salvar(brand);
        brandDao.salvar(brand1);


        AverageRate rate = new AverageRate();

    }
}
