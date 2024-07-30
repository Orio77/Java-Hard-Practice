package oop.exercise1_classesAndObjects.scenario2;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private ArrayList<Product> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public void displayProducts() {
        System.out.println(products);
    }
}
