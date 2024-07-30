package oop.exercise2_inheritanceAndPolimorphism.scenario3;

public class Car extends Vehicle implements FuelConsumption{
    private String name;
    private int speed;

    public Car(String name) {
        this.name = name;
        speed = 0;
    }

    @Override
    void startEngine() {
        System.out.println(name + "'s engine roaring");
    }

    @Override
    void accelerate() {
        speed += 10;
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
        return distance / 25;
    }

    @Override
    void honk() {
        System.out.println("Car honking");
    }

    @Override
    void turnOfLights() {
        System.out.println("Cars lights turned off");
    }

    @Override
    void turnOnLights() {
        System.out.println("Cars lights turned on");
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
