package dataStructures.exercise1_basics.scenario2;

public class Product {
    private String name;
    private double price;
    private int productID;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.productID = hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getproductID() {
        return productID;
    }

    public void setproductID(int productID) {
        this.productID = productID;
    }
}
