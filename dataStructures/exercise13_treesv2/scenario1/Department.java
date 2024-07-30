package dataStructures.exercise13_treesv2.scenario1;

import java.util.ArrayList;

public class Department {
    ArrayList<Employee> employees;
    String name;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void printEmployees(Employee employee) {
        if (employee == null)
            return;

        if (employee.getWorkers() != null){
            for (Employee worker : employee.getWorkers()) {
                System.out.println(worker);
                printEmployees(worker);
            }
        }
        else
            return;
    }
}
