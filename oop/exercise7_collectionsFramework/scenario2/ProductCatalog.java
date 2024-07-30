package oop.exercise7_collectionsFramework.scenario2;

import java.util.HashMap;

public class ProductCatalog {
    private HashMap<Integer, Product> products;
    
    public ProductCatalog() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductID(), product);
    }
    public void removeProduct(int productID) {
        products.remove(productID);
    }

    public void update(Product product, int price) {
        products.get(product.getProductID()).setPrice(price);
    }

    public Product findProduct(String name) {
        return products.get(name.hashCode());
    }

    public void listAllProducts() {
        for (Integer integer : products.keySet()) {
            System.out.println(products.get(integer));
        }
    }
}
