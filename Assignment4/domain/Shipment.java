package domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Shipment extends Operation{
    private final Map<Product, Map<Integer, Integer>> ShipmentHistory = new HashMap<Product, Map<Integer, Integer>>();

    @Override
    public void apply(Product product, int count){
        Map<Integer, Integer> supportDATA = new HashMap<>();
        this.ShipmentHistory.put(product, supportDATA);
        int size = this.ShipmentHistory.get(product).size();
        supportDATA.put(1+size, count);
    }

    @Override
    public void getHistory() {
        for (Map.Entry<Product, Map<Integer, Integer>> history : this.ShipmentHistory.entrySet()) {
            System.out.println("Name: " + history.getKey().getName());
            System.out.println("Delivery History: " + history.getValue());
        }
    }
}
