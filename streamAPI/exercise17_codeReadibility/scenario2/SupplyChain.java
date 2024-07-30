package streamAPI.exercise17_codeReadibility.scenario2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SupplyChain {
    

    public List<Supplier> findTopSuppliers(List<Supplier> suppliers, int topN) {
        
        return suppliers.stream().sorted(Comparator.comparing(Supplier::getRating)).limit(topN).toList();
    }

    public Optional<Product> findCheapestProductForSupplier(List<Supplier> suppliers, String supplierName) {
        return suppliers.stream().filter(supplier -> supplier.getName().matches(supplierName)).flatMap(supplier -> supplier.getProducts().stream()).min(Comparator.comparing(Product::getPrice));
    }

    public List<Supplier> findFastestSuppliers(List<Supplier> suppliers, int topN) {

        return suppliers.stream().sorted(Comparator.comparing(Supplier::getLeadTime).reversed()).limit(topN).toList();
    }

    public Optional<Product> findMostExpensiveProductForSupplier(List<Supplier> suppliers, String supplierName) {
        return suppliers.stream().filter(supplier -> supplier.getName().matches(supplierName)).flatMap(supplier -> supplier.getProducts().stream()).max(Comparator.comparing(Product::getPrice));
    }

    public List<Supplier> findTopSuppliersParallel(List<Supplier> suppliers, int topN) {
        
        return suppliers.parallelStream().sorted(Comparator.comparing(Supplier::getRating)).limit(topN).toList();
    }

    public Optional<Product> findCheapestProductForSupplierParallel(List<Supplier> suppliers, String supplierName) {
        return suppliers.parallelStream().filter(supplier -> supplier.getName().matches(supplierName)).flatMap(supplier -> supplier.getProducts().stream()).min(Comparator.comparing(Product::getPrice));
    }

    public Supplier findSupplierWithMostProducts(List<Supplier> suppliers) {
        return suppliers.stream().max(Comparator.comparing((Supplier supplier) -> supplier.getProducts().size())).orElse(null);
    }

    public Supplier findSupplierWithLeastExpensiveProduct(List<Supplier> suppliers) {
        return suppliers.stream().min((supplier1, supplier2) -> {
            Product product1 = supplier1.getProducts().stream().min(Comparator.comparing(Product::getPrice)).orElse(new Product("null", 10, 10.10));
            Product product2 = supplier2.getProducts().stream().min(Comparator.comparing(Product::getPrice)).orElse(new Product("null", 11, 11));
            return Double.compare(product1.getPrice(), product2.getPrice());
        }).orElse(null);
    }

    public Supplier findSupplierWithFastestProduct(List<Supplier> suppliers) {
        return suppliers.stream().min((s1, s2) -> {
            Product p1 = s1.getProducts().stream().min(Comparator.comparing(Product::getLeadTime)).orElse(new Product("null", 0, 0));
            Product p2 = s2.getProducts().stream().min(Comparator.comparing(Product::getLeadTime)).orElse(new Product("null", 0, 0));
            return Integer.compare(p1.getLeadTime(), p2.getLeadTime());
        }).orElse(null);
    }
}
