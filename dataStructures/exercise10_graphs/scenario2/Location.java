package dataStructures.exercise10_graphs.scenario2;

import java.util.LinkedList;

public class Location {
    LinkedList<Road> connectedRoads;
    String name;

    public Location(String name) {
        this.name = name;
        connectedRoads = new LinkedList<>();
    }
    public LinkedList<Road> getConnectedRoads() {
        return connectedRoads;
    }
    public String getName() {
        return name;
    }

    public void addRoad(Location endLocation, int distance) {
        Road newRoad = new Road(this, endLocation, distance);
        this.getConnectedRoads().add(newRoad);
        endLocation.getConnectedRoads().add(newRoad);
    }
}
