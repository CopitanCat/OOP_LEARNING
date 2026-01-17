package task2;

public class WithArugula extends PizzaDecorator {
    public WithArugula(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+", arugula";
    }

    @Override
    public double getCost() {
        return super.getCost()+15;
    }
}
