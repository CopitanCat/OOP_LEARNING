package service;

import domain.Product;
import repository.ItemList;

import java.util.Scanner;

public class WarehouseService {
    Scanner in = new Scanner(System.in);
    private final ItemList repository ;

    public WarehouseService(ItemList repository){
        this.repository = repository;
    }

    public void makeProduct(){
        System.out.print("name: ");
        String name = in.next();
        System.out.print(" category: ");
        String category = in.next();
        System.out.print(" article: ");
        int article = in.nextInt();
        System.out.print(" count: ");
        int count = in.nextInt();
        System.out.print(" Required Item Count: ");
        int minRequiredInventory = in.nextInt();
        this.repository.save(name, new Product(name, category, article, minRequiredInventory), count);
    }

    public void PrintInfo(){
        System.out.print("Please input name of item: ");
        String name = in.next();
        this.repository.read(name);
    }

    public void updateData(){
        System.out.print("name of item: ");
        String name = in.next();
        System.out.print("change count to: ");
        int count = in.nextInt();
        this.repository.update(name, count);
    }
    public void deleteItem(){
        System.out.print("name of item: ");
        String name = in.next();
        this.repository.delete(name);
    }

}
