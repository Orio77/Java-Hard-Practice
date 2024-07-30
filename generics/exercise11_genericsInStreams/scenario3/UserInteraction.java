package generics.exercise11_genericsInStreams.scenario3;

import java.time.LocalDateTime;

public class UserInteraction {
    private String userId;
    private LocalDateTime timestamp;
    private String location;
    private String device;

    public UserInteraction(String userId, LocalDateTime timestamp, String location, String device) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.location = location;
        this.device = device;
    }

    public String getDevice() {
        return device;
    }
    public String getLocation() {
        return location;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getUserId() {
        return userId;
    }
    
    
}