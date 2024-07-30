package oop.exercise18_refactoring.scenario3;

import java.util.*;

class Product {
    private final String productId;
    private double price;
    private int stock;

    public Product(String productId, double price) {
        this.productId = productId;
        this.price = price;
        this.stock = 0;
    }

    public double getPrice() {
        return price;
    }
    public String getProductId() {
        return productId;
    }
    public int getStock() {
        return stock;
    }
    public void setPrice(double price) {
        if (price <= 0)
            return;
        
        this.price = price;
    }
    public void delivery(int number) {
        if (number < 0)
            return;
        
        this.stock += number;
    }
}

class Order {
    private final String orderId;
    private Map<Product, Integer> orderedProducts;
    private boolean isProcessed;

    public Order(String orderId, Map<Product,Integer> orderedProducts) {
        this.orderId = orderId;
        this.orderedProducts = orderedProducts;
        isProcessed = false;
    }

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0)
            return;
        
        orderedProducts.put(product, quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : orderedProducts.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void processOrder() { isProcessed = true; }

    public String getOrderId() {
        return orderId;
    }
    public Map<Product, Integer> getOrderedProducts() {
        return Collections.unmodifiableMap(this.orderedProducts);
    }

    public boolean isProcessed() {
        return isProcessed;
    }
}

class ECommercePlatform {
    private Map<String, Product> products;
    private List<Order> orders;

    public ECommercePlatform() {
        products = new HashMap<>();
        orders = new ArrayList<>();
    }

    public void addProduct(Product product) { 
        if (product == null)
            return;
        
        products.put(product.getProductId(), product); 
    }
    public Product getProduct(String productId) { 
        if (productId == null || productId.matches(""))
            return null;
        
        return products.get(productId); 
    }
    public boolean placeOrder(Order order) { 
        if (order == null)
            return false;
        
        return orders.add(order); 
    }
    public void processOrder(String orderId) {
        if (orderId == null || orderId.matches(""))
            return;

        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                order.processOrder();
            }
        }
    }
}

public class EcommerceSystem {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();
        Product phone = new Product("phone-01", 299.99);
        phone.delivery(50);
        platform.addProduct(phone);

        Order order = new Order("order-123", new HashMap<>());
        order.addProduct(platform.getProduct("phone-01"), 1);
        platform.placeOrder(order);
        platform.processOrder("order-123");
        System.out.println("Order Processed: " + order.isProcessed());
    }
}
