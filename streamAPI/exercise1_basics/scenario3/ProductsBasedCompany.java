package streamAPI.exercise1_basics.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductsBasedCompany {
    

    public List<Customer> getTopSpendingCustomers(List<Customer> customers, int n) {
        return customers.stream().sorted(Comparator.comparing((Customer customer) -> customer.getPurchases().stream().mapToInt(Purchase::getPrice).sum()).reversed()).limit(n).toList();
    }

    public List<String> getPopularProducts(List<Customer> customers, int n) {
        return customers.stream().flatMap(customer -> customer.getPurchases().stream()).map(purchase -> purchase.getProduct()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).map(Map.Entry::getKey).toList();
    }

    public List<Employee> getTopPaidEmployees(List<Employee> employees, int n) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary)).limit(n).toList();
    }

    public List<Project> getMostTimeConsumingProjects(List<Employee> employees, int n) {
        return employees.stream().flatMap(employee -> employee.getProjects().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(Project::getHoursWorked))).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).limit(n).toList();
    }

    public List<Student> getTopGradedStudents(List<Student> students, int n) {
        return students.stream().sorted(Comparator.comparing(Student::getGrade)).limit(n).toList();
    }

    public List<Course> getHighestScoringCourses(List<Student> students, int n) {
        return students.stream().flatMap(student -> student.getCourses().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(Course::getScore))).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toList();
    }

    public List<Product> getTopSellingProducts(List<Product> products, int n) {
        return products.stream().sorted(Comparator.comparing(Product::getSales)).limit(n).toList();
    }

    public List<Product> getMostExpensiveProducts(List<Product> products, int n) {
        return products.stream().sorted(Comparator.comparing(Product::getPrice)).limit(n).toList();
    }

    public List<String> getPopularCategories(List<Product> products, int n) {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toList();
    }
}
