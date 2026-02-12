package service;

import domain.*;
import repository.RepositoryCRUD;
import strategy.RestockingProduct;
import strategy.RestockStrategy;

import java.util.List;

public class WarehouseService {
    private final RepositoryCRUD<Warehouse> warehouseRepository;
    private final RestockStrategy restockStrategy = new RestockingProduct();

    public WarehouseService(RepositoryCRUD<Warehouse> warehouseRepository) {
        this.warehouseRepository = warehouseRepository;

    }

    public void getAllWarehouse() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        for (Warehouse warehouse : warehouses){
            System.out.println(warehouse.getId()+". "+ warehouse.getName());
        }
    }

    public void setProductAndMinStock(int warehouseId ,Product product, int minStock) {
        warehouseRepository.findById(warehouseId).setProductAndMinStock(product.getId(), minStock);
    }

    public void createWarehouse(String name) {
        if(!warehouseRepository.getNames().contains(name)) {
            Warehouse newWarehouse = new Warehouse(name);
            newWarehouse.setDelAndShip(new Delivery(), new Shipment());
            warehouseRepository.save(newWarehouse, name);
            System.out.println("Warehouse "+ name + " created.");
        }
        else {
            System.out.println("Warehouse is already exist.");
        }
    }

    public void processDelivery(Integer warehouseId, Product product, int amount){
        Warehouse warehouse = warehouseRepository.findById(warehouseId);
        if (warehouse == null){
            throw new IllegalArgumentException("Warehouse is not exist");
        }

        warehouse.getDelivery().apply(product, amount);
        warehouse.updateStock(product.getId(), amount); // Увеличиваем остаток

        System.out.println("Проведена доставка");

    }

    public void DeliveryHistory(Integer warehouseId){

        warehouseRepository.findById(warehouseId).getDelivery().getHistory();
    }

    public void processShipment(Integer warehouseId, Product product, int amount) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId);
        int currentStock = warehouse.getStock(product.getId());
        if (currentStock < amount) {
                System.out.println("ERROR: Недостаточно товара " + product.getName());
                return;
        }



        warehouse.getShipment().apply(product,amount);
        warehouse.updateStock(product.getId(), -amount);

        System.out.println("Проведена выгрузка");

    }

    public void ShipmentHistory(int warehouseId){
        warehouseRepository.findById(warehouseId).getShipment().getHistory();
    }

    public void Restock(ProductService productService){
        restockStrategy.Restoke( warehouseRepository, productService);
    }

    public void printBalances(Integer warehouseId, ProductService product) {
        Warehouse w = warehouseRepository.findById(warehouseId);
        System.out.println("--- Остатки на складе " + w.getName() + " ---");
        w.getAllStock().forEach((prodId, qty) -> System.out.println("Product Name- " + product.getProductById(prodId).getName() + ": " + qty + " шт."));
    }
    public void move(int warehouseFrom, int warehouseTo, Product product,int count)  {
        if (warehouseRepository.findById(warehouseFrom).getStock(product.getId()) >= count) {
            processShipment(warehouseFrom, product, count);
            processDelivery(warehouseTo, product, count);
        }
        else {
            System.out.println("Недостаточна товаров");
        }
    }
    public void DeleteWarehouse(int id){
        String name = warehouseRepository.findById(id).getName();
        warehouseRepository.delete(id);
        System.out.println("Warehouse "+ name + "is deleted!");
    }
}