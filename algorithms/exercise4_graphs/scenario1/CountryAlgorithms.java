package algorithms.exercise4_graphs.scenario1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class CountryAlgorithms {
    Country graph;

    public CountryAlgorithms(Country country) {
        graph = country;
    }

    public HashMap<City, Integer> executeDijkstra(City startCity) {
        HashMap<City, Integer> distances = new HashMap<>();
        PriorityQueue<City> pQueue = new PriorityQueue<>(Comparator.comparing(city -> distances.get(city)));
        HashSet<City> visited = new HashSet<>();

        for (City city : graph.getCities()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.replace(startCity, 0);

        while (!pQueue.isEmpty()) {
            City currentCity = pQueue.poll();

            if (visited.contains(currentCity)) {
                continue;
            }
            visited.add(currentCity);

            for (Road road : currentCity.getRoads()) {
                City nearbyCity = road.getCity2();
                int currentDistance = distances.get(nearbyCity);
                int tentativeDistance = distances.get(currentCity) + road.getDistance();

                if (tentativeDistance < currentDistance) {
                    distances.replace(nearbyCity, tentativeDistance);
                }

                if (!pQueue.contains(nearbyCity))
                    pQueue.add(nearbyCity);
            }
        }
        return distances;
    }



    public void executeKruskal() {

        ArrayList<Road> mst = new ArrayList<>();
        ArrayList<Road> roads = new ArrayList<>();

        for (City city : graph.getCities()) {
            for (Road road : city.getRoads()) {
                roads.add(road);
            }
        }

        // PriorityQueue<Road> pQueue = new PriorityQueue<>(Comparator.comparing(road -> road.getDistance()));
        roads.sort(Comparator.comparing(road -> road.getDistance()));
        HashMap<City, City> parents = new HashMap<>();

        for (City city : graph.getCities()) {
            parents.put(city, city);
        }

        for (Road road : roads) {
            City parent1 = find(road.getCity1(), parents);
            City parent2 = find(road.getCity2(), parents);

            if (parent1 != parent2) {
                mst.add(road);
                union(parent1, parent2, parents);
            }
        }

    }   

    private City find(City city, HashMap<City, City> parents) {
        if (parents.get(city).equals(city))
            return city;

        return find(parents.get(city), parents);
    }

    private void union(City city1, City city2, HashMap<City, City> parents) {
        City parent1 = find(city1, parents);
        City parent2 = find(city2, parents);
        
        parents.replace(parent2, parent1);
    }

    // AI Guided (with pseudo-code as instruction)
    public Map<City, LinkedList<Road>> executeDFS(City startCity) {
        Stack<City> cityStack = new Stack<>();
        Set<City> visited = new HashSet<>();
        Map<City, LinkedList<Road>> cityRoads = new HashMap<>();

        cityStack.push(startCity);

        while (!cityStack.isEmpty()) {
            City currentCity = cityStack.pop();

            if (visited.contains(currentCity))
                continue;

            visited.add(currentCity);

            for (Road road : currentCity.getRoads()) {
                City nearbyCity = road.getCity2();
                if (!visited.contains(nearbyCity)) {
                    cityStack.push(nearbyCity);
                    cityRoads.putIfAbsent(nearbyCity, new LinkedList<>());
                    cityRoads.get(nearbyCity).add(road);
                }
            }
        }
        return cityRoads;
    }
}
