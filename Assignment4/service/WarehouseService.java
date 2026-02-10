package service;

import domain.*;
import repository.RepositoryCRUD;
import strategy.FixedThresholdStrategy;
import strategy.RestockStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseService {
    private final RepositoryCRUD<Warehouse> warehouseRepository;
    private final RestockStrategy restockStrategy = new FixedThresholdStrategy();

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
        Warehouse newWarehouse = new Warehouse(name);
        newWarehouse.setDelAndShip(new Delivery(), new Shipment());
        warehouseRepository.save(newWarehouse);

    }

    public void processDelivery(Integer warehouseId, Product product, int amount){
        Warehouse warehouse = warehouseRepository.findById(warehouseId);
        if (warehouse == null){
            throw new IllegalArgumentException("Склад не найден");
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
                System.out.println("ОШИБКА: Недостаточно товара " + product.getName());
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
        if (warehouseRepository.findById(warehouseFrom).getStock(product.getId()) <= count) {
            processShipment(warehouseFrom, product, count);
            processDelivery(warehouseTo, product, count);
        }
        else {
            System.out.println("Недостаточна товаров");
        }
    }
}