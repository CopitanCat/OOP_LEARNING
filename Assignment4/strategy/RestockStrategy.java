package strategy;

import domain.Product;

public interface RestockStrategy {
    boolean isRestockNeeded(Product product, int currentQuantity);
}