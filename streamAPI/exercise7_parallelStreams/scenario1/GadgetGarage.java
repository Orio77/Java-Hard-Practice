package streamAPI.exercise7_parallelStreams.scenario1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import streamAPI.exercise4_collectors.scenario1.Pair;

public class GadgetGarage {
    private List<Transaction> transactions;

    public Map<String, Double> calculateSalesByPerson() {
        return transactions.parallelStream().collect(Collectors.toMap(t -> t.getSalesPerson(), t -> t.getPricePerUnit()*t.getQuantity()));
    }

    public Map<String, Map<String, Pair<Double, Double>>> calculateSalesAndAveragePriceByPersonAndProduct() {
        return transactions.parallelStream().collect(Collectors.groupingBy(Transaction::getSalesPerson, Collectors.toMap(Transaction::getProductName, t -> new Pair<>(t.getQuantity(), t.getPricePerUnit()))));
    }

    // AI Copied
    public Map<String, String> findTopSellingProductPerPerson() {

        return transactions.parallelStream()
                            .collect(Collectors.groupingBy(
                                Transaction::getSalesPerson, 
                                Collectors.collectingAndThen(
                                    Collectors.groupingBy(
                                        Transaction::getProductName,
                                        Collectors.summingDouble(t -> t.getQuantity()*t.getPricePerUnit())
                                    ), 
                                    map -> map.entrySet().stream()
                                                        .max(Map.Entry.comparingByValue())
                                                        .map(Map.Entry::getKey)
                                                        .orElse(null)
                                )
                            ));
    }

    // AI Copied
    public Map<String, Map<String, Pair<Double, Double>>> calculateSalesAndAveragePriceByPersonAndCategory(List<Transaction> transactions, List<Product> products) {

        Map<String, Product> productMap = products.stream().collect(Collectors.toMap(Product::getName, Function.identity()));

        return transactions.parallelStream().collect(Collectors.groupingBy(Transaction::getSalesPerson,
            Collectors.groupingBy(t -> productMap.get(t.getProductName()).getCategory(),
                Collector.of(
                    () -> new double[3], 
                    (a, t) -> {
                        a[0] += t.getQuantity() * t.getPricePerUnit();
                        a[1] += t.getQuantity();
                        a[2] = a[0] / a[1];
                    }, 
                    (a, b) -> {
                        a[0] += b[0];
                        a[1] += b[1];
                        a[2] = a[0] / a[1];
                        return a;
                    }, 
                    a -> new Pair<>(a[0], a[2])
                )
            )
        ));
    }

    // AI Copied
    public Map<String, Map<String, Pair<Double, Double>>> calculateSalesAndAveragePriceByPersonAndManufacturer(List<Transaction> transactions, List<Product> products) {

        Map<String, Product> productMap = products.stream().collect(Collectors.toMap(Product::getName, Function.identity()));

        return transactions.parallelStream().collect(Collectors.groupingBy(Transaction::getSalesPerson,
            Collectors.groupingBy(t -> productMap.get(t.getProductName()).getManufacturer(),
                Collector.of(
                    () -> new double[3], 
                    (a, t) -> {
                        a[0] += t.getQuantity() * t.getPricePerUnit();
                        a[1] += t.getQuantity();
                        a[2] = a[0] / a[1];
                    }, 
                    (a, b) -> {
                        a[0] += b[0];
                        a[1] += b[1];
                        a[2] = a[0] / a[1];
                        return a;
                    }, 
                    a -> new Pair<>(a[0], a[2])
                )
            )
        ));
    }

    public Map<String, Map<String, Triple<String, Pair<Double, Double>, String>>> calculateTopPerformerAndSalesByCategory(List<Transaction> transactions, List<Product> products) {
        return calculateTopPerformerAndSales(transactions, products, Product::getCategory);
    }

    public Map<String, Map<String, Triple<String, Pair<Double, Double>, String>>> calculateTopPerformerAndSalesByManufacturer(List<Transaction> transactions, List<Product> products) {
        return calculateTopPerformerAndSales(transactions, products, Product::getManufacturer);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Map<String, Triple<String, Pair<Double, Double>, String>>> calculateTopPerformerAndSales(List<Transaction> transactions, List<Product> products, Function<Product, String> classifier) {
        Map<String, Product> productMap = products.stream().collect(Collectors.toMap(Product::getName, Function.identity()));
        return transactions.parallelStream()
            .collect(Collectors.groupingBy(t -> classifier.apply(productMap.get(t.getProductName())),
                Collectors.groupingBy(Transaction::getProductName,
                    Collector.of(
                        () -> new Object[] {new HashMap<String, Integer>(), 0.0, 0, null, 0.0, null},
                        (a, t) -> {
                            ((Map<String, Integer>) a[0]).merge(t.getSalesPerson(), (int) t.getQuantity(), Integer::sum);
                            a[1] = (double) a[1] + t.getProduct().getPrice() * t.getQuantity();
                            a[2] = (int) a[2] + t.getQuantity();
                            if (a[3] == null || t.getProduct().getPrice() > (double) a[4]) {
                                a[3] = t.getSalesPerson();
                                a[4] = t.getProduct().getPrice();
                            }
                            if (a[5] == null || t.getQuantity() > (int) a[2]) {
                                a[5] = t.getProductName();
                            }
                        },
                        (a, b) -> {
                            ((Map<String, Integer>) a[0]).putAll((Map<String, Integer>) b[0]);
                            a[1] = (double) a[1] + (double) b[1];
                            a[2] = (int) a[2] + (int) b[2];
                            if ((double) a[4] < (double) b[4]) {
                                a[3] = b[3];
                                a[4] = b[4];
                            }
                            if ((int) a[2] < (int) b[2]) {
                                a[5] = b[5];
                            }
                            return a;
                        },
                        a -> {
                            String topSalesperson = ((Map<String, Integer>) a[0]).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
                            return Triple.of(topSalesperson, new Pair<>((double) a[1], (double) a[1] / (int) a[2]), (String) a[5]);
                        }
                    )
                )
            ));
    }

    
}
