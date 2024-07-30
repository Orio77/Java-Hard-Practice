package streamAPI.exercise12_methodReferences.scenario1;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FinanceDepartment {
    private List<Transaction> transactions;
    
    
    public List<String> getCreditTransactions() {
        return transactions.stream().filter(t -> t.getType().matches("credit")).map(t -> "Transaction ID: " + t.getId() + ", Amount: " + t.getAmount() + ", Date: " + t.getDate()).toList();
    }

    public List<String> getBigCreditTransactions() {
        return transactions.stream().filter(t -> t.getType().matches("credit") && t.getAmount() > 500).sorted(Comparator.comparing(t -> t.getDate())).map(t -> "Transaction ID: " + t.getId() + ", Amount: " + t.getAmount() + ", Date: " + t.getDate()).toList();
    }

    public Map<YearMonth, Double> getMoneySpentPerMonth() {
        
        return transactions.stream().filter(t -> t.getType().matches("credit") && t.getAmount() > 500).collect(Collectors.groupingBy(t -> YearMonth.from(t.getDate()), Collectors.summingDouble(Transaction::getAmount)));
    }

    // AI Helped
    public Map<YearMonth, String> getInfoOnMoneySpentPerMonth(List<Transaction> transactions2) {

        Map<YearMonth, Double> sums = Stream.concat(transactions.stream(), transactions2.stream()).filter(t -> t.getType().matches("credit") && t.getAmount() > 500).collect(Collectors.groupingBy(t -> YearMonth.from(t.getDate()), Collectors.summingDouble(Transaction::getAmount)));

        return sums.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> String.format("Month: %s, Total Amonut: %.2f", e.getKey(), e.getValue())));
    }

    // AI Helped
    public Map<YearMonth, String> getInfoOnMoneySpentPerMonthAndMostExpensiveTransaction(List<Transaction> transactions2) {

        Map<YearMonth, Double> sums = Stream.concat(transactions.stream(), transactions2.stream()).filter(t -> t.getType().matches("credit") && t.getAmount() > 500).collect(Collectors.groupingBy(t -> YearMonth.from(t.getDate()), Collectors.summingDouble(Transaction::getAmount)));

        Map<YearMonth, Transaction> highestTransaction = Stream.concat(transactions.stream(), transactions2.stream()).filter(t -> t.getType().matches("credit") && t.getAmount() > 500).collect(Collectors.groupingBy(t -> YearMonth.from(t.getDate()), Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Transaction::getAmount)), Optional::get)));

        return sums.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> String.format("Month: %s, Highest Transaction: %.2f, Total Amonut: %.2f", e.getKey(), highestTransaction.get(e.getKey()), e.getValue())));

    }
}
