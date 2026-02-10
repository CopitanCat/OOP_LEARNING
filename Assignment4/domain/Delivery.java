package domain;

import java.util.HashMap;
import java.util.Map;

public class Delivery extends Operation{
    private final Map<Product, Map<Integer, Integer>> DeliveryHistory = new HashMap<Product, Map<Integer, Integer>>();

    @Override
    public void apply(Product product, int count){
        Map<Integer, Integer> supportDATA = new HashMap<>();
        this.DeliveryHistory.put(product, supportDATA);
        int size = this.DeliveryHistory.get(product).size();
        supportDATA.put(1+size, count);
    }

    @Override
    public void getHistory() {
        for (Map.Entry<Product, Map<Integer, Integer>> history : this.DeliveryHistory.entrySet()) {
            System.out.println("Name: " + history.getKey().getName());
            System.out.println("Delivery History: " + history.getValue());
        }
    }
}