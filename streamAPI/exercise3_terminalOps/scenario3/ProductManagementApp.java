package streamAPI.exercise3_terminalOps.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductManagementApp {
    
    public List<Product> findTopRatedProducts(List<Product> products, int n) {
        return products.stream().sorted(Comparator.comparing(Product::getRating)).limit(n).toList();
    }

    // This method was supposed to return n cheapest products in given category, I misunderstood and made it more advanced
    public Map<String, List<Product>> findCheapestProductsInCategory(List<Product> products, String category, int n) {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory)).entrySet().stream().map(es -> {
            es.getValue().sort(Comparator.comparing(Product::getPrice).reversed());
            List<Product> nProducts = es.getValue().stream().limit(n).toList();
            return Map.entry(es.getKey(), nProducts);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Product> findMostExpensiveProductInEachCategory(Map<String, List<Product>> products) {
        return products.entrySet().stream().map(es -> {
            Optional<Product> max = es.getValue().stream().max(Comparator.comparing(Product::getPrice));
            Map.Entry<String, Product> map = null;
            if (max.isPresent()) {
                map = Map.entry(es.getKey(), max.get());
            }
            else {
                map = Map.entry(es.getKey(), null);
            }
            return map;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Product> findLeastRatedProductInEachCategory(Map<String, List<Product>> products) {
        return products.entrySet().stream().map(es -> {
            Optional<Product> min = es.getValue().stream().min(Comparator.comparing(Product::getPrice));
            Map.Entry<String, Product> map = null;
            if (min.isPresent()) {
                map = Map.entry(es.getKey(), min.get());
            }
            else {
                map = Map.entry(es.getKey(), null);
            }
            return map;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public List<Product> findTopRatedProductsParallel(List<Product> products, int n) {
        return products.parallelStream().sorted(Comparator.comparing(Product::getRating)).limit(n).toList();
    }

    public List<Product> findCheapestProductsInCategoryParallel(List<Product> products, String category, int n) {
        return products.stream().filter(product -> product.getCategory().matches(category)).sorted(Comparator.comparing(Product::getPrice).reversed()).limit(n).toList();
    }

    public List<Product> findProductsByCategory(List<Product> products, String category) {
        return products.stream().filter(product -> product.getCategory().matches(category)).toList();
    }

    public Product findProductByName(List<Product> products, String name) {
        return products.stream().filter(product -> product.getName().matches(name)).findFirst().orElse(null);
    }

    public List<Product> findProductsByPriceRange(List<Product> products, double minPrice, double maxPrice) {
        return products.stream().filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice).toList();
    }
}
