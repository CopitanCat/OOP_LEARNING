public class Car_t16 {
    private String model;
    private int year;
    private String color;

    public void initialize(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public static void main(){
        Car_t16 car = new Car_t16();
        car.initialize("bmw", 2020, "black");
        System.out.println(car.model +" " +car.year +" "+ car.color);
    }
}
