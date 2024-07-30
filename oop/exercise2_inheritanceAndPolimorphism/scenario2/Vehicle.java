package oop.exercise2_inheritanceAndPolimorphism.scenario2;

public class Vehicle {
    private String model;
    private int ID;
    private int year;
    private final double fee = 0.10;

    public Vehicle(String model, int year) {
        this.model = model;
        ID = model.hashCode();
        this.year = year;
    }

    public double calculateRentalPrice(int days) {
        return days * fee;
    }

    public double getFee() {
        return fee;
    }
    public int getID() {
        return ID;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
}
