package domain;

public abstract class Operation {
    public abstract void apply(Product product, int count);
    public abstract void getHistory();

}
