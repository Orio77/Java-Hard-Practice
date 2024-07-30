package streamAPI.exercise9_streamPerformance.scenario2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class OnlineShop {
    
    public List<String> findTopBuyers(List<Customer> customers, int n) {
        return customers.stream().collect(Collectors.groupingBy(Customer::getName, Collectors.summingDouble(c -> c.getPurchaseHistory().stream().collect(Collectors.summingDouble(p -> p.getQuantity()*p.getPrice()))))).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).limit(n).toList();
    }

    public List<String> findPopularProducts(List<Customer> customers, int n) {
        return customers.stream().flatMap(cust -> cust.getPurchaseHistory().stream()).sorted(Comparator.comparing(Purchase::getQuantity)).limit(n).map(Purchase::getProduct).toList();
    }

    public List<String> findTopBuyersWithCollector(List<Customer> customers, int n) {

        return customers.stream().collect(new CustomerCollector()).entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(n).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public List<String> findPopularProductsWithCollector(List<Customer> customers, int n) {
        return customers.stream().flatMap(customer -> customer.getPurchaseHistory().stream()).collect(new ProductCollector()).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(n).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public List<String> findTopBuyersParallel(List<Customer> customers, int n) {
        return customers.parallelStream().collect(Collectors.groupingBy(Customer::getName, Collectors.summingDouble(c -> c.getPurchaseHistory().stream().collect(Collectors.summingDouble(p -> p.getQuantity()*p.getPrice()))))).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).limit(n).toList();
    }

    public List<String> findPopularProductsParalllel(List<Customer> customers, int n) {
        return customers.parallelStream().flatMap(cust -> cust.getPurchaseHistory().stream()).sorted(Comparator.comparing(Purchase::getQuantity)).limit(n).map(Purchase::getProduct).toList();
    }

    public Map<Customer, String> findTopBuyersForProduct(List<Customer> customers, String product, int n) {

        return customers.stream().filter(customer -> {
            List<Purchase> purchases = customer.getPurchaseHistory();

            List<String> products = purchases.stream().map(purchase -> purchase.getProduct()).toList();

            if (products.contains(product)) {
                return true;
            }
            else {
                return false;
            }
        }).sorted(Comparator.comparing((Customer customer) -> customer.getPurchaseHistory().stream().filter(p -> p.getProduct().equals(product)).mapToInt(Purchase::getQuantity).sum()).reversed()).limit(n).collect(Collectors.toMap(Function.identity(), customer -> product));
    }
}
