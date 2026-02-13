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
        warehouseService.createWarehouse("MCS-2502");
        warehouseService.createWarehouse("Epshtein Island");
        productService.createProduct("baby oil", "oils for skin");
        productService.createProduct("Islam", "human");
        productService.createProduct("Madiar", "human");
        productService.createProduct("Toys", "toy");
        productService.createProduct("Epshtein", "client");
        productService.createProduct("Aslyzhan", "seller");
        warehouseService.processDelivery(1, productService.getProductById(2), 1);
        warehouseService.processDelivery(1, productService.getProductById(3), 1);
        warehouseService.processDelivery(1, productService.getProductById(5), 1);
        warehouseService.processDelivery(1, productService.getProductById(6), 1);
        warehouseService.processDelivery(2, productService.getProductById(1), 100);
        warehouseService.processDelivery(2, productService.getProductById(4), 10);
        warehouseService.move(1,2,productService.getProductById(2), 1);
        warehouseService.move(1,2,productService.getProductById(3), 1);
        warehouseService.move(1,2,productService.getProductById(5), 1);
        warehouseService.move(1,2,productService.getProductById(6), 1);
        warehouseService.move(2,1,productService.getProductById(6), 1);
    }

    public boolean isRun(){
        return IsRun;
    }
    private void End(){
        System.out.println("===          Do you want to exit              ===");
        System.out.println("===       Default-> No  |  Yes                   ===");
        System.out.print("Your answer: ");

        String input = in.nextLine();
        input = input.toLowerCase();
        if (input.equals("yes")) {
            IsRun = false;
        } else {
            run();
        }
    }

    public void run(){
        warehouseService.Restock(productService);
        System.out.println("===                  Operations              ===");
        System.out.println("=== Create/Deleate entity:1 | Operations : 2 ===");
        System.out.println("===       Press anything to exit             ===");
        SwitchCase();
    }

    private void SwitchCase(){
        String input = in.nextLine().toLowerCase();
        switch (input){
            case "1" -> Create_Delete();
            case "2" -> Operation();
            case "" -> SwitchCase();
            default -> End();
        }
    }

    private void Create_Delete() {
        System.out.println("=== Create Product: 1   | Create Warehouse: 2 ===");
        System.out.println("=== Delete Product: 3   | Delete Warehouse: 4 ===");
        String input = in.nextLine();
        switch (input) {
            case "1" -> CreateProduct();
            case "2" -> CreateWarehouse();
            case "3" -> DeleteProduct();
            case "4" -> DeleteWarehouse();
        }
    }

    private void DeleteProduct() {
        try {
            getALLProduct();
            System.out.print("Id of product to delivery: ");
            int productid = in.nextInt();

            productService.DeleteProduct(productid);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void DeleteWarehouse() {
        try {
            System.out.println("Warehouses:");
            getALLWarehouse();
            System.out.print("Warehouse ID to delivery: ");
            int warehouseid = in.nextInt();

            warehouseService.DeleteWarehouse(warehouseid);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void CreateProduct(){
        try {
            System.out.print("Name: ");
            String name = in.nextLine().toLowerCase();
            System.out.print("Category: ");
            String category = in.nextLine().toLowerCase();
            productService.createProduct(name, category);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void CreateWarehouse(){
        try {
            System.out.print("Name: ");
            String name = in.nextLine().toLowerCase();
            warehouseService.createWarehouse(name);
        }
        catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void Operation(){
        System.out.println("=== Set Operation: 1   | Get Operation: 2 ===");
        String input =in.nextLine();
        switch (input){
            case "1"-> setOperation();
            case "2"-> getOperation();

        }
    }

    private void setOperation(){
        System.out.println("=== Delivery Product: 1   | Shipment Product: 2                       ===");
        System.out.println("=== Delivery Strategy: 3  | Move product between warehouses: 4        ===");
        String input =in.nextLine();
        switch (input){
            case "1" -> setDelivery();
            case "2" -> setShipment();
            case "3" -> setStrategy();
            case "4" -> setMovement();

        }
    }

    private void setDelivery(){
        try {

            getALLProduct();
            System.out.print("Id of product to delivery: ");
            int productid = in.nextInt();
            System.out.println("Warehouses:");
            getALLWarehouse();
            System.out.print("Warehouse ID to delivery: ");
            int warehouseid = in.nextInt();
            System.out.print("Count: ");
            int count = in.nextInt();

            warehouseService.processDelivery(warehouseid, productService.getProductById(productid), count);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void setShipment(){
        try{

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
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void setStrategy() {
        try {

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
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());

        }
    }

    private void setMovement(){
        try{
        System.out.println("Warehouses:");
        getALLWarehouse();
        System.out.print("Warehouse shipment From: ");
        int warehouseFrom= in.nextInt();
        System.out.print("Warehouse delivery to: ");
        int warehouseTo= in.nextInt();

        getALLProduct();
        System.out.print("Id of product to delivery: ");
        int productid = in.nextInt();
        System.out.print("Count: ");
        int count = in.nextInt();
        warehouseService.move(warehouseFrom,warehouseTo,productService.getProductById(productid),count);
    }
        catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
}
    private void getOperation(){
        System.out.println("=== Get Entity: 1   |  Get History: 2 ===");
        System.out.println("===        Warehouse Balance: 3       ===");
        String input = in.nextLine();
        switch (input){
            case "1" -> getEntity();
            case "2"-> getHistory();
            case "3" -> getBalance();

        }
    }

    private void getEntity() {
        System.out.println("=== Get Product: 1   |  Get Warehouse: 2 ===");
        System.out.println("===        Get Product By Category:3     ===");
        String input =in.nextLine();
        switch (input){
            case "1" -> getALLProduct();
            case "2" -> getALLWarehouse();
            case "3" -> getALLProductByCategory();

        }

    }
    private void getALLProduct(){
        System.out.println("Product:");
        productService.getAllProducts();
    }
    private void getALLWarehouse(){
        warehouseService.getAllWarehouse();
    }
    private void

    getALLProductByCategory(){
        try{
        System.out.print("Category: ");
        String category = in.nextLine();
        productService.getProductByCategory(category);} catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    private void getHistory(){
        try {
            System.out.println("=== Get Delivery His: 1   |  Get Shipment His: 2 ===");
            String input = in.nextLine();
            switch (input){
                case "1" -> getDeliveryHis();
                case "2"-> getShipmentHis();

         }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void getDeliveryHis() {
        try {
            System.out.println("Warehouses:");
            getALLWarehouse();
            System.out.print("Warehouse ID: ");
            int warehouseId = in.nextInt();
            warehouseService.DeliveryHistory(warehouseId);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());

        }
    }
    private void  getShipmentHis() {
        try {
            System.out.println("Warehouses:");
            getALLWarehouse();
            System.out.print("Warehouse ID: ");
            int warehouseId = in.nextInt();
            warehouseService.ShipmentHistory(warehouseId);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());

        }
    }

    private  void getBalance() {
        try {
            System.out.println("Warehouses:");
            getALLWarehouse();
            System.out.print("Warehouse ID: ");
            int warehouseId = in.nextInt();
            warehouseService.printBalances(warehouseId, productService);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());

        }
    }







}