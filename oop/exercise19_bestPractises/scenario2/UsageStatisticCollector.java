package oop.exercise19_bestPractises.scenario2;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
// AI Copied
public class UsageStatisticCollector implements Collector<Loan, LibraryUsageStatistics, LibraryUsageStatistics> {

    @Override
    public Supplier<LibraryUsageStatistics> supplier() {
        return LibraryUsageStatistics::new;
    }

    @Override
    public BiConsumer<LibraryUsageStatistics, Loan> accumulator() {
        return (stats, loan) -> {
            stats.setTotalBooksLoaned(stats.getTotalBooksLoaned() + 1);
        };
    }

    @Override
    public BinaryOperator<LibraryUsageStatistics> combiner() {
        return (stats1, stats2) -> {
            LibraryUsageStatistics combinedStats = new LibraryUsageStatistics();
            combinedStats.setTotalBooksLoaned(stats1.getTotalBooksLoaned() + stats2.getTotalBooksLoaned());
            return combinedStats;
        };
    }

    @Override
    public Function<LibraryUsageStatistics, LibraryUsageStatistics> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
    }
    
}
