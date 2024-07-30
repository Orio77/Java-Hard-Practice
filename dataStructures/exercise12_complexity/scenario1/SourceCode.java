package dataStructures.exercise12_complexity.scenario1;

import java.util.*;
import java.time.Duration;
import java.time.Instant;

class Product {
    String id;
    String name;

    Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    String getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }
}

class SourceCode {
    static List<Product> getProductsFromDatabase() {
        // Simulate a database operation
        List<Product> products = new ArrayList<>();
        for (int i = 100000; i > 0; i--) {
            products.add(new Product("id" + i, "product" + i));
        }
        return products;
    }

    static Product findProductByName(List<Product> products, String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    static Product findProductByNameOptimized(List<Product> products, String name) {

        int start = 0;
        int end = products.size() - 1;


        while (start < end) {
            int mid = start + (end - start) / 2;
            String midProduct = products.get(mid).getName();

            if (midProduct.equals(name)) {
                return products.get(mid);
            }

            if (midProduct.compareTo(name) < 0) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return null;
    }

    static int countProductsWithNameLengthGreaterThan(List<Product> products, int length) {
        int count = 0;
        for (Product product : products) {
            if (product.getName().length() > length) {
                count++;
            }
        }
        return count;
    }

    static int countProductsWithNameLengthGreaterThanOptimized(List<Product> products, int length) {

        sortByLength(products);

        int start = 0;
        int end = products.size();

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (products.get(mid).getName().length() == length) {
                do {
                    mid++;
                } while (products.get(mid).getName().length() == length);

                return products.size() - mid - 1;
            }

            if (products.get(mid).getName().length() < length) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return 0;
    }

    private static void sortByLength(List<Product> products) {
        products.sort((p1, p2) -> Integer.compare(p1.getName().length(), p2.getName().length()));
    }

    static String findMostCommonProductName(List<Product> products) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (Product product : products) {
            frequencyMap.put(product.getName(), frequencyMap.getOrDefault(product.getName(), 0) + 1);
        }

        Map.Entry<String, Integer> mostCommon = null;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (mostCommon == null || mostCommon.getValue() < entry.getValue()) {
                mostCommon = entry;
            }
        }

        return mostCommon != null ? mostCommon.getKey() : null;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        List<Product> products = getProductsFromDatabase();
        // This part needs optimization
        products.sort((Product p1, Product p2) -> p1.getName().compareTo(p2.getName()));
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
        System.out.println("Time elapsed: " + timeElapsed + " ms");

        Instant.now();
        findProductByNameOptimized(products, "product9000");
        Instant.now();
        System.out.println("Time elapsed for finding product by name: " + timeElapsed + " ms");

        Instant startCount = Instant.now();
        countProductsWithNameLengthGreaterThan(products, 10);
        // int count = countProductsWithNameLengthGreaterThanOptimized(products, 10);
        Instant finishCount = Instant.now();
        long timeElapsedCount = Duration.between(startCount, finishCount).toMillis();  //in millis
        System.out.println("Time elapsed for count: " + timeElapsedCount + " ms");

        Instant startMostCommon = Instant.now();
        findMostCommonProductName(products);
        Instant finishMostCommon = Instant.now();
        long timeElapsedMostCommon = Duration.between(startMostCommon, finishMostCommon).toMillis();  //in millis
        System.out.println("Time elapsed for finding most common product name: " + timeElapsedMostCommon + " ms");

        // Print the first 10 products to verify the sorting
        for (int i = 0; i < 10; i++) {
            System.out.println(products.get(i).getName());
        }
    }
}