package oop.exercise15_designPrinciples.scenario2.base;

import oop.exercise15_designPrinciples.scenario2.Discountable;

public abstract class Product implements Discountable{
    private double price;
    private String details;
    private int availability;

    public int getAvailability() {
        return availability;
    }
    public String getDetails() {
        return details;
    }
    public double getPrice() {
        return price;
    }
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
