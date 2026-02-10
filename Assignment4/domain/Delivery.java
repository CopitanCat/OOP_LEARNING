package domain;

import java.util.HashMap;
import java.util.Map;

public class Delivery extends Operation{
    private final Map<Product, Map<Integer, Integer>> DeliveryHistory = new HashMap<Product, Map<Integer, Integer>>();
    private final Map<Integer, Integer> supportDATA = new HashMap<>();

    @Override
    public void apply(Product product, int count){
        this.DeliveryHistory.put(product, supportDATA);
        int size = this.DeliveryHistory.get(product).size();
        supportDATA.put(1+size , count);
    }

    @Override
    public void getHistory() {
        if (!DeliveryHistory.isEmpty()) {
            for (Map.Entry<Product, Map<Integer, Integer>> history : this.DeliveryHistory.entrySet()) {
                System.out.println("Name: " + history.getKey().getName());
                System.out.println("Delivery History: " + history.getValue());
            }
        }
        else {
            System.out.println("History is empty");
        }
    }
}