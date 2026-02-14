package domain;

public interface Operation {
    void apply(Product product, int count);
    void getHistory();

}
