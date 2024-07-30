package algorithms.exercise2_search.scenario1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class RoadNetwork {
    ArrayList<LinkedList<Location>> roads;
    


    // get starting points nearbyLocations
    // Check if any of them is the target, while adding them to the queue
    // if one of them matched the location, add it to list and return
    // if none of them matched the location, add the first one in the queue to the list 
    // get nearby Locations of the chosen one
    // if it's empty, return, while removing it from the list
    public ArrayList<Location> getRoute(Location startingPoint, Location target) {

        if (startingPoint == null || target == null)
            return null;

        LinkedList<Location> queue = new LinkedList<>();   
        HashSet<Location> visited = new HashSet<>(); 
        ArrayList<Location> path = new ArrayList<>();
        path.add(startingPoint);
        visited.add(startingPoint);

        if (startingPoint.equals(target)) 
            return path;

        for (Location loc : startingPoint.getNearbyLocations()) {
            if (!visited.contains(loc))
                queue.push(loc);
            if (!queue.isEmpty() && queue.peek().equals(target)) {
                path.add(queue.poll());
                return path;
            }
        }

        path.add(queue.peek());
        visited.add(queue.peek());

        ArrayList<Location> potentialPath = getRoute(queue.poll(), target);
        if (potentialPath != null && !potentialPath.isEmpty())
            if (potentialPath.get(potentialPath.size() - 1).equals(target))
                path.addAll(potentialPath);
            else 
                path.clear();

        if (path.get(path.size() - 1).equals(target))
            return path;
                
        return null;
    }
    // Little AI Help with recursion
}
