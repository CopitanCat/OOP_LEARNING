package director;

import builders.Builder;

public class Director {
    public void makeHawaiianPizza(Builder builder){
        builder.setDough("обычное");
        builder.setSauce("мягкий");
        builder.setType(PizzaType.HAWAIIAN);
        builder.setTopping("ветчина + ананас");
    }
    public void makeSpicyPizza(Builder builder){
        builder.setDough("запеченное");
        builder.setSauce("острый");
        builder.setType(PizzaType.SPICY);
        builder.setTopping("пепперони + салями");
    }
}
