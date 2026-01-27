package domain;

public class Product {
    private String name;
    private String category;
    private int article;
    private int minRequiredInventory;

    public Product(String name, String category, int article, int minRequiredInventory){
        this.name = name;
        this.category= category;
        this.article = article;
        this.minRequiredInventory = minRequiredInventory;
    }

    public String getName(){
        return this.name;
    }
}
