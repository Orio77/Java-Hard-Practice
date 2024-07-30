package streamAPI.exercise6_handlingNulls.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import streamAPI.exercise4_collectors.scenario1.Pair;

public class EmployeeTask {
    private List<Employee> employees;

    public Map<Employee, Integer> getHoursWorked() {
        
        return employees.stream().filter(Objects::nonNull).collect(Collectors.toMap(emp -> emp, emp -> Optional.ofNullable(emp).map(employer -> employer.getHoursWorked()).orElse(0)));
    }

    public Map<Employee, Integer> getProjectsCompleted() {
        return employees.stream().filter(Objects::nonNull).collect(Collectors.toMap(emp -> emp, employer -> Optional.ofNullable(employer.getProjectsCompleted()).orElse(0)));
    }

    public Map<Employee, Double> getPeerReviewScore() {

        return employees.stream().filter(Objects::nonNull).collect(Collectors.toMap(emp -> emp, emp -> Optional.ofNullable(emp.getPeerReviewScore()).orElse(0.0)));
    }

    public Optional<Employee> findHardestWorkingEmployee() {
        return employees.stream().filter(Objects::nonNull).max(Comparator.comparing(emp -> Optional.ofNullable(emp.getHoursWorked()).orElse(0)));
    }

    public Optional<Employee> findMeanestEmployee() {
        return employees.stream().filter(Objects::nonNull).min(Comparator.comparing(emp -> Optional.ofNullable(emp.getPeerReviewScore()).orElse(0.0)));
    }

    public Optional<Employee> findNicestEmployee() {
        return employees.stream().filter(Objects::nonNull).max(Comparator.comparing(emp -> Optional.ofNullable(((Employee) emp).getPeerReviewScore()).orElse(0.0))); 
    }

    public Map<Employee, Pair<Integer, Integer>> getEmployeeHoursAndProjects() {
        
        return employees.stream().filter(Objects::nonNull).collect(Collectors.toMap(emp -> emp, emp -> new Pair<>(emp.getHoursWorked(), emp.getProjectsCompleted())));
    }

    public Optional<Employee> findLeastWorkingEmployee() {
        return employees.stream().filter(Objects::nonNull).min(Comparator.comparing(emp -> Optional.ofNullable(emp.getHoursWorked()).orElse(0)));
    }

}
