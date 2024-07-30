package streamAPI.exercise13_optionals.scenario3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;



public class VehicleAnalyzer {
    public Optional<Vehicle> findVehicleWithHighestMileage(List<Vehicle> vehicles) {
        return vehicles.stream().max(Comparator.comparing(Vehicle::getMileage));
    }

    public Optional<SensorReading> findMostCommonSensorReading(List<Vehicle> vehicles) {
        return vehicles.stream().flatMap(vehicle -> vehicle.getSensorReadings().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Optional<Double> averageSensorValue(List<Vehicle> vehicles, String sensorType) {
        OptionalDouble result = vehicles.stream().flatMap(vehicle -> vehicle.getSensorReadings().stream()).filter(sensor -> sensor.getSensorType().matches(sensorType)).mapToDouble(SensorReading::getValue).average();

        // My code
        // result.isPresent() ? return Optional.of(result.getAsDouble()) : return Optional.empty();

        // Correct code
        return result.isPresent() ? Optional.of(result.getAsDouble()) : Optional.empty();

    }

    public Optional<SensorReading> findSensorReadingWithHighestFrequency(List<Vehicle> vehicles) {
        return vehicles.stream().flatMap(vehicle -> vehicle.getSensorReadings().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Optional<Map<String, Double>> averageSensorValuesByType(List<Vehicle> vehicles) {
        return Optional.of(vehicles.stream().flatMap(vehicle -> vehicle.getSensorReadings().stream()).collect(Collectors.groupingBy(SensorReading::getSensorType, Collectors.averagingDouble(SensorReading::getValue))));
    }

    public Optional<List<SensorReading>> findTopThreeMostCommonSensorReadings(List<Vehicle> vehicles) {
        return Optional.of(vehicles.stream().flatMap(vehicle -> vehicle.getSensorReadings().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(3).map(Map.Entry::getKey).toList());
    }

    public Optional<Map<String, List<Vehicle>>> groupVehiclesByModel(List<Vehicle> vehicles) {
        return Optional.of(vehicles.stream().collect(Collectors.groupingBy(Vehicle::getModel)));
    }

    public Optional<Map<String, Double>> averageSensorValuesByModel(List<Vehicle> vehicles, String sensorType) {
        return Optional.of(vehicles.stream().collect(Collectors.groupingBy(Vehicle::getModel, Collectors.flatMapping(vehicle -> vehicle.getSensorReadings().stream(), Collectors.toList()))).entrySet().stream().map(es -> {
            Double average = es.getValue().stream().mapToDouble(SensorReading::getValue).average().orElse(0);
            return Map.entry(es.getKey(), average);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public Optional<List<Vehicle>> sortVehiclesByYear(List<Vehicle> vehicles) {
        return Optional.of(vehicles.stream().sorted(Comparator.comparing(Vehicle::getYear).reversed()).toList());
    }
}