package oop.exercise19_bestPractises.scenario3;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
// AI Copied
public class HealthcareStatisticsCollector implements Collector<Integer, HealthcareStatistics, HealthcareStatistics>{

    @Override
    public Supplier<HealthcareStatistics> supplier() {
        return HealthcareStatistics::new;
    }

    @Override
    public BiConsumer<HealthcareStatistics, Integer> accumulator() {
        return (HealthcareStatistics, integer) -> HealthcareStatistics.add(integer);
    }

    @Override
    public BinaryOperator<HealthcareStatistics> combiner() {
       return (healthcareStatistics1, healthcareStatistics2) -> {
        healthcareStatistics1.combine(healthcareStatistics2.getNumberOfSurgeries());
        return healthcareStatistics1;
       };
    }

    @Override
    public Function<HealthcareStatistics, HealthcareStatistics> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
    
}
