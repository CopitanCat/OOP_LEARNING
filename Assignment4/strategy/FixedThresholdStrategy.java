package strategy;
import domain.Warehouse;
import repository.RepositoryCRUD;
import service.ProductService;

import java.util.List;

// Стратегия: Пополнять, если меньше фиксированного порога
public class FixedThresholdStrategy implements RestockStrategy {
    @Override
    public boolean isRestockNeeded(int minStock, int currentQuantity) {
        return currentQuantity < minStock;
    }

    @Override
    public void Restoke(RepositoryCRUD<Warehouse> warehouses, ProductService productService) {
        List<Warehouse> ListWarehouse = warehouses.findAll();
        for (Warehouse warehouse : ListWarehouse){
            for (int id : warehouse.getProduct()){
                if (isRestockNeeded(warehouse.getMinStock(id),warehouse.getStock(id) )) {
                    System.out.println("Strategy of Restoke used to " + productService.getProductById(id).getName() + " in size of " + (warehouse.getMinStock(id) - warehouse.getStock(id)));
                    warehouse.getDelivery().apply(productService.getProductById(id), warehouse.getMinStock(id) - warehouse.getStock(id));
                    warehouse.updateStock(id, warehouse.getMinStock(id) - warehouse.getStock(id));
                }
            }
        }
    }
}