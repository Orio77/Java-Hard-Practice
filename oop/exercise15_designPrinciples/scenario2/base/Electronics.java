package oop.exercise15_designPrinciples.scenario2.base;

import java.util.ArrayList;

public class Electronics extends Product{
    private ArrayList<Double> taxes;
    private String brand;
    private String model;
    private String specifications;
    private boolean isNew;

    public Electronics(String brand, String model, String specifications, boolean isNew) {
        this.brand = brand;
        this.model = model;
        this.specifications = specifications;
        this.isNew = isNew;
        taxes = new ArrayList<>();
    }

    @Override
    public double getPrice() {
        double price = getPrice();

        for (Double tax : taxes) {
            price = price * (1 - tax);
        }

        return price;
    }

    @Override
    public String getDetails() {
        return "Brand: " + brand + "\nModel: " + model + "\nSpecifications: " + specifications;
    }

    @Override
    public void applyDiscount(double discount) {
        if (!isNew)
            setPrice(getPrice() * (1 - discount));
    }

    public boolean isNew() {
        return isNew;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getSpecifications() {
        return specifications;
    }
}
