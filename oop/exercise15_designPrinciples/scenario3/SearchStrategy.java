package oop.exercise15_designPrinciples.scenario3;

import java.util.List;

public interface SearchStrategy {
    Employee search(List<Employee> employees, String term, String data);
}
