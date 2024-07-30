package streamAPI.exercise20_usefulPrograms.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class EmployeeService {
    
    public Map<String, List<Employee>> findTopPaidEmployeesByDepartment(List<Employee> employees, int topN) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream().map(es -> {
            List<Employee> emps = es.getValue().stream().sorted(Comparator.comparing(Employee::getSalary)).limit(topN).toList();

            return Map.entry(es.getKey(), emps);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public double findAverageSalaryByAgeRange(List<Employee> employees, int lowerAge, int upperAge) {
        return employees.stream().filter(emp -> emp.getAge() > lowerAge && emp.getAge() < upperAge).collect(Collectors.averagingDouble(Employee::getSalary));
    }
}

class ProductService {
    public Map<String, Product> groupByCategoryAndFindMostExpensiveProduct(List<Product> products) {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory)).entrySet().stream().map(es -> {
            Product mostExpensive = es.getValue().stream().max(Comparator.comparing(Product::getPrice)).orElse(null);

            return Map.entry(es.getKey(), mostExpensive);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Double> calculateAverageRatingByCategory(List<Product> products) {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getRating)));
    }
}

class NumberService {

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i*i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findSquareOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).map(n -> n*n).sorted(Comparator.reverseOrder()).toList();
    }

    public List<Integer> findCubeOfPrimeNumbers(List<Integer> numbers) {
        return numbers.stream().filter(this::isPrime).map(n -> n*n*n).toList();
    }
}

class UrlService {
    public List<String> filterValidUrls(List<String> urls) {
        return urls.stream().filter(url -> url != null && !url.isBlank() && url.startsWith("http://") || url.startsWith("https://")).toList();
    }

    public List<String> findDomainNames(List<String> urls) {
        return urls.stream().map(url -> {
            int start = url.indexOf("://") + 3;
            int end = url.indexOf('/', start);
            if (end == -1) {
                end = url.length();
            }
            return url.substring(start, end);
        }).toList();
    }

    public Map<String, Long> countUrlsByDomain(List<String> urls) {
        return findDomainNames(urls).stream().collect(Collectors.groupingBy(domain -> domain, Collectors.counting()));
    }
}
