package oop.exercise12_objectReferences.scenario2;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public boolean addItem(Product product) {
        return items.add(product);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(i -> i.getPrice()).sum();
    }
    public ArrayList<Product> getItems() {
        return items;
    }
}
