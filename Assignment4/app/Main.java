package app;

import domain.Warehouse;
import repository.ItemList;
import service.DeliveryService;
import service.WarehouseService;

import java.util.Scanner;

public class Main {
    static void main() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Warehouse warehouse = new Warehouse();
        ItemList repo = new ItemList(warehouse);
        WarehouseService warehouseService = new WarehouseService(repo);
        DeliveryService deliveryService = new DeliveryService(repo);
        while (true) {
            System.out.println("Save Item: 1           |    Update item: 2");
            System.out.println("Read Item: 3           |    Delete item: 4");
            System.out.println("Set Delivery item:5    |    Set Shipment item: 6");
            System.out.println("Get Delivery History:7 |    Get Shipment History:8");
            System.out.println("Quite from warehouse: anything else");
            String function = in.next();
            switch (function) {
                case "1" -> warehouseService.makeProduct();
                case "2" -> warehouseService.updateData();
                case "3" -> warehouseService.PrintInfo();
                case "4" -> warehouseService.deleteItem();
                case "5" -> deliveryService.setDelivery();
                case "7" -> deliveryService.getHistory();
                default -> {
                    return;
                }
            }
            Thread.sleep(700);
        }
    }
}
