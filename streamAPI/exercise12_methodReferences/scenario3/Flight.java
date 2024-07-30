package streamAPI.exercise12_methodReferences.scenario3;

import java.time.LocalDateTime;

public class Flight {
    private String flightNumber;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String origin;
    private String destination;
    private double price;
    private boolean isAvailable; 

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
    public String getDestination() {
        return destination;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public String getOrigin() {
        return origin;
    }
    public double getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
}
