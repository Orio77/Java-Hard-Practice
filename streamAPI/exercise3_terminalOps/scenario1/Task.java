package streamAPI.exercise3_terminalOps.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task {
    private List<Customer> customers;

    public List<Customer> getActiveCustomers() {
        return customers.stream().filter(c -> c.isActive()).toList();
    }

    public List<Customer> getActiveNorthCustomers() {
        return getActiveCustomers().stream().filter(c -> c.getRegion().matches("North")).toList();
    }

    public void sortActiveNorthByName() {
        getActiveNorthCustomers().sort(Comparator.comparing(c -> c.getName()));
    }

    public Map<Integer, String> mapNorthCustomers() {
        List<Customer> desiredCustomers = getActiveNorthCustomers();
        sortActiveNorthByName();

        return desiredCustomers.stream().collect(Collectors.toMap(c -> c.getId(), c -> c.getName()));
    }

    public Customer findLongestNameCustomer() {
        return getActiveNorthCustomers().stream().max(Comparator.comparing(c -> c.getName().length())).orElse(null);
    }

    public double calculateAverageNameLength() {
        return getActiveNorthCustomers().stream().map(c -> c.getName()).mapToInt(n -> n.length()).average().orElse(0);
    }

}
