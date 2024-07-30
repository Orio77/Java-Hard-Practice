package streamAPI.exercise15_errorHandlingStrategies.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SalesAnalyzer {

    public double filterAndSumSales(List<Sale> sales) {
        return sales.stream().filter(Objects::nonNull).filter(sale -> !sale.getLocation().matches("New York")).mapToDouble(sale -> sale.getQuantity()*sale.getPrice()).sum();
    }

    public String findMostSoldItem(List<Sale> sales) {
        return sales.stream().filter(Objects::nonNull).filter(sale -> sale.getQuantity() >= 0 && sale.getItem() != null).max(Comparator.comparing(Sale::getQuantity)).map(Sale::getItem).orElse(null);
    }

    public Map<String, Integer> groupByItemAndSumQuantity(List<Sale> sales) {
        return sales.stream().filter(sale -> sale.getQuantity() >= 0 && sale.getItem() != null && Objects.nonNull(sale)).collect(Collectors.groupingBy(Sale::getItem, Collectors.summingInt(Sale::getQuantity)));
    }

    public Map<String, Double> groupByLocationAndCalculateAveragePrice(List<Sale> sales) {
        return sales.stream().filter(sale -> Objects.nonNull(sale) && sale.getLocation() != null && sale.getPrice() > 0).collect(Collectors.groupingBy(Sale::getLocation, Collectors.averagingDouble(Sale::getPrice)));
    }

    public String findMostExpensiveItem(List<Sale> sales) {
        return sales.stream().filter(sale -> Objects.nonNull(sale) && sale.getItem() != null && sale.getPrice() > 0).max(Comparator.comparing(Sale::getPrice)).map(Sale::getItem).orElse(null);
    }

    public String findLeastSoldItem(List<Sale> sales) {
        return sales.stream().min(Comparator.comparing(Sale::getQuantity)).map(Sale::getItem).orElse(null);
    }

    public Set<String> findItemsSoldInMostLocations(List<Sale> sales) { 
        Map<String, String> distinctMap = new TreeMap<>();

        return sales.stream().filter(sale -> {
            String item = distinctMap.get(sale.getItem());
            if (item.matches(sale.getLocation())) {
                return false;
            }
            else {
                distinctMap.put(item, sale.getLocation());
                return true;
            }
        }).collect(Collectors.groupingBy(Sale::getItem, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry<String, Long>::getKey).collect(Collectors.toSet());
    }

    public Set<String> findLocationsWithMostItems(List<Sale> sales) {
        return sales.stream().collect(Collectors.groupingBy(Sale::getLocation, Collectors.summingInt(sale -> {
            if (sale.getItem() != null) {
                return 1;
            }
            else
                return 0;
        }))).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    public Map<String, String> findItemWithHighestPricePerLocation(List<Sale> sales) {
        return sales.stream().collect(Collectors.groupingBy(Sale::getLocation)).entrySet().stream().map(es -> {
            String item = es.getValue().stream().max(Comparator.comparing(Sale::getPrice)).map(Sale::getItem).orElse(null);

            return Map.entry(es.getKey(), item);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // organize imports
}