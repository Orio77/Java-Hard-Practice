package oop.exercise2_inheritanceAndPolimorphism.scenario2;

import java.util.ArrayList;

public class RentalSystem {
    ArrayList<Vehicle> vehicles;

    public RentalSystem() {
        vehicles = new ArrayList<>();
    }


    public double rentVehicle(Vehicle vehicle, int days) {
        return vehicle.calculateRentalPrice(days);
    }
}
