package streamAPI.exercise8_exceptionHandling.scenario1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import streamAPI.exercise7_parallelStreams.scenario1.Product;

public class SalesDemo {
    private List<Sale> sales;

    public double calculateTotal() {
        return sales.stream().mapToDouble(s -> s.getPricePerUnit()*s.getQuantity()).sum();
    } 

    public List<Map.Entry<Product, Double>> getTopSellingProducts() {
        Map<Product, Double> unsorted = sales.stream().filter(Objects::nonNull).collect(Collectors.toMap(Sale::getProduct, s -> s.getPricePerUnit()*s.getQuantity()));

        List<Map.Entry<Product, Double>> toBeSorted = new ArrayList<>(unsorted.entrySet());
        return toBeSorted.stream().sorted(Map.Entry.comparingByValue()).limit(10).toList();
    }

    public void printTotalSalesAmount() {

        Map<String, Double> map = sales.stream().collect(Collectors.groupingBy(Sale::getSalesPersonName, Collectors.summingDouble(s -> s.getPricePerUnit()*s.getQuantity())));

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }

    public void handleMultipleSources(List<Sale> sales1, List<Sale> sales2) {

        Map<Product, Double> map = Stream.concat(sales1.stream(), sales2.stream()).collect(Collectors.groupingBy(Sale::getProduct, Collectors.summingDouble(s -> s.getPricePerUnit()*s.getQuantity())));
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(10).forEach(System.out::println);
    }

    public void analyzeSales(List<Sale> sales1, List<Sale> sales2) {

        Map<String, Double> map = Stream.concat(sales1.stream(), sales2.stream()).filter(Objects::nonNull).collect(Collectors.groupingBy(Sale::getSalesPersonName, Collectors.summingDouble(sale -> sale.getPricePerUnit()*sale.getQuantity())));

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(10).forEach(System.out::println);

        Map<Product, Double> mapProduct = Stream.concat(sales1.stream(), sales2.stream()).filter(Objects::nonNull).collect(Collectors.groupingBy(Sale::getProduct, Collectors.summingDouble(sale -> sale.getPricePerUnit()*sale.getQuantity())));

        mapProduct.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(10).forEach(System.out::println);

    }
}
