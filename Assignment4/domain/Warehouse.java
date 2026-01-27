package domain;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final Map<Product, Integer> product = new HashMap<>();

    public void save(Product product, int count){
        this.product.put(product, count);
    }

    public void read(Product product) {
        try {
            System.out.println("Name: " + product.getName() + " , In warehouse: " + this.product.get(product));
        } catch (Exception e) {
            System.out.println("Cant find Item!");
        }
    }

    public void change(Product product, int changeTo) {
        try {
            this.product.put(product, this.product.get(product) + changeTo);
        }
        catch (Exception e){
            System.out.println("Cant find Item!");
        }
    }

    public void delete(Product product) {
        try {
            this.product.remove(product);
        }
        catch (Exception e){
            System.out.println("Cant find item!");
        }
    }
}