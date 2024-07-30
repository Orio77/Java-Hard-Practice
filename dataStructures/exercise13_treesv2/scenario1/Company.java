package dataStructures.exercise13_treesv2.scenario1;

import java.util.ArrayList;

public class Company {
    ArrayList<Department> departments;

    public Company() {
        departments = new ArrayList<>();
    }

    public void removeEmployee(int ID) {
        for (Department department : departments) {
            for (Employee employee : department.getEmployees()) {
                removeEmployeeHelper(ID, employee);
            }
        }
    }

    private void removeEmployeeHelper(int ID, Employee employee) {

        if (employee.getID() == ID) {
            employee.getEmployer().getWorkers().remove(employee);
            return;
        }

        if (employee.getWorkers() != null) {
            for (Employee worker : employee.getWorkers()) {
                removeEmployeeHelper(ID, worker);
            }
        }
    }

    public Employee getEmployee(int ID) {
        for (Department department : departments) {
            for (Employee employee : department.getEmployees()) {
                Employee result = getEmployeeHelper(ID, employee);
                if (result != null)
                    return result;
            }
        }
        return null;
    }

    private Employee getEmployeeHelper(int ID, Employee employee) {

        if (employee.getID() == ID) {
            return employee;
        }

        if (employee.getWorkers() != null) {
            for (Employee worker : employee.getWorkers()) {
                Employee result = getEmployeeHelper(ID, worker);
                if (result != null)
                    return result;
            }
        }
        return null;
    }

    public void showAllContents() {
        for (Department department : departments) {
            System.out.println(department);
            for (Employee employee : department.getEmployees()) {
                department.printEmployees(employee);
            }
        }
    }

    public void simulateCompany(int numberOfDepartments, int numberOfEmployees) {
        for (int i = 0; i < numberOfDepartments; i++) {
            departments.add(new Department("department" + i));
        }
        Employee temp;
        for (Department dep : departments) {
            for (int i = 0; i < numberOfEmployees; i++) {
                temp = new Employee("Employee" + i);
                for (int j = 0; j < Math.random() * 10; j++) {
                    temp.addEmployee(new Employee("Worker" + i));
                }
                dep.addEmployee(temp);
            }
        }
    }
}
