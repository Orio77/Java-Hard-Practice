package oop.exercise2_inheritanceAndPolimorphism.scenario2;

public class Car extends Vehicle{
    private final double luxuryTax = 0.14;
    private int carPrice;

    public Car(String model, int year) {
        super(model, year);
    }

    public Car(String model, int year, int carPrice) {
        super(model, year);
        this.carPrice = carPrice;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return super.calculateRentalPrice(days) * carPrice * luxuryTax;
    }
    
}
