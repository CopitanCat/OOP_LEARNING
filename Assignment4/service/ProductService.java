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
        if (!productRepository.getNames().contains(name)) {
            Product product = new Product(name, category);
            productRepository.save(product, name);
            System.out.println("Product created: " + product.getName()+".");
        }
        else {
            System.out.println("Product is already exist.");
        }
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

    public void DeleteProduct(int id){
        String name = productRepository.findById(id).getName();
        productRepository.delete(id);
        System.out.println("Product "+ name + "is deleted!");
    }

}