package domain;

public abstract class Operation {
    public abstract void getHistory();

    protected void apply(Warehouse warehouse ,Product product, int count){
        warehouse.change(product, count);
    }

}
