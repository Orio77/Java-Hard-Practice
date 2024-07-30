package streamAPI.exercise1_basics.scenario3;

import java.util.List;

public class Employee {
    private String name;
    private String department;
    private int salary;
    private List<Project> projects;
    
    public String getDepartment() {
        return department;
    }
    public String getName() {
        return name;
    }
    public List<Project> getProjects() {
        return projects;
    }
    public int getSalary() {
        return salary;
    }
}
