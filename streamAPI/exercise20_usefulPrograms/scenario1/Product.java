package streamAPI.exercise20_usefulPrograms.scenario1;

/**
 * Product
 */
public class Product {
    private String name;
    private int salesCount;
    private double price;
    private String category;

    public Product(String name, int salesCount, double price, String category) {
        this.name = name;
        this.salesCount = salesCount;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }
    public int getSalesCount() {
        return salesCount;
    }
    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
}