package streamAPI.exercise8_exceptionHandling.scenario1;

import streamAPI.exercise7_parallelStreams.scenario1.Product;

public class Sale {
    private String salesPersonName;
    private Product product;
    private int quantity;
    private double pricePerUnit;

    public Sale(String salesPersonName, Product product, int quantity, double pricePerUnit) {
        this.salesPersonName = salesPersonName;
        this.product = product;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getSalesPersonName() {
        return salesPersonName;
    }
}
