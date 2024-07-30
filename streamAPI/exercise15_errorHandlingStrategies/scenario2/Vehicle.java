package streamAPI.exercise15_errorHandlingStrategies.scenario2;

import java.time.LocalDateTime;

public class Vehicle {
    private String name;
    private double mileage;
    private LocalDateTime lastMaintenanceDate;
    private String status;

    public LocalDateTime getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }
    public double getMileage() {
        return mileage;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public void setLastMaintenanceDate(LocalDateTime lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
