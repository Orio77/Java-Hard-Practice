package dataStructures.exercise10_graphs.scenario2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MapAlgorithms {
    Map graph;

    public MapAlgorithms(Map map) {
        graph = map;
    }

    public void executeDijkstra(Location startLocation) {
        HashMap<Location, Integer> distances = new HashMap<>();
        PriorityQueue<Location> pQueue = new PriorityQueue<>(Comparator.comparing(l -> distances.get(l)));

        for (Location location : graph.getLocations()) {
            distances.put(location, Integer.MAX_VALUE);
        }
        distances.replace(startLocation, 0);
        pQueue.add(startLocation);

        while (!pQueue.isEmpty()) {
            Location currentLocation = pQueue.poll();

            for (Road road : currentLocation.getConnectedRoads()) {
                Location destination = road.getEndLocation();
                int tentativeDistance = distances.get(currentLocation) + road.getDistance();
                int currentDistance = distances.get(destination);

                if (tentativeDistance < currentDistance) {
                    distances.replace(destination, tentativeDistance);

                }
                if (!pQueue.contains(destination))
                    pQueue.add(destination);
            }
        }
    }

    // AI help: I created a code with no parent tracking
    public boolean hasCycle() {
        HashSet<Location> visited = new HashSet<>();
        return DFSProcedure(graph.getLocations().get(0), visited, null);
    }

    private boolean DFSProcedure(Location location, HashSet<Location> visited, Location parent) {

        if (visited.contains(location)) 
            return true;
        else {
            visited.add(location);
            for (Road road : location.getConnectedRoads()) {
                if (road.getEndLocation() != parent) {
                    if (DFSProcedure(road.getEndLocation(), visited, location));
                    return true;
                }
            }
        }
        return false;
    }
}


/*package dataStructures.exercise10_graphs.scenario2;

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


package dataStructures.exercise10_graphs.scenario2;

public class Road {
    Location startLocation;
    Location endLocation;
    int distance;

    public Road(Location start, Location end, int distance) {
        startLocation = start;
        endLocation = end;
        this.distance = distance;
    }
    public int getDistance() {
        return distance;
    }
    public Location getEndLocation() {
        return endLocation;
    }
    public Location getStartLocation() {
        return startLocation;
    }
}


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

    public boolean hasCycle() { // or network as argument?
        // TODO cycle detection method
        return false;
    }
}
*/