package streamAPI.exercise11_customCollectors.scenario2;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EcommercePlatform {
    
    public Optional<String> findTopClickedProducts(List<UserClick> clicks) {
        return clicks.stream().collect(Collectors.groupingBy(UserClick::getProduct, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Optional<String> findMostActiveUser(List<UserClick> clicks) {
        return clicks.stream().collect(Collectors.groupingBy(UserClick::getUser, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Optional<String> findTopClickedProductParallel(List<UserClick> clicks) {
        return clicks.parallelStream().collect(Collectors.groupingBy(UserClick::getProduct, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Optional<String> findMostActiveUserParallel(List<UserClick> clicks) {
        return clicks.parallelStream().collect(Collectors.groupingBy(UserClick::getUser, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public String findTopClickedProductFromMap(Map<String, List<String>> clicks) {
        return clicks.values().stream().flatMap(list -> list.stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public String findMostActiveUserFromMap(Map<String, List<String>> clicks) {
        return clicks.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public String findTopClickedProductSafe(List<UserClick> clicks) {
        return clicks.stream().filter(click -> click != null && click.getProduct() != null && click.getUser() != null).collect(Collectors.groupingBy(UserClick::getProduct, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public String findMostActiveUserSafe(List<UserClick> clicks) {
        return clicks.stream().collect(Collectors.groupingBy(UserClick::getUser, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public boolean validateClicks(List<UserClick> clicks) {
        return clicks.stream().anyMatch(click -> click == null || click.getProduct() == null || click.getUser() == null);
    }
}
