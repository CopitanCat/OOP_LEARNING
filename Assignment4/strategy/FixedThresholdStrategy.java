package strategy;
import domain.Product;

// Стратегия: Пополнять, если меньше фиксированного порога
public class FixedThresholdStrategy implements RestockStrategy {
    @Override
    public boolean isRestockNeeded(Product product, int currentQuantity) {
        return currentQuantity < product.getMinStock();
    }
}