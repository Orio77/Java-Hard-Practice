package streamAPI.exercise8_exceptionHandling.scenario2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingApp {
    
    public List<Destination> filterDestinationByDistanceAndPopularity(List<Destination> destinations, int maxDistance, int minPopularity) {
        return destinations.stream().filter(dest -> dest.getDistance() < maxDistance && dest.getPopularity() > minPopularity).toList();
    }

    public Map<String, Double> calculateAverageReviewRating(List<Destination> destinations) {
        return destinations.stream().collect(Collectors.groupingBy(Destination::getName, Collectors.averagingDouble(dest -> dest.getReviews().stream().mapToDouble(rev -> rev.getRating()).average().orElse(0.0)))).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public List<Destination> findTopDestinationsByReviewScore(List<Destination> destinations, int topN) {
        return destinations.stream().sorted(Comparator.comparing((Destination dest) -> dest.getReviews().stream().mapToDouble(Review::getRating).average().orElse(0.0)).thenComparing(Destination::getPopularity)).limit(topN).toList();
    }

    public Optional<Destination> findClosestPopularDestination(List<Destination> destinations, int minPopularity) {
        return destinations.stream().filter((Destination dest) -> dest.getPopularity() > minPopularity).min(Comparator.comparing(Destination::getDistance));
    }

    public Optional<Destination> findFarthestUnpopularDestination(List<Destination> destinations, int maxPopularity) {
        return destinations.stream().filter((Destination dest) -> dest.getPopularity() < maxPopularity).max(Comparator.comparing(Destination::getDistance));
    }

    public List<Destination> sortDestinationsByDistanceAndPopularity(List<Destination> destinations) {
        return destinations.stream().sorted(Comparator.comparing(Destination::getDistance).thenComparing(Destination::getPopularity)).toList();
    }

    public List<Destination> sortDestinationsByReviewScoreAndPopularity(List<Destination> destinations) {
        return destinations.stream().sorted(Comparator.comparing((Destination dest) -> dest.getReviews().stream().mapToDouble(Review::getRating).average().orElse(0.0)).reversed().thenComparing(Destination::getPopularity)).toList();
    }

    public List<Destination> sortDestinationsByPopularityAndReviewScore(List<Destination> destinations) {
        return destinations.stream().sorted(Comparator.comparing(Destination::getPopularity).thenComparing((Destination dest) -> dest.getReviews().stream().mapToDouble(Review::getRating).average().orElse(0.0)).reversed()).toList();
    }
}
