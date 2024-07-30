package streamAPI.exercise13_optionals.scenario2;

import java.time.LocalDateTime;

public class Ride {
    private String startStation;
    private String endStation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int passengerCount;
    
    public String getEndStation() {
        return endStation;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public String getStartStation() {
        return startStation;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public int getPassengerCount() {
        return passengerCount;
    }
    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

}
