package oop.exercise2_inheritanceAndPolimorphism.scenario2;

public class Truck extends Vehicle{
    private int truckPrice;
    private final double truckTax = 0.30;


    public Truck(String model, int year) {
        super(model, year);
    }

    public Truck(String model, int year, int truckPrice) {
        super(model, year);
        this.truckPrice = truckPrice;
    }


    @Override
    public double calculateRentalPrice(int days) {
        return super.calculateRentalPrice(days) * truckPrice * truckTax;
    }
}
