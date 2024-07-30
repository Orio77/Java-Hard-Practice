package oop.exercise2_inheritanceAndPolimorphism.scenario3;

public class VehicleManager {
    
    public void testVehicle(Vehicle vehicle) {
        vehicle.startEngine();
        vehicle.accelerate();
        vehicle.brake();
        vehicle.stopEngine();
    }
}
