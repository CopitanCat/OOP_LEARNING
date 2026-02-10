package domain;

public class Product  extends BaseEntity{
    private String name;
    private String category;


    public Product(String name, String category){
        this.name = name;
        this.category= category;
    }

    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.category;
    }


}