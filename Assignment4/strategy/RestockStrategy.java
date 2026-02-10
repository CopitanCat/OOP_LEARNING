package strategy;

import domain.Warehouse;
import repository.RepositoryCRUD;
import service.ProductService;

public interface RestockStrategy {
    boolean isRestockNeeded(int minStock, int currentQuantity);
    void Restoke(RepositoryCRUD<Warehouse> warehouses, ProductService productService);
}