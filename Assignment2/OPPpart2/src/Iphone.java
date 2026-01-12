public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
    this.model = model;
    this.color = color;
    this.price = price;
}

    public boolean equals(Iphone iphone)
    {
    if(this.model != iphone.model){
      return false;
    }
    if(this.color != iphone.color){
      return false;
    }
    if(this.price != iphone.price){
      return false;
    }
    return true;

    }

    public static void main(String[] args) {
    Iphone iphone1 = new Iphone("X", "Black", 999);
    Iphone iphone2 = new Iphone("X", "Black", 999);
    System.out.println(iphone1.equals(iphone2));
    }
}
