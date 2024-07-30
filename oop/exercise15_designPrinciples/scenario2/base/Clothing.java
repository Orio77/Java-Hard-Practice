package oop.exercise15_designPrinciples.scenario2.base;

import java.util.ArrayList;

public class Clothing extends Product{
    private int size;
    private String colour;
    private String material;
    private ArrayList<Double> discounts;

    public Clothing(int size, String colour, String material) {
        this.size = size;
        this.colour = colour;
        this.material = material;
        discounts = new ArrayList<>();
    }

    @Override
    public String getDetails() {
        return "Size: " + size + "\nColour: " + colour + "\nMaterial: " + material;
    }

    @Override
    public double getPrice() {
        double price = getPrice();

        for (Double discount : discounts) {
            price = price * (1 - discount);
        }

        return price;
    }
    
    @Override
    public void applyDiscount(double discount) {
        setPrice(getPrice() * (1 - discount));
    }
    public String getColour() {
        return colour;
    }
    public String getMaterial() {
        return material;
    }
    public int getSize() {
        return size;
    }
}
