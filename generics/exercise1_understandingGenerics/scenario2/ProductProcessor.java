package generics.exercise1_understandingGenerics.scenario2;

public class ProductProcessor<T extends Product> {
    private ShoppingCart<T> cart;

    public ProductProcessor() {
        cart = new ShoppingCart<>();
    }

    public double calculateTotal() {
        double sum = 0;
        for (Product product : cart.getProducts()) {
            sum += product.getPrice();
        }
        return sum;
    }
}
