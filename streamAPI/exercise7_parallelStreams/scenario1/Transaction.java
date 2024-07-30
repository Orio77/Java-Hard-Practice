package streamAPI.exercise7_parallelStreams.scenario1;

/**
 * Transaction
 */
public class Transaction {
    private Product product;
    private String productName;
    private double quantity;
    private double pricePerUnit;
    private String salesPerson;

    public Transaction(Product product, int quantity, double pricePerUnit, String salesPerson) {
        this.product = product;
        this.productName = product.getName();
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.salesPerson = salesPerson;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
    public String getProductName() {
        return productName;
    }
    public double getQuantity() {
        return quantity;
    }
    public String getSalesPerson() {
        return salesPerson;
    }
    public Product getProduct() {
        return product;
    }
    
}