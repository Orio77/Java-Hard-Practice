package streamAPI.exercise12_methodReferences.scenario3;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

public class FlightManagementApp {
    
    public List<Flight> filterAvailableFlights(List<Flight> flights) {
        return flights.stream().filter(Flight::isAvailable).sorted(Comparator.comparing(Flight::getPrice).reversed()).toList();
    }

    // AI Helped - I did not know how to sort in groupingBy method
    public Map<String, List<Flight>> groupFlightsByDestination(List<Flight> flights) {
        return flights.stream().collect(Collectors.groupingBy(Flight::getDestination, Collectors.collectingAndThen(Collectors.toList(), (List<Flight> list) -> list.stream().sorted(Comparator.comparing(Flight::getDepartureTime)).collect(Collectors.toList()))));
    }

    public Map<String, List<Flight>> collectFlightsByOrigin(List<Flight> flights) {
        return flights.stream().collect(Collectors.groupingBy(Flight::getOrigin, Collectors.collectingAndThen(Collectors.toList(), (List<Flight> list) -> list.stream().sorted(Comparator.comparing(Flight::getDepartureTime)).collect(Collectors.toList()))));
    }

    public Map<String, Double> calculateAveragePriceByDestination(List<Flight> flights) {
        return flights.stream().collect(Collectors.groupingBy(Flight::getDestination, Collectors.averagingDouble(Flight::getPrice)));
    }

    public Flight findCheapestFlight(List<Flight> flights) {
        return flights.parallelStream().min(Comparator.comparing(Flight::getPrice).reversed()).orElse(null);
    }

    public Flight findFastestFlight(List<Flight> flights, String destination) {
        return flights.parallelStream().filter(flight -> flight.getDestination().matches(destination)).min(Comparator.comparing(Flight::getArrivalTime).reversed()).orElse(null);
    }

    public List<Flight> findFlightsWithinBudget(List<Flight> flights, int budget) {
        return flights.parallelStream().filter(flight -> flight.getPrice() <= budget).sorted(Comparator.comparing(Flight::getPrice).reversed()).toList();
    }

    public List<Flight> findFlightsWithinTimeframe(List<Flight> flights, LocalDateTime startTime, LocalDateTime endTime, String destination) {
        return flights.parallelStream().filter(flight -> flight.getDestination().matches(destination) && flight.getDepartureTime().isAfter(startTime) && flight.getArrivalTime().isBefore(endTime)).sorted(Comparator.comparing(Flight::getDepartureTime)).toList();
    }

    public List<Flight> findDirectFlights(List<Flight> flights, String origin, String destination) {
        return flights.parallelStream().filter(flight -> flight.getOrigin().matches(origin) && flight.getDestination().matches(destination)).sorted(Comparator.comparing(Flight::getDepartureTime).reversed()).toList();
    }
}
