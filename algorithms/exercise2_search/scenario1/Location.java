package algorithms.exercise2_search.scenario1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Location {
    private String name;
    ArrayList<GasStation> nearbyGasStations;
    LinkedList<Location> nearbyLocations;

    public String getName() {
        return name;
    }
    public LinkedList<Location> getNearbyLocations() {
        return nearbyLocations;
    }



    public Location findLocation(String name, int startIndex, int endIndex) {
        int midIndex = startIndex + (startIndex - endIndex) / 2;

        if (name.matches(nearbyLocations.get(midIndex).getName())) {
            return nearbyLocations.get(midIndex);
        }

        Location left = null;
        Location right = null;

        if (name.compareTo(nearbyLocations.get(midIndex).getName()) > 0)
            left = findLocation(name, midIndex + 1, endIndex);
        if (name.compareTo(nearbyLocations.get(midIndex).getName()) < 0)
            right = findLocation(name, startIndex, midIndex - 1);
            

        if (left.getName().matches(name))
            return left;
        else if (right.getName().matches(name))
            return right;
        else
            return null;
    }
}