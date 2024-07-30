package streamAPI.exercise15_errorHandlingStrategies.scenario2;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class VehicleManagementApp {
    
    public List<String> getVehiclesForMaintenance(List<Vehicle> vehicles) {

        return vehicles.stream().filter(vehicle -> vehicle.getStatus().matches("maintenance required")).sorted(Comparator.comparing(Vehicle::getMileage).thenComparing(Vehicle::getName)).map(Vehicle::getName).toList();
    }

    public Vehicle getOldestVehicleForMaintenance(List<Vehicle> vehicles) {
        return vehicles.stream().filter(vehicle -> vehicle.getStatus().matches("maintenance required")).max(Comparator.comparing(Vehicle::getLastMaintenanceDate)).orElse(null);
    }

    public String getVehicleStatus(List<Vehicle> vehicles, String vehicleName) throws VehicleNotFoundException {
        List<Vehicle> result = vehicles.stream().filter(v -> v.getName().matches(vehicleName)).toList();

        if (result.isEmpty()) {
            throw new VehicleNotFoundException();
        }
        else {
            return result.stream().map(Vehicle::getStatus).findAny().orElse(null);
        }
    }

    public double getAverageMileage(List<Vehicle> vehicles) {
        
        return vehicles.stream().mapToDouble(Vehicle::getMileage).average().orElse(0.0);
    }

    public Map<String, LocalDateTime> getVehicleMaintenanceDates(List<Vehicle> vehicles) {
        
        return vehicles.stream().collect(Collectors.toMap(Vehicle::getName, Vehicle::getLastMaintenanceDate));
    }

    public Map<String, Double> getVehicleMileage(List<Vehicle> vehicles) {
        return vehicles.stream().collect(Collectors.toMap(Vehicle::getName, Vehicle::getMileage));
    }

    public Optional<String> getVehicleByName(List<Vehicle> vehicles, String vehicleName) {
        return vehicles.stream().filter(v -> v.getName().matches(vehicleName)).map(Vehicle::getName).findAny();
    }

    public Optional<Vehicle> getVehicleWithHighestMileage(List<Vehicle> vehicles) {
        return vehicles.stream().max(Comparator.comparing(Vehicle::getMileage));
    }

    public Optional<Vehicle> getVehicleWithLowestMileage(List<Vehicle> vehicles) {
        return vehicles.stream().min(Comparator.comparing(Vehicle::getMileage));
    }

}
