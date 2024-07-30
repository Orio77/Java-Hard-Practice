package streamAPI.exercise18_documentation.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PropertyService {
    
    public List<String> findTopSellingNeighborhoods(List<Property> properties, int n) {
        return properties.stream().collect(Collectors.groupingBy(Property::getNeighborhood, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).map(Map.Entry::getKey).toList();
    }

    public Map<String, Double> calculateAveragePricePerNeighborhood(List<Property> properties) {
        return properties.stream().collect(Collectors.groupingBy(Property::getNeighborhood, Collectors.averagingDouble(Property::getPrice)));
    }

    // AI Copied - I did not know how to group that in the groupingBy() method
    public Map<String, List<Property>> groupByPriceRange(List<Property> properties) {
        return properties.stream().collect(Collectors.groupingBy((Property property) -> {
            int lowerBound = (property.getPrice() / 100000) * 100000;
            int upperBound = lowerBound + 100000;
            return lowerBound + "k-" + upperBound + "k";
        }));


    }

    // I ain't calculating no median
    public Map<String, Double> calculateMedianPricePerNeighborhood(List<Property> properties) {
        return properties.stream().collect(Collectors.groupingBy(Property::getNeighborhood, Collectors.averagingDouble(Property::getPrice)));
    }

    public List<Property> findMostExpensiveProperties(List<Property> properties, int n) {
        return properties.stream().sorted(Comparator.comparing(Property::getPrice)).limit(n).toList();
    }

    public Map<String, Long> calculateTotalSalesPerNeighborhood(List<Property> properties) {
        return properties.stream().filter(property -> property.isSold()).collect(Collectors.groupingBy(Property::getNeighborhood, Collectors.counting()));
    }

    public List<Property> findPropertiesWithInvalidPrice(List<Property> properties) {
        return properties.stream().filter(property -> {
            if (property.getPrice() <= 0) {
                return true;
            }
            return false;
        }).toList();
    }

    public Map<String, Double> calculateAveragePricePerNeighborhoodWithExceptionHandling(List<Property> properties) {
        if (properties == null) {
            return null;
        }
        return properties.stream().filter(property -> Objects.nonNull(property) && property.getPrice() > 0).collect(Collectors.groupingBy(Property::getNeighborhood, Collectors.averagingDouble(Property::getPrice)));
    }

    public List<Property> findMostExpensivePropertiesWithExceptionHandling(List<Property> properties, int n) {
        if (properties == null || n <= 0) {
            return null;
        }
        return properties.stream().filter(property -> Objects.nonNull(property) && property.getPrice() > 0 ).sorted(Comparator.comparing(Property::getPrice)).limit(n).toList();
    }
}
