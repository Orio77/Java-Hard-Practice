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
