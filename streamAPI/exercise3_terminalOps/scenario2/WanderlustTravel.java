package streamAPI.exercise3_terminalOps.scenario2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WanderlustTravel {
    private List<Destination> destinations;

    
    public List<Destination> getPopularDestinationsNearby() {
        return destinations.stream().filter(dest -> dest.getDistanceFromAgency() <= 1000).sorted(Comparator.comparing(Destination::getPopularityScore).thenComparing(Destination::getDistanceFromAgency)).toList();
    }

    public Map<Double, List<Destination>> groupByPopularity() {
        return destinations.stream().collect(Collectors.groupingBy(Destination::getPopularityScore));
    }

    public Map<Double, Double> getAverageDistancePerPopularity() {
        return destinations.stream().collect(Collectors.groupingBy(Destination::getPopularityScore, Collectors.averagingDouble(Destination::getDistanceFromAgency)));
    }

    public Map<Double, List<Destination>> getItineraries() {
        Map<Double, List<Destination>> map = destinations.stream().filter(des -> des != null && des.getDistanceFromAgency() != 0 && des.getName() != null && !des.getName().isBlank() && des.getPopularityScore() != 0.0)
        .collect(Collectors.groupingBy(Destination::getPopularityScore));
        
        map.values().stream().forEach(des -> des.sort(Comparator.comparing(Destination::getDistanceFromAgency)));

        // AI Copied and Studied
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> {
            double totalDistance[] = {0.0}; // mutual double
            return entry.getValue().stream().filter(destination -> {
                double temp = totalDistance[0] + destination.getDistanceFromAgency(); // Adds distances of two destinations
                if (temp <= 1000) {
                    totalDistance[0] = temp;
                    return true; // Adds the destination to the Itinerary
                }
                return false; // doesn't make it an itinerary, because the limit would be exceeded
            }).collect(Collectors.toList());
        }));

    }
}
