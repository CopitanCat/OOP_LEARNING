package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse extends BaseEntity{
    private String name;
    private final Map<Integer, Integer> minStock =new HashMap<>();
    private final Map<Integer, Integer> stock = new HashMap<>();
    private Operation delivery;
    private Operation shipment;


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

    public void setProductAndMinStock(Integer productid, int minStock){
        this.minStock.put(productid, minStock);
    }

    public void setDelAndShip(Operation delivery, Operation shipment) {
        this.delivery = delivery;
        this.shipment = shipment;
    }

    public int getMinStock(Integer productid){
        return this.minStock.get(productid);
    }
    public Set<Integer> getProduct(){
        return this.minStock.keySet();
    }

    public Operation getDelivery(){
        return this.delivery;
    }
    public Operation getShipment(){
        return this.shipment;
    }
}