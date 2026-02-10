package service;

import domain.Product;
import repository.RepositoryCRUD;

import java.util.List;


public class ProductService {
    private final RepositoryCRUD<Product> productRepository;

    public ProductService(RepositoryCRUD<Product> productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(String name, String category, int minStock) {
        Product product = new Product(name, category, minStock);
        productRepository.save(product);
        System.out.println("Товар создан: " + product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}