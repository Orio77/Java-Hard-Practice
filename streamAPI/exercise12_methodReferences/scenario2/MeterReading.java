package streamAPI.exercise12_methodReferences.scenario2;

import java.time.LocalDateTime;

public class MeterReading {
    private String meterId;
    private LocalDateTime timestamp;
    private double reading;

    public String getMeterId() {
        return meterId;
    }
    public double getReading() {
        return reading;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
