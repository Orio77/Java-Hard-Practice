package streamAPI.exercise9_streamPerformance.scenario2;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

// AI Copied
public class CustomerCollector implements Collector<Customer, Map<String, Double>, Map<String, Double>> {
    
    @Override
    public Supplier<Map<String, Double>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Double>, Customer> accumulator() {
        return (map, customer) -> map.merge(customer.getName(), customer.getPurchaseHistory().stream().mapToDouble(p -> p.getQuantity() * p.getPrice()).sum(), Double::sum);
    }

    @Override
    public BinaryOperator<Map<String, Double>> combiner() {
        return (map1, map2) -> {
            map2.forEach((key, value) -> map1.merge(key, value, Double::sum));
            return map1;
        };
    }

    @Override
    public Function<Map<String, Double>, Map<String, Double>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
