package dataStructures.exercise10_graphs.scenario2;

import java.util.LinkedList;

// PROBLEM 2
public class Map {
    LinkedList<Location> locations;

    public LinkedList<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void addRoad(Location startLocation, Location endLocation, int distance) {
        Road newRoad = new Road(startLocation, endLocation, distance);
        startLocation.getConnectedRoads().add(newRoad);
        endLocation.getConnectedRoads().add(newRoad);
    }

}
