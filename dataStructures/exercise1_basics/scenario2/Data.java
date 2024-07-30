package dataStructures.exercise1_basics.scenario2;

import java.util.HashMap;

public class Data {
    private static Data instance = null;
    private HashMap<ProductID, Product> products;
    private HashMap<OrderID, Order> orders;

    private Data() {
        products = new HashMap<>();
        orders = new HashMap<>();
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public HashMap<ProductID, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<ProductID, Product> products) {
        this.products = products;
    }

    public HashMap<OrderID, Order> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<OrderID, Order> orders) {
        this.orders = orders;
    }
}
