package dataStructures.exercise8_debugging.scenario3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

// Create class Road as an Edge
/*
 * Create a graph Array List of Linked Lists
 * ArrayList(City)<LinkedList<Road>>
 * Create recursive BFS
 * Add locks
 */

class Road {
    private String city1;
    private String city2;
    private double distance;

    public Road(String city1, String city2, double distance) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
    }
    public String getCity1() {
        return city1;
    }
    public String getCity2() {
        return city2;
    }
    public double getDistance() {
        return distance;
    }
 }

class RoadNetworkGraph {
    private ArrayList<LinkedList<Road>> graph; 
    private ArrayList<String> cities;

    
    public RoadNetworkGraph() {
        graph = new ArrayList<>();
        cities = new ArrayList<>();
    }

    
    public synchronized void addRoad(String city1, String city2, double distance) {
        Road road = new Road(city1, city2, 0);
        int index0 = 0;
        int index2 = 0;
        // Additional logic for checking if index 0 is either of the cities would be added here
        // I was short on time
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).matches(city1)) {
                index0 = i;
            }
            if (cities.get(i).matches(city2)) {
                index2 = i;
            }
        }
        boolean added = false;

        if (index0 != 0) {
            graph.get(index0).add(road);
        }
        else {
            graph.add(new LinkedList<>());
            graph.get(graph.size()).add(road);
            added = true;
        }

        if (index2 != 0) {
            graph.get(index2).add(road);
        }
        else {
            if (!added) {
                graph.add(new LinkedList<>());
                graph.get(graph.size()).add(road);
            }
        }
    }

    // A BFS Algorithm that returns the starting city and the target, if it's present, else it return an empty list
    /*
     * Get city neighbours
     * Add the City to visited set
     * Iterate over the neighbours
     * if a neighbor is the target, add it to the result list and return
     * if a neighbor is not the target, add it to the queue
     * after the for-each iteration is over the neighbors, poll from the queue
     * repeat
     * Do all of the above while the queue is not empty
     */
    public List<String> shortestPath(String city1, String target) {
        // Get the index of a city and it's neighbours
        int index0 = cities.indexOf(city1);
        if (index0 == -1) {
            return new ArrayList<>();
        }

        List<String> resultRoad = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Road> pQueue = new PriorityQueue<>(Comparator.comparing(Road::getDistance));
        Road firstRoad = graph.get(index0).iterator().next();
        pQueue.add(firstRoad);
        visited.add(firstRoad.getCity1());
        int index1 = 0;

        while (!pQueue.isEmpty()) {
            Road nextRoad = pQueue.poll();
            // Update Index
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).matches(nextRoad.getCity1())) {
                    index1 = i;
                }
            }

            if (index1 == index0) {
                return new ArrayList<>();
            }
            index0 = index1;

            for (Road road : graph.get(index0)) {
                if (road.getCity2().matches(target)) {
                    if (!visited.contains(road.getCity2())) {
                        resultRoad.add(road.getCity2());
                    }
                    return resultRoad;
                }
                pQueue.add(road);
            }
        }

        return new ArrayList<>();
    }
}

class BFSRoadNetworkGraph {
    private ArrayList<LinkedList<Road>> graph; 
    private ArrayList<String> cities;
    private ReentrantLock lock;

    
    public BFSRoadNetworkGraph() {
        graph = new ArrayList<>();
        cities = new ArrayList<>();
        lock = new ReentrantLock();
    }

    
    public void addRoad(String city1, String city2) {
        lock.lock();

        try {
            if (!cities.contains(city1)) {
                cities.add(city1);
                graph.add(new LinkedList<>());
            }
            if (!cities.contains(city2)) {
                cities.add(city2);
                graph.add(new LinkedList<>());
            }
    
            Road road = new Road(city1, city2, 0);
            graph.get(cities.indexOf(city1)).add(road);
            graph.get(cities.indexOf(city2)).add(road);
        } finally {
            lock.unlock();
        }

    }

    public List<String> reachableCities(String startCity) {
        List<String> nearbyCities = new ArrayList<>();
        for (Road road : graph.get(cities.indexOf(startCity))) {
            nearbyCities.add(road.getCity2());
        }

        return nearbyCities;
    }
}

// AI Copied
class GPSTrie {
    private TrieNode root;
    private ReentrantLock lock;

    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        } 
    }

    
    public GPSTrie() {
        this.root = new TrieNode();
        this.lock = new ReentrantLock();
    }

    
    public void insert(String city) {
        lock.lock();
        try {
            TrieNode node = root;
            for (char c : city.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEndOfWord = true;
        } finally {
            lock.unlock();
        }
    }

    public List<String> autocomplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return new ArrayList<>();
            }
            node = node.children[c - 'a'];
        }
        return getAllWords(node, prefix);
    }

    private List<String> getAllWords(TrieNode node, String prefix) {
        List<String> words = new ArrayList<>();
        if (node.isEndOfWord) {
            words.add(prefix);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] != null) {
                words.addAll(getAllWords(node.children[c - 'a'], prefix + c));
            }
        }
        return words;
    }
}

// AI Copied
class DijkstraRoadNetworkGraph {
    private Map<String, Map<String, Integer>> graph;
    private ReentrantLock lock;

    
    public DijkstraRoadNetworkGraph() {
        this.graph = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    
    public void addRoad(String city1, String city2, int distance) {
        lock.lock();
        try {
            graph.putIfAbsent(city1, new HashMap<>());
            graph.get(city1).put(city2, distance);
        } finally {
            lock.unlock();
        }
    }

    public List<String> shortestPath(String city1, String city2) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousCities = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparing(distances::get));

        distances.put(city1, 0);
        queue.add(city1);

        while (!queue.isEmpty()) {
            String currentCity = queue.poll();
            if (currentCity.equals(city2)) {
                break;
            }

            for (Map.Entry<String, Integer> entry : graph.get(currentCity).entrySet()) {
                String adjacentCity = entry.getKey();
                int newDistance = distances.get(currentCity) + entry.getValue();

                if (!distances.containsKey(adjacentCity) || newDistance < distances.get(adjacentCity)) {
                    distances.put(adjacentCity, newDistance);
                    previousCities.put(adjacentCity, currentCity);
                    queue.add(adjacentCity);
                }
            }
        }

        List<String> path = new ArrayList<>();
        for (String city = city2; city != null; city = previousCities.get(city)) {
            path.add(0, city);
        }

        return path;
    }

    public String analyzePerformance(String city1, String city2) {
        List<String> path = shortestPath(city1, city2);
        int distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            distance += graph.get(path.get(i)).get(path.get(i + 1));
        }
        return "The shortest path from " + city1 + " to " + city2 + " is " + distance + " units long";
    }
}
