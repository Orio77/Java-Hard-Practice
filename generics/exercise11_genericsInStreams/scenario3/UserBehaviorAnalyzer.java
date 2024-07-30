package generics.exercise11_genericsInStreams.scenario3;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserBehaviorAnalyzer {
    
    public List<UserInteraction> filterInteractions(List<UserInteraction> interactionsToAnalyze, Predicate<UserInteraction> predicate) {
        return interactionsToAnalyze.parallelStream().filter(predicate).collect(Collectors.toList());
    }

    public <K> Map<K, List<UserInteraction>> groupInteractionsBy(List<UserInteraction> interactions, Function<UserInteraction, K> classifier) {
        return interactions.parallelStream().collect(Collectors.groupingByConcurrent(classifier));
    }

    public <K> void benchmark(List<UserInteraction> interactions, Predicate<UserInteraction> predicate, Function<UserInteraction, K> classifier) {
        long startTime = System.nanoTime();
        filterInteractions(interactions, null);
        groupInteractionsBy(interactions, null);
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + "ns");
    }
}
