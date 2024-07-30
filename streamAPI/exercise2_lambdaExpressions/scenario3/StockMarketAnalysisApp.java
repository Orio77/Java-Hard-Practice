package streamAPI.exercise2_lambdaExpressions.scenario3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StockMarketAnalysisApp {
    
    public List<Transaction> findTopTransactionsByVolume(List<Transaction> transactions, int n) {
        return transactions.stream().sorted(Comparator.comparing(Transaction::getVolume)).limit(n).toList();
    }

    public Map<String, Double> calculateAveragePricePerTicker(List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getTicker, Collectors.averagingDouble(Transaction::getPrice)));
    }

    public Map<LocalDate, List<Transaction>> groupTransactionsByDate(List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getDate));
    }

    public Map<String, Integer> calculateTotalVolumePerTicker(List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getTicker, Collectors.summingInt(Transaction::getVolume)));
    }

    public LocalDate findMostActiveDay(List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getVolume))).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public Map<String, Double> calculatePriceChangePerTicker(List<Transaction> transactions) {
        Map<String, List<Double>> map = transactions.stream().collect(Collectors.groupingBy(Transaction::getTicker, Collectors.mapping(Transaction::getPrice, Collectors.toList())));

        return map.entrySet().stream().map(es -> {
            List<Double> prices = es.getValue();
            prices.sort(Comparator.reverseOrder());
            Double max = prices.get(0);
            Double min = prices.get(prices.size() - 1);
            Map.Entry<String, Double> newEntrySet = Map.entry(es.getKey(), max - min);
            return newEntrySet;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Optional<Transaction> findTransactionWithHighestPrice(List<Transaction> transactions) {
        return transactions.stream().max(Comparator.comparing(Transaction::getPrice));
    }

    public Optional<Transaction> findTransactionWithLowestPrice(List<Transaction> transactions) {
        return transactions.stream().min(Comparator.comparing(Transaction::getPrice));
    }

    public Map<DayOfWeek, Integer> calculateTotalVolumePerDay(List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.groupingBy(transaction -> transaction.getDate().getDayOfWeek(), Collectors.summingInt(Transaction::getVolume)));
    }
}
