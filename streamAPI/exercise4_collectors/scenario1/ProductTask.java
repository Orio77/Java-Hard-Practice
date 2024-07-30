package streamAPI.exercise4_collectors.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductTask {
    private List<Product> products;

    
    public void sortByPrice() {
        products.stream().sorted(Comparator.comparing(p -> p.getPrice()));
    }

    public Map<Double, List<Product>> groupByPrice() {
        return products.stream().collect(Collectors.groupingBy(p -> p.getPrice()));
    }

    // AI Helped
    public Map<String, Double> getAveragePriceOfEachCategory() {
        return products.stream().collect(Collectors.groupingBy(p -> p.getCategory(), Collectors.averagingDouble(p -> p.getPrice())));
    } 

    // AI Helped
    public Map<String, Pair<Product, Product>> getMostAndLeastExpensive() {

        return products.stream().collect(Collectors.groupingBy(p -> p.getCategory(), Collectors.collectingAndThen(Collectors.toList(), list -> {
            Optional<Product> min = list.stream().min(Comparator.comparing(p -> p.getPrice()));
            Optional<Product> max = list.stream().max(Comparator.comparing(p -> p.getPrice()));
            return new Pair<Product, Product>(max.orElse(null), min.orElse(null));
        })));
    }

    public List<Product> getaboveAverageProducts() {

        double avg = products.stream().mapToDouble(p -> p.getPrice()).average().orElse(0);

        return products.stream().filter(p -> p.getPrice() > avg).toList();
    }

}

