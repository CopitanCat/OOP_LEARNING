package domain;

public class Product  extends BaseEntity{
    private String name;
    private String category;
    private int minStock;

    public Product(String name, String category, int minStock){
        this.name = name;
        this.category= category;
        this.minStock = minStock;
    }

    public String getName(){
        return this.name;
    }

    public int getMinStock() {
        return this.minStock;
    }
}