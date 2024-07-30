package oop.exercise15_designPrinciples.scenario3;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee implements SearchStrategy{
    private List<Employee> employees;

    public Manager(String name, String position) {
        super(name, position);
        employees = new ArrayList<>();
    }

    @Override
    public Employee search(List<Employee> employees, String term, String data) {
        switch (term.toLowerCase()) {
            case "id":
                for (Employee employee : employees) {
                    if (Integer.toString(employee.getID()).matches(data)) {
                        return employee;
                    }
                }
                break;
            case "name":
                for (Employee employee : employees) {
                    if (employee.getName().matches(data)) {
                        return employee;
                    }
                }
            default:
                return null;
        }
        return null;
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }
}
