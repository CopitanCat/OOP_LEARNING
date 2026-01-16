public class WithChicken extends PizzaDecorator{
    public WithChicken(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+", Chicken";
    }

    @Override
    public double getCost() {
        return super.getCost()+20;
    }
}
