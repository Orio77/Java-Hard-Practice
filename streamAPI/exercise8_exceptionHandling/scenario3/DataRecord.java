package streamAPI.exercise8_exceptionHandling.scenario3;

import java.time.LocalDateTime;

public class DataRecord {
    private LocalDateTime date;
    private String location;
    private int temperature;

    public LocalDateTime getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public int getTemperature() {
        return temperature;
    }
}
