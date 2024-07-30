package dataStructures.exercise1_basics.scenario2;

import java.util.ArrayList;

public class ProductStore {
    private ArrayList<Product> productStore;

    public ProductStore() {
        this.productStore = new ArrayList<>();
    }
        
    public void addProduct(Product product) {
        productStore.add(product);
    }

    public void removeProduct(Product product) {
        productStore.remove(product);
    }

    public void showProducts() {
        System.out.println(productStore);
    }
}
