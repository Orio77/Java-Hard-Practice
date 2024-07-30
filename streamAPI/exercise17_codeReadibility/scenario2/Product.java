package streamAPI.exercise17_codeReadibility.scenario2;

public class Product {
    private String name;
    private int leadTime; //days
    private double price;

    

    public Product(String name, int leadTime, double price) {
        this.name = name;
        this.leadTime = leadTime;
        this.price = price;
    }
    public int getLeadTime() {
        return leadTime;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
