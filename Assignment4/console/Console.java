package console;


import repository.RepositoryProduct;
import repository.RepositoryWarehouse;
import service.ProductService;
import service.WarehouseService;



import java.util.Scanner;



public class Console {
    private final ProductService productService =new ProductService(new RepositoryProduct());
    private final WarehouseService warehouseService = new WarehouseService(new RepositoryWarehouse());
    private final Scanner in = new Scanner(System.in);
    private boolean IsRun= true;

    public void start() {
        System.out.println("===        Starting System of Warehouse       ===");
    }

    public boolean isRun(){
        return IsRun;
    }

    public void run(){
        warehouseService.Restock(productService);
        System.out.println("===                  Operations               ===");
        System.out.println("===      Create entity:1 | Operations : 2     ===");
        String input = in.next();
        switch (input){
            case "1" -> Create();
            case "2" -> Operation();
            default -> {
                IsRun = false;
            }
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

    private void CreateProduct(){
        System.out.print("Name: ");
        String name = in.next();
        System.out.print("Category: ");
        String category = in.next();
        productService.createProduct(name,category);
    }
    private void CreateWarehouse(){
        System.out.print("Name: ");
        String name = in.next();
        warehouseService.createWarehouse(name);
    }

    private void Operation(){
        System.out.println("=== Set Operation: 1   | Get Operation: 2 ===");
        String input =in.next();
        switch (input){
            case "1"-> setOperation();
            case "2"-> getOperation();
            default -> {
                return;
            }
        }
    }

    private void setOperation(){
        System.out.println("=== Delivery Product: 1   | Shipment Product: 2                       ===");
        System.out.println("=== Delivery Strategy: 3  | Move product between warehouses: 4        ===");
        String input =in.next();
        switch (input){
            case "1" -> setDelivery();
            case "2" -> setShipment();
            case "3" -> setStrategy();
            case "4" -> setMovement();
            default -> {
                return;
            }
        }
    }

    private void setDelivery(){
        System.out.println("Product:");
        getALLProduct();
        System.out.print("Id of product to delivery: ");
        int productid = in.nextInt();
        System.out.println("Warehouses:");
        getALLWarehouse();
        System.out.print("Warehouse ID to delivery: ");
        int warehouseid = in.nextInt();
        System.out.print("Count: ");
        int count = in.nextInt();

        warehouseService.processDelivery(warehouseid, productService.getProductById(productid),count );
    }

    private void setShipment(){
        System.out.println("Product:");
        getALLProduct();
        System.out.print("Id of product to delivery: ");
        int productid = in.nextInt();
        System.out.println("Warehouses:");
        getALLWarehouse();
        System.out.print("Warehouse ID to delivery: ");
        int warehouseid = in.nextInt();
        System.out.print("Count: ");
        int count = in.nextInt();

        warehouseService.processShipment(warehouseid, productService.getProductById(productid), count);
    }

    private void setStrategy(){
        System.out.println("Product:");
        getALLProduct();
        System.out.print("Id of product to delivery: ");
        int productid = in.nextInt();
        System.out.println("Warehouses:");
        getALLWarehouse();
        System.out.print("Warehouse ID to delivery: ");
        int warehouseid = in.nextInt();
        System.out.print("Minimal Stock: ");
        int minStock = in.nextInt();
        warehouseService.setProductAndMinStock(warehouseid, productService.getProductById(productid), minStock);
    }

    private void setMovement(){
        System.out.println("Warehouses:");
        getALLWarehouse();
        System.out.print("Warehouse shipment From: ");
        int warehouseFrom= in.nextInt();
        System.out.print("Warehouse delivery to: ");
        int warehouseTo= in.nextInt();
        System.out.println("Product:");
        getALLProduct();
        System.out.print("Id of product to delivery: ");
        int productid = in.nextInt();
        System.out.print("Count: ");
        int count = in.nextInt();
        warehouseService.move(warehouseFrom,warehouseTo,productService.getProductById(productid),count);
    }

    private void getOperation(){
        System.out.println("=== Get Entity: 1   |  Get History: 2 ===");
        System.out.println("===        Warehouse Balance: 3       ===");
        String input = in.next();
        switch (input){
            case "1" -> getEntity();
            case "2"-> getHistory();
            case "3" -> getBalance();
            default -> {
                return;
            }
        }
    }

    private void getEntity() {
        System.out.println("=== Get Product: 1   |  Get Warehouse: 2 ===");
        System.out.println("===        Get Product By Category:3     ===");
        String input =in.next();
        switch (input){
            case "1" -> getALLProduct();
            case "2" -> getALLWarehouse();
            case "3" -> getALLProductByCategory();
            default -> {
                return;
            }
        }

    }
    private void getALLProduct(){
        productService.getAllProducts();
    }
    private void getALLWarehouse(){
        warehouseService.getAllWarehouse();
    }
    private void getALLProductByCategory(){
        System.out.print("Category: ");
        String category = in.next();
        productService.getProductByCategory(category);
    }
    private void getHistory(){
        System.out.println("=== Get Delivery His: 1   |  Get Shipment His: 2 ===");
        String input = in.next();
        switch (input){
            case "1" -> getDeliveryHis();
            case "2"-> getShipmentHis();
            default -> {
                return;
            }
        }
    }

    private void getDeliveryHis(){
        System.out.println("Warehouses:");
        getALLWarehouse();
        System.out.print("Warehouse ID: ");
        int warehouseId = in.nextInt();
        warehouseService.DeliveryHistory(warehouseId);
    }
    private void  getShipmentHis(){
        System.out.println("Warehouses:");
        getALLWarehouse();
        System.out.print("Warehouse ID: ");
        int warehouseId = in.nextInt();
        warehouseService.ShipmentHistory(warehouseId);
    }

    private  void getBalance(){
        System.out.println("Warehouses:");
        getALLWarehouse();
        System.out.print("Warehouse ID: ");
        int warehouseId = in.nextInt();
        warehouseService.printBalances(warehouseId, productService);
    }







}