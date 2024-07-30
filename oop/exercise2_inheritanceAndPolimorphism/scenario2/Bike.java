package oop.exercise2_inheritanceAndPolimorphism.scenario2;

public class Bike extends Vehicle{
    private int bikePrice;


    public Bike(String model, int year) {
        super(model, year);
    }

    public Bike(String model, int year, int bikePrice) {
        super(model, year);
        this.bikePrice = bikePrice;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return super.calculateRentalPrice(days) * bikePrice;
    }
}
