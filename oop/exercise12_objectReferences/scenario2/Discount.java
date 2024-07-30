package oop.exercise12_objectReferences.scenario2;

public class Discount {
    private Product product;
    private double percentage;

    public void apply(Product product) {
        product.setPrice(product.getPrice() * (1 - percentage));
    }
    public Product getProduct() {
        return product;
    }
}
