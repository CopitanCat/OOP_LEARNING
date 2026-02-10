package domain;

import java.util.HashMap;
import java.util.Map;

public class Warehouse extends BaseEntity{
    private String name;

    private final Map<Integer, Integer> stock = new HashMap<>();

    public Warehouse(String name) {
        this.name = name;
    }

    public void updateStock(int productId, int quantityChange) {
        stock.put(productId, stock.getOrDefault(productId, 0) + quantityChange);
    }

    public int getStock(Integer productId) {
        return stock.getOrDefault(productId, 0);
    }

    public Map<Integer, Integer> getAllStock() {
        return stock;
    }

    public String getName(){
        return this.name;
    }


}