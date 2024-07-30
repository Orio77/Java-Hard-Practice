package streamAPI.exercise13_optionals.scenario3;

import java.util.List;

public class Vehicle {
    private String model;
    private int year;
    private int mileage;
    private List<SensorReading> sensorReadings;

    public int getMileage() {
        return mileage;
    }
    public String getModel() {
        return model;
    }
    public List<SensorReading> getSensorReadings() {
        return sensorReadings;
    }
    public int getYear() {
        return year;
    }
}
