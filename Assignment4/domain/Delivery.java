package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Delivery extends Operation{
    private final Map<Product, List<Map<Integer, Integer>>> DeliveryHistory = new HashMap<>();


    @Override
    public void apply(Product product, int count) {
        try {
            Map<Integer, Integer> supportDATA = new HashMap<>();
            List<Map<Integer, Integer>> supportList = new ArrayList<>();
            int size;
            if (this.DeliveryHistory.get(product) == null){
                size = 1;
            }else {
                size = this.DeliveryHistory.get(product).size()+1;
                supportList= DeliveryHistory.get(product);
            }

            supportDATA.put(size, count);
            supportList.add(supportDATA);
            this.DeliveryHistory.put(product, supportList);
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getHistory() {
        if (!DeliveryHistory.isEmpty()) {
            for (Product products : DeliveryHistory.keySet()) {
                System.out.print("Name: " + products.getName());
                System.out.print(" | Deliveries: ");
                for (int i = 0; i<DeliveryHistory.get(products).size();i++){
                    System.out.print( DeliveryHistory.get(products).get(i).get(i+1)+", ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("History is empty");
        }
    }
}