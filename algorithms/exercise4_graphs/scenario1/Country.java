package algorithms.exercise4_graphs.scenario1;

import java.util.LinkedList;

// Problem 5
public class Country {
    LinkedList<City> cities;

    public Country() {
        cities = new LinkedList<>();
    }

    public LinkedList<City> getCities() {
        return cities;
    }
}
