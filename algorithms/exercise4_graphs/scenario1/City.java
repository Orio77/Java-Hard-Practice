package algorithms.exercise4_graphs.scenario1;

import java.util.LinkedList;

public class City {
    LinkedList<Road> roads;
    String name;
    int id;
    int distance;

    public City(String name) {
        this.name = name;
        id = name.hashCode();
        roads = new LinkedList<>();
        this.distance = Integer.MAX_VALUE;
    }
    public int getDistance() {
        return distance;
    }
    public LinkedList<Road> getRoads() {
        return roads;
    }
    
}
