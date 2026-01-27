package repository;

import domain.Product;

public interface InventoryCreat {
    void save(String name, Product product, int count);
}
