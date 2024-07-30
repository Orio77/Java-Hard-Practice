package streamAPI.exercise14_streamOrdering.scenario2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PropertyManagement {
    
    public Map<String, Double> findAveragePriceByNeighborhood(List<Property> properties) {
        
        return properties.stream().collect(Collectors.groupingBy(Property::getNeighbourhood, Collectors.averagingDouble(Property::getPrice))).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public List<String> findTopThreeExpensiveNeighborhoods(List<Property> properties) {
        return properties.stream().collect(Collectors.groupingBy(Property::getNeighbourhood, Collectors.summingDouble(Property::getPrice))).entrySet().stream().limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public String findMostCommonNeighborhood(List<Property> properties) {
        return properties.stream().collect(Collectors.groupingBy(Property::getNeighbourhood, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey())).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public String findLeastCommonNeighborhood(List<Property> properties) {
        return properties.stream().collect(Collectors.groupingBy(Property::getNeighbourhood, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().thenComparing(Map.Entry.comparingByKey())).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public Optional<String> findFirstPropertyOverPrice(List<Property> properties, int price) {
        
        return properties.stream().filter(property -> property.getPrice() > price).map(property -> property.getNeighbourhood()).findFirst();
    }

    public Optional<String> findLastPropertyUnderPrice(List<Property> properties, int price) {

        return properties.stream().filter(property -> property.getPrice() < price).map(property -> property.getNeighbourhood()).sorted(Comparator.reverseOrder()).findFirst();
    }

    public List<Property> sortByPriceThenNeighborhood(List<Property> properties) {

        return properties.stream().sorted(Comparator.comparing(Property::getPrice).thenComparing(p -> p.getNeighbourhood())).toList();
    }

    public Map<String, List<Property>> groupByNeighborhoodThenSortByPrice(List<Property> properties) {
        return properties.stream().collect(Collectors.groupingBy(Property::getNeighbourhood)).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, (Map.Entry<String, List<Property>> es ) -> es.getValue().stream().sorted(Comparator.comparing(Property::getPrice)).collect(Collectors.toList())));
    }

    public Map<String, Property> findCheapestPropertyInEachNeighborhood(List<Property> properties) {

        Map<String, List<Property>> groupedByNeighboorhood = properties.stream().collect(Collectors.groupingBy(Property::getNeighbourhood)).entrySet().stream().collect(Collectors.toMap((Map.Entry<String, List<Property>> es) -> es.getKey() , (Map.Entry<String, List<Property>> es) -> es.getValue()));
    
        return groupedByNeighboorhood.entrySet().stream().flatMap(es -> {
            Map<String, Property> returnMap = new HashMap<>();
            returnMap.put(es.getKey(), es.getValue().stream().min(Comparator.comparing(Property::getPrice)).orElse(null));
            return returnMap.entrySet().stream();
        }).collect(Collectors.toMap((Map.Entry<String, Property> es )-> es.getKey(), Map.Entry::getValue));
    }
}
