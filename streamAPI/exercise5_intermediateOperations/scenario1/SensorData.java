package streamAPI.exercise5_intermediateOperations.scenario1;

import java.time.LocalDateTime;

public class SensorData {
    private String type;
    private double value;
    private LocalDateTime timestamp;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getType() {
        return type;
    }
    public double getValue() {
        return value;
    }
}
