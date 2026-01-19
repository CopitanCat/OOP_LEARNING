package builders;
import director.PizzaType;

public class PizzaRecipeBuilder implements Builder{
    private PizzaType type;
    private String dough;
    private String sauce;
    private String topping;

    @Override
    public void setDough(String dough) {
        this.dough = dough;
    }

    @Override
    public void setType(PizzaType type) {
        this.type = type;
    }

    @Override
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public void setTopping(String topping) {
        this.topping = topping;
    }
    public Recipe getResult(){
        return new Recipe(this.type, this.dough, this.sauce, this.topping);
    }
}
