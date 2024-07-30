package streamAPI.exercise10_streamAPIwithDataStructures.scenario1;

public class Product {
    private String name;
    private int id;
    private String category;
    private int currentInventoryCount;
    private int unitsSoldLastMonth;
    private double supplierDistance;

    public Product(String name, int id, String category, int currentInventoryCount) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.currentInventoryCount = currentInventoryCount;
    }

    public String getCategory() {
        return category;
    }
    public int getCurrentInventoryCount() {
        return currentInventoryCount;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getUnitsSoldLastMonth() {
        return unitsSoldLastMonth;
    }
    public double getSupplierDistance() {
        return supplierDistance;
    }
}
