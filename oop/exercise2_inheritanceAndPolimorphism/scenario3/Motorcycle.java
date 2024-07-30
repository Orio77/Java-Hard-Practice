package oop.exercise2_inheritanceAndPolimorphism.scenario3;

public class Motorcycle extends Vehicle implements FuelConsumption{
    private String name;
    private int speed;

    public Motorcycle(String name) {
        this.name = name;
        speed = 0;
    }

    @Override
    void startEngine() {
        System.out.println(name + "'s engine roaring");
    }

    @Override
    void accelerate() {
        speed += 30;
    }

    @Override
    void brake() {
        speed = 0;
    }

    @Override
    void stopEngine() {
        System.out.println(name + "'s engine has stopped");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance/10;
    }

    @Override
    void honk() {
        System.out.println("Motorcycles honking");
    }

    @Override
    void turnOfLights() {
        System.out.println("Motorcycles lights turned off");
    }

    @Override
    void turnOnLights() {
        System.out.println("Motorcycles lights turned on");
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
