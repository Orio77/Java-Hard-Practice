package streamAPI.exercise10_streamAPIwithDataStructures.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RetailX {
    private List<Product> products;

    public void printproductResources() {

        products.stream().filter(p -> p.getCurrentInventoryCount() >= 100).sorted(Comparator.comparing(p -> p.getCurrentInventoryCount())).forEach(p -> {
            System.out.println("Name: " + p.getName() + "\nID: " + p.getId() + "\nInventory Count: " + p.getCurrentInventoryCount());
        });
    }

    public void printProductsByCategories() {

        Map<String, List<Product>> map = products.stream().collect(Collectors.groupingBy(Product::getCategory));
        map.values().stream().forEach(l -> l.sort(Comparator.comparing(p -> p.getCurrentInventoryCount())));

        map.values().stream().forEach(l -> l.forEach(p -> {
            System.out.println("Name: " + p.getName() + "\nID: " + p.getId() + "\nInventory Count: " + p.getCurrentInventoryCount());
        }));
    }

    public void printRarestCategories() {

        products.stream().filter(p -> p.getCurrentInventoryCount() < 100).sorted(Comparator.comparing(p -> p.getCurrentInventoryCount())).limit(5).forEach(p -> {
            System.out.println("Name: " + p.getName() + "\nID: " + p.getId() + "\nInventory Count: " + p.getCurrentInventoryCount());
        });
    }

    public void getMostValuableProducts() {

        products.stream().filter(p -> p.getCurrentInventoryCount() < 100).filter(p -> p.getUnitsSoldLastMonth() > 50).sorted(Comparator.comparing(p -> p.getCurrentInventoryCount())).forEach(p -> {
            System.out.println("Name: " + p.getName() + "\nID: " + p.getId() + "\nInventory Count: " + p.getCurrentInventoryCount() + "\nUnits sold: " + p.getUnitsSoldLastMonth());
        });
    }

    public void getExpensiveProducts() {
        products.stream().filter(p -> p.getCurrentInventoryCount() < 100 && p.getSupplierDistance() > 1000.0 && p.getUnitsSoldLastMonth() > 50).sorted(Comparator.comparing(p -> p.getCurrentInventoryCount())).forEach(p -> {
            System.out.println("Name: " + p.getName() + "\nID: " + p.getId() + "\nInventory Count: " + p.getCurrentInventoryCount() + "\nUnits sold: " + p.getUnitsSoldLastMonth());
        });
    }
}
