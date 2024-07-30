package streamAPI.exercise7_parallelStreams.scenario3;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeliveryApp {
    

    public List<String> findDelayedShipments(List<Shipment> shipments) {
        return shipments.stream().filter(shipment -> shipment.getDeliveryTime().isAfter(LocalDateTime.now()) && !shipment.getStatus().equals(ShipmentStatus.DELIVERED)).map(Shipment::getId).toList();
    }

    public double calculateAverageDeliveryTime(List<Shipment> shipments) {
        return shipments.parallelStream().filter(shipment -> shipment.getStatus().equals(ShipmentStatus.DELIVERED)).mapToInt(shipment -> shipment.getDeliveryTime().getHour()).average().orElse(0);
    }

    public GPSLocation findMostVisitedLocation(List<Shipment> shipments) {
        return shipments.parallelStream().flatMap(shipment -> shipment.getRoute().parallelStream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public Map<ShipmentStatus, List<String>> groupShipmentsByStatus(List<Shipment> shipments) {
        return shipments.parallelStream().collect(Collectors.groupingBy(Shipment::getStatus)).entrySet().stream().map(es -> {
            List<String> ids = es.getValue().stream().map(Shipment::getId).toList();
            Map.Entry<ShipmentStatus, List<String>> map = Map.entry(es.getKey(), ids);
            return map;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public String findNearestShipment(List<Shipment> shipments, GPSLocation location) {
        return shipments.parallelStream().min(Comparator.comparing(shipment -> {
            double dx = shipment.getLocation().getX() - location.getX();
            double dy = shipment.getLocation().getY() - location.getY();
            return Math.sqrt(dx * dx + dy * dy);
        })).map(Shipment::getId).orElse(null);
    }

    public List<String> sortShipmentsByDistance(List<Shipment> shipments, GPSLocation location) {
        return shipments.parallelStream().sorted(Comparator.comparing(shipment -> {
            double dx = shipment.getLocation().getX() - location.getX();
            double dy = shipment.getLocation().getY() - location.getY();
            return Math.sqrt(dx * dx + dy * dy);
        })).map(Shipment::getId).toList();
    }

    public List<String> validateShipments(List<Shipment> shipments) {
        return shipments.parallelStream().filter(shipment -> shipment.getLocation() == null || shipment.getStatus() == null).map(Shipment::getId).toList();
    }

    public List<Shipment> handleInvalidShipments(List<Shipment> shipments) {
        return shipments.parallelStream().filter(Objects::nonNull).filter(shipment -> shipment.getDeliveryTime() != null && shipment.getId() != null && shipment.getLocation() != null && shipment.getRoute() != null && shipment.getStatus() != null).toList();
    }

    public Shipment findShipmentById(List<Shipment> shipments, String id) throws NoShipmentFoundException {
        

        Optional<Shipment> result = shipments.parallelStream().filter(shipment -> shipment.getId().matches(id)).findFirst();

        if (result.isPresent()) {
            return result.get();
        }
        else {
            throw new NoShipmentFoundException();
        }
    }
}
