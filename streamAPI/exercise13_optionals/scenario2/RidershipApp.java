package streamAPI.exercise13_optionals.scenario2;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class RidershipApp {
    
    public Optional<Ride> findLongestRide(List<Ride> rides) {
        return rides.stream().max(Comparator
        .comparing(
            ((Ride ride) -> Duration.between(ride.getStartTime(), ride.getEndTime()).toMinutes())
            ));
    }

    public Optional<String> findMostPopularEndStation(List<Ride> rides) {
        return rides.stream().collect(Collectors.groupingBy(Ride::getEndStation, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Optional<Map<String, Long>> countRidesPerStation(List<Ride> rides) {

        Map<String, Long> result = rides.stream().collect(Collectors.groupingBy(Ride::getStartStation, Collectors.counting())).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return Optional.of(result);
    }

    public Optional<Double> averageRideDuration(List<Ride> rides) {

        OptionalDouble average =  rides.stream().mapToDouble((Ride ride) -> Duration.between(ride.getStartTime(), ride.getEndTime()).toMinutes()).average();

        // AI Copied - I didn't understand the difference between OptionalDouble and Optional<Double>
        return average.isPresent() ? Optional.of(average.getAsDouble()) : Optional.empty();
    }

    public Optional<Ride> findBusiestRide(List<Ride> rides) {
        return rides.stream().filter(ride -> ride.getEndTime() != null).max(Comparator.comparing(Ride::getPassengerCount));
    }

    public Optional<String> findLeastPopularStartStation(List<Ride> rides) {
        return rides.stream().collect(Collectors.groupingBy(Ride::getStartStation, Collectors.counting())).entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Optional<List<Ride>> findRidesWithMoreThanAveragePassengers(List<Ride> rides) {
        Optional<Double> average = averageRideDuration(rides);

        if (average.isPresent()) {
            return Optional.of(rides.stream().filter(ride -> ride.getPassengerCount() > average.get()).toList());
        }
        return Optional.empty();
        
    }

    public Optional<Set<String>> findStationsWithOnlyOneRide(List<Ride> rides) {

        Set<String> result = rides.stream().collect(Collectors.groupingBy(Ride::getStartStation, Collectors.counting())).entrySet().stream().filter(es -> es.getValue() != 1).map(Map.Entry::getKey).collect(Collectors.toSet());

        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }

    public Optional<Map<String, List<Ride>>> groupRidesByStartStation(List<Ride> rides) {

        Map<String, List<Ride>> result = rides.stream().collect(Collectors.groupingBy(Ride::getStartStation));

        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }
}
