package streamAPI.exercise20_usefulPrograms.scenario1;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Application {
    private List<Product> products;
    private Stack<Exception> exceptionLog;

    public double getSumOfProductsInDemand() {
        return products.stream().filter(product -> product instanceof Product).filter(Objects::nonNull).filter(p -> p.getSalesCount() > 100).map(p -> p.getPrice()).reduce(0.0, (p1, p2) -> p1 + p2);
    }

    public Map<String, List<Product>> groupByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public Map<String, Integer> getSalesCountPerCategory() {
        return products.stream().filter(p -> p.getSalesCount() > 100 && p.getCategory() != null && !p.getCategory().isBlank()).collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getSalesCount)));
    }

    public ConcurrentMap<String, Integer> getSalesCountPerCategoryOptimized() {
        return products.stream().filter(p -> p.getSalesCount() > 100 && p.getCategory() != null && !p.getCategory().isBlank()).parallel().collect(Collectors.groupingByConcurrent(Product::getCategory, Collectors.summingInt(Product::getSalesCount)));
    }

    public Map<String, Integer> getSalesCountPerCategorySafe() {
        return products.stream().filter(p -> p.getSalesCount() > 100).collect(Collectors.groupingBy(p -> {
            try {
                return p.getCategory();
            } catch (Exception e) {
                exceptionLog.push(e);
                return null;
            }
        }, Collectors.summingInt(p -> {
            try {
                return p.getSalesCount();
            } catch (NumberFormatException e) {
                exceptionLog.push(e);
                return 0;
            }
        })));
    }

}
