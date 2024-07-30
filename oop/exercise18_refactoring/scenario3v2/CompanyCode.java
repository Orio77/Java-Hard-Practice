package oop.exercise18_refactoring.scenario3v2;

import java.util.*;

class Employee {
    private String employeeId;
    private String department;
    private double salary;
    private List<String> tasks;

    public Employee(String employeeId, String department, double salary) {
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        tasks = new ArrayList<>();
    }

    public boolean assignTask(String task) { 
        return tasks.add(task); 
    }
    public boolean completeTask(String task) { 
        return tasks.remove(task); 
    }
    public List<String> getTasks() { 
        return Collections.unmodifiableList(tasks); 
    }

    public String getDepartment() {
        return department;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public double getSalary() {
        return salary;
    }
    public void setDepartment(String department) {
        this.department = Objects.requireNonNull(department);
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = Objects.requireNonNull(employeeId);
    }
    public void setSalary(double salary) {
        if (salary >= 0)
            this.salary = salary;
    }
}

class Department {
    private String departmentName;
    private Map<String, Employee> employees;

    public Department(String name) {
        departmentName = name;
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) { 
        if (employee == null)
            return;
        employees.put(employee.getEmployeeId(), employee); 
    }
    public void removeEmployee(String employeeId) { 
        employees.remove(employeeId); 
    }
    public Employee getEmployee(String employeeId) { 
        return employees.get(employeeId); 
    }
    public Map<String, Employee> getAllEmployees() { 
        return Collections.unmodifiableMap(employees); 
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

class Company {
    private Map<String, Department> departments;

    public Company() {
        departments = new HashMap<>();
    }

    public void addDepartment(Department department) { 
        if (department == null)
            return;
        departments.put(department.getDepartmentName(), department); 
    }
    public Department getDepartment(String departmentName) { 
        return departments.get(departmentName); 
    }
    public void addEmployeeToDepartment(String departmentName, Employee employee) {
        if (departmentName.matches("") || employee == null)
            return;
        
        departments.get(departmentName).addEmployee(employee);
    }
}

public class CompanyCode {
    public static void main(String[] args) {
        Company company = new Company();
        Department sales = new Department("Sales");
        company.addDepartment(sales);

        Employee employee = new Employee("emp-123", "Sales", 50000);
        company.addEmployeeToDepartment("Sales", employee);

        employee.assignTask("Prepare monthly sales report");
        System.out.println(company.getDepartment("Sales").getEmployee("emp-123").getTasks());
    }
}

