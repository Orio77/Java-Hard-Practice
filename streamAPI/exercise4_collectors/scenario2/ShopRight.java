package streamAPI.exercise4_collectors.scenario2;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class that leverages streams to manipulate company customer and product data
 */
public class ShopRight {
    private List<Purchase> purchases;

    /**
     * A method that gets top 10 customers based on their quantity of purchase
     * @return a List of customer Ids
     */
    public List<String> getTopTenCustomers() {
        return purchases.stream().filter(p -> p.getPurchaseDate().isAfter(LocalDateTime.now().minusYears(1))).collect(Collectors.groupingBy(Purchase::getCustomerId, Collectors.summingInt(Purchase::getQuantity))).entrySet().stream().sorted(Comparator.comparing(es -> es.getValue())).limit(10).map(es -> es.getKey()).toList();
    }

    /**
     * A method that gets top 10 product based on the units sold
     * @return a Map, keys being product ID's and value being quantity of units sold
     */
    public Map<String, Integer> getTopTenProducts() {
        return purchases.stream().collect(Collectors.groupingBy(Purchase::getProductId, Collectors.summingInt(Purchase::getQuantity))).entrySet().stream().sorted(Comparator.comparing(es -> es.getValue())).limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * prints top 10 customers based on units bought and top 10 products based on units sold
     */
    public void printTopTenCustomersAndProducts() {

        System.out.println("Top ten customers:");
        getTopTenCustomers().stream().forEach(System.out::println);
        System.out.println();
        System.out.println("Top ten products:");
        getTopTenProducts().entrySet().stream().map(es -> es.getKey()).forEach(System.out::println);
    }

    /**
     * Optimized method that prints top 10 customers based on units bought and top 10 products based on units sold
     * leverages parallel streams and handles null values
     */
    public void printTopTenCustomersAndProductsOptimized() {

        List<String> customerList = purchases.parallelStream().filter(p -> p != null && p.getCustomerId() != null && p.getProductId() != null).filter(p -> p.getPurchaseDate().isAfter(LocalDateTime.now().minusYears(1))).collect(Collectors.groupingBy(Purchase::getCustomerId, Collectors.summingInt(Purchase::getQuantity))).entrySet().stream().sorted(Comparator.comparing(es -> es.getValue())).limit(10).map(es -> es.getKey()).toList();

        Map<String, Integer> productMap = purchases.parallelStream().filter(p -> p != null && p.getCustomerId() != null && p.getProductId() != null).collect(Collectors.groupingBy(Purchase::getProductId, Collectors.summingInt(Purchase::getQuantity))).entrySet().stream().sorted(Comparator.comparing(es -> es.getValue())).limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Top ten customers:");
        customerList.stream().forEach(System.out::println);
        System.out.println();
        System.out.println("Top ten products:");
        productMap.entrySet().stream().map(es -> es.getKey()).forEach(System.out::println);

    }
}
