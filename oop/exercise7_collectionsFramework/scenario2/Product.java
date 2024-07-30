package oop.exercise7_collectionsFramework.scenario2;

public class Product {
    private String name;
    private int price;
    private int productID;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.productID = name.hashCode();
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getProductID() {
        return productID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
