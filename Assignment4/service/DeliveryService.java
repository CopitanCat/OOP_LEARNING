package service;

import domain.Delivery;
import domain.Product;
import domain.Warehouse;
import repository.ItemList;

import java.util.Scanner;

public class DeliveryService {
    Scanner in = new Scanner(System.in);
    private final Delivery delivery = new Delivery();
    private final ItemList itemList ;

    public DeliveryService(ItemList itemList){
        this.itemList = itemList;
    }

    public void setDelivery(){
        System.out.print("name of item: ");
        String name = in.next();
        System.out.print("Delivery count: ");
        int count = in.nextInt();
        this.delivery.deliveryApply(itemList.getWarehouse(),itemList.readProduct(name), count);
    }

    public void getHistory() {
        this.delivery.getHistory();
    }
}

