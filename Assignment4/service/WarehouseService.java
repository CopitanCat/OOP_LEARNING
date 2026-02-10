package service;

import domain.*;
import repository.RepositoryCRUD;
import strategy.RestockStrategy;

import java.util.List;

public class WarehouseService {
    private final RepositoryCRUD<Warehouse> warehouseRepository;
    private final RestockStrategy restockStrategy;

    public WarehouseService(RepositoryCRUD<Warehouse> warehouseRepository, RestockStrategy restockStrategy) {
        this.warehouseRepository = warehouseRepository;
        this.restockStrategy = restockStrategy;
    }
    public void getAllWarehouse() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        for (Warehouse warehouse : warehouses){
            System.out.println(warehouse.getId()+". "+ warehouse.getName());
        }
    }
    public void createWarehouse(String name) {
        warehouseRepository.save(new Warehouse(name));
    }

    public void processSupply(Integer warehouseId, Product product, int amount) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId);
        if (warehouse == null){
            throw new IllegalArgumentException("Склад не найден");
        }

        Operation supply = new Delivery();
        supply.apply(product, amount);
        warehouse.updateStock(product.getId(), amount); // Увеличиваем остаток

        System.out.println("Проведена " + supply);
    }

    public void processShipment(Integer warehouseId, Product product, int amount) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId);
        int currentStock = warehouse.getStock(product.getId());

        if (currentStock < amount) {
            System.out.println("ОШИБКА: Недостаточно товара " + product.getName());
            return;
        }

        Operation shipment = new Shipment();
        shipment.apply(product,amount);
        warehouse.updateStock(product.getId(), -amount); // Уменьшаем остаток

        System.out.println("Проведена " + shipment);

        if (restockStrategy.isRestockNeeded(product, warehouse.getStock(product.getId()))) {
            System.out.println("!!! ВНИМАНИЕ: Необходимо пополнить запасы товара: " + product.getName());
        }

    }

    public void printBalances(Integer warehouseId) {
        Warehouse w = warehouseRepository.findById(warehouseId);
        System.out.println("--- Остатки на складе " + w + " ---");
        w.getAllStock().forEach((prodId, qty) -> System.out.println("Product ID " + prodId + ": " + qty + " шт."));
    }
}