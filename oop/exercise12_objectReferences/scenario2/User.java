package oop.exercise12_objectReferences.scenario2;

public class User {
    private String name;
    private ShoppingCart cart;

    public User(String name) {
        this.name = name;
        cart = new ShoppingCart();
    }

    public boolean addToCart(Product product) {
        return cart.addItem(product);
    }

    public double checkout() {
        return cart.getTotalPrice();
    }
    
    public String getName() {
        return name;
    }

    public void applyDiscount(Discount discount) {
        for (Product product : cart.getItems()) {
            discount.apply(product);
        }
    }
}
