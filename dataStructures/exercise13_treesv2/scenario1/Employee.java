package dataStructures.exercise13_treesv2.scenario1;

import java.util.ArrayList;

public class Employee {
    private String name;
    private int ID;
    private Employee employer;
    private ArrayList<Employee> workers;

    public Employee(String name) {
        this.name = name;
        ID = name.hashCode();
        workers = new ArrayList<>();
    }

    public Employee getEmployer() {
        return employer;
    }

    public void setEmployer(Employee employer) {
        this.employer = employer;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<Employee> getWorkers() {
        return workers;
    }

    public void addEmployee(Employee employee) {
        workers.add(employee);
        employee.setEmployer(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
