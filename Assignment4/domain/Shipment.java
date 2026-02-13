package domain;

import java.util.*;

public class Shipment extends Operation{
    private final Map<Product, List<Map<Integer, Integer>>> ShipmentHistory = new HashMap<>();


    @Override
    public void apply(Product product, int count) {
        try {
            Map<Integer, Integer> supportDATA = new HashMap<>();
            List<Map<Integer, Integer>> supportList = new ArrayList<>();
            int size;
            if (this.ShipmentHistory.get(product) == null){
                size = 1;
            }else {
                size = this.ShipmentHistory.get(product).size()+1;
                supportList= ShipmentHistory.get(product);
            }

            supportDATA.put(size, count);
            supportList.add(supportDATA);
            this.ShipmentHistory.put(product, supportList);
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
    } @Override
    public void getHistory() {
        if (!ShipmentHistory.isEmpty()) {
            for (Product products : ShipmentHistory.keySet()) {
                System.out.print("Name: " + products.getName());
                System.out.print(" | Deliveries: ");
                for (int i = 0; i<ShipmentHistory.get(products).size();i++){
                    System.out.print( ShipmentHistory.get(products).get(i).get(i+1)+", ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("History is empty");
        }
    }
}
