package streamAPI.exercise7_parallelStreams.scenario1;

public class Product {
    private String name;
    private double price;
    private String manufacturer;
    private String category;

    public Product(String name, double price, String manufacturer, String category) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }

}
