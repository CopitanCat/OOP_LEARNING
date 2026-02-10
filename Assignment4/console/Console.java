package console;

import domain.Product;
import repository.RepositoryCRUD;
import repository.RepositoryProduct;
import repository.RepositoryWarehouse;
import service.ProductService;
import service.WarehouseService;
import strategy.FixedThresholdStrategy;

import java.lang.Thread;
import java.util.Scanner;



public class Console {
    private final ProductService productService =new ProductService(new RepositoryProduct());
    private final WarehouseService warehouseService = new WarehouseService(new RepositoryWarehouse(), new FixedThresholdStrategy());
    private final Scanner in = new Scanner(System.in);

    public void start() {
        System.out.println("===        Starting System of Warehouse       ===");
        System.out.println("===                  Operations               ===");
        System.out.println("===      Create entity:1 | Operations : 2     ===");
        String input = in.next();
        switch (input){
            case "1" -> Create();
            case "2" -> Operation();
        }
    }

    private void Create() {
        System.out.println("=== Create Product: 1   | Create Warehouse: 2 ===");
        String input = in.next();
        switch (input){
            case "1" -> CreateProduct();
            case "2" -> CreateWarehouse();
            default -> {
                return;
            }
        }
    }

    private void Operation(){
        System.out.println("=== Set Operation: 1   | Get Entity: 2 ===");
        getEntity();
    }

    public void setOperation(){

    }
    public void getEntity() {
        System.out.println("=== Get Product: 1   |  Get Warehouse: 2 ===");
        getALLWarehouse();
    }

    public void getALLWarehouse(){
        warehouseService.getAllWarehouse();
    }

    private void CreateProduct(){
        System.out.print("Name: ");
        String name = in.next();
        System.out.print("Category: ");
        String category = in.next();
        System.out.print("Min Stock: ");
        int minStock = in.nextInt();
        productService.createProduct(name,category,minStock);
    }

    private void CreateWarehouse(){
        System.out.print("Name: ");
        String name = in.next();
        warehouseService.createWarehouse(name);
    }

    private void printStockReport(int warehouseId) {

    }
}