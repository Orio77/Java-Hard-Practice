package streamAPI.exercise7_parallelStreams.scenario3;

import java.time.LocalDateTime;
import java.util.List;

public class Shipment {
    private String id;
    private GPSLocation location;
    private ShipmentStatus status;
    private LocalDateTime deliveryTime;
    private List<GPSLocation> route;

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }
    public String getId() {
        return id;
    }
    public GPSLocation getLocation() {
        return location;
    }
    public ShipmentStatus getStatus() {
        return status;
    }
    public List<GPSLocation> getRoute() {
        return route;
    }
}
