public class WithSausage extends PizzaDecorator {
    public WithSausage(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+", sausage";
    }

    @Override
    public double getCost() {
        return super.getCost()+25;
    }
}
