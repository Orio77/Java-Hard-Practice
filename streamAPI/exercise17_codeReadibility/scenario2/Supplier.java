package streamAPI.exercise17_codeReadibility.scenario2;

import java.util.List;

public class Supplier {
    private String name;
    private List<Product> products;
    private double rating;
    private int leadTime; // days

    public double getRating() {
        return rating;
    }
    public String getName() {
        return name;
    }
    public List<Product> getProducts() {
        return products;
    }
    public int getLeadTime() {
        return leadTime;
    }
}
