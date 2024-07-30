package algorithms.exercise4_graphs.preparation.Dijkstrav2;

import java.util.LinkedList;

public class Node implements Comparable<Node>{
    private String name;
    private int id;
    private int distance;
    private LinkedList<Node> adjacentNodes;

    public Node(String name) {
        this.name = name;
        id = name.hashCode();
        distance = Integer.MAX_VALUE;
        adjacentNodes = new LinkedList<>();
    }

    public int getId() {
        return id;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public LinkedList<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    @Override
    public int compareTo(Node node) {
        return this.distance - node.getDistance();
    }

    public String getName() {
        return name;
    }
}
