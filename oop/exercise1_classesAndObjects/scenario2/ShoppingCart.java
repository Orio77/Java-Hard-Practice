package oop.exercise1_classesAndObjects.scenario2;

import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<Product> products;
    
    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public void displayProducts() {
        System.out.println(products);
    }
}
