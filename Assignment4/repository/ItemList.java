package repository;

import domain.Product;
import domain.Warehouse;

import java.util.HashMap;
import java.util.Map;

public class ItemList implements InventoryCreat, inventoryDelete, InventoryRead, InventoryUpdate{
    private final Warehouse warehouse;
    private final Map<String, Product> item = new HashMap<>();

    public ItemList(Warehouse warehouse){
        this.warehouse =warehouse;
    }

    @Override
    public void save(String name, Product product, int count) {
        this.item.put(name, product);
        this.warehouse.save(this.item.get(name), count);
    }

    @Override
    public void update(String name, int count) {
            warehouse.change(this.item.get(name), count);
    }

    @Override
    public void read(String name) {
        warehouse.read(this.item.get(name));
    }

    public Product readProduct(String name){
        return this.item.get(name);
    }

    @Override
    public void delete(String name) {
        warehouse.delete(this.item.get(name));
    }
    public Warehouse getWarehouse(){
        return warehouse;
    }
}
