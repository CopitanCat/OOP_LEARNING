package service;

import domain.Product;
import domain.Warehouse;
import repository.RepositoryCRUD;

import java.util.ArrayList;
import java.util.List;


public class ProductService {
    private final RepositoryCRUD<Product> productRepository;

    public ProductService(RepositoryCRUD<Product> productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(String name, String category) {
        Product product = new Product(name, category);
        productRepository.save(product);
        System.out.println("Товар создан: " + product);
    }
    public Product getProductById(int id){
        return productRepository.findById(id);
    }
    public void getAllProducts() {
        List<Product> products = productRepository.findAll();
        for (Product product : products){
            System.out.println(product.getId()+". "+ product.getName());
        }
    }
    public List<Product> getListProduct(){
        return productRepository.findAll();
    }
    public void getProductByCategory(String category) {
        List<Product> products = productRepository.findAll();
        for (Product product : products){
            if (product.getCategory().equals(category)){
                System.out.println(product.getId()+". Name: "+ product.getName()+". Category: "+ product.getCategory());
            }
        }
    }

}