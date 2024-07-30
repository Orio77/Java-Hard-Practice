package dataStructures.exercise11_advancedDS.scenario1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
// AI Generated (manually coded, but still)
public class QuadTreeAlgorithms {
    private QuadTree quadTree;
    private Set<Node> settledNodes;
    private Set<Node> unsettledNodes;
    private Map<Node, Node> predecessors;
    private Map<Node, Double> distance;
    
    public QuadTreeAlgorithms(QuadTree quadTree) {
        this.quadTree = quadTree;
    }
    public QuadTree getQuadTree() {
        return quadTree;
    }

    public void executeDijkstra(Node source) {
        settledNodes = new HashSet<>();
        unsettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0.0);
        unsettledNodes.add(source);
        while (unsettledNodes.size() > 0) {
            Node node = getMinimum(unsettledNodes);
            settledNodes.add(node);
            unsettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Node node) {
        List<Node> adjacentNodes = getChildren(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unsettledNodes.add(target);
            }   
        }
    }

    private double getDistance(Node node, Node target) {
        Location point1 = node.getPoint();
        Location point2 = target.getPoint();
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }

    private List<Node> getChildren(Node node) {
        return Arrays.asList(node.getNorthWest(), node.getNorthEast(), node.getSouthWest(), node.getSouthEast());
    }

    private Node getMinimum(Set<Node> nodes) {
        Node minimum = null;
        for (Node node : nodes) {
            if (minimum == null) {
                minimum = node;
            }
            else {
                if (getShortestDistance(node) < getShortestDistance(minimum)) {
                    minimum = node;
                }
            }
        }
        return minimum;
    }

    private double getShortestDistance(Node destination) {
        Double d = distance.get(destination);
        if (d == null)
            return Double.MAX_VALUE;
        else 
            return d;
    }






    public void reduceEdgeWeights(double factor) {
        for (Node node : distance.keySet()) {
            distance.put(node, distance.get(node) / factor);
        }
    }
    public void reduceNodes() {
        Set<Node> toRemove = new HashSet<>();
        for (Node node : distance.keySet()) {
            if (!predecessors.containsKey(node) && !settledNodes.contains(node)) {
                toRemove.add(node);
            }
        }
        for (Node node : toRemove)
            distance.remove(node);
    }
}

/*package dataStructures.exercise11_advancedDS.scenario1;

public class QuadTree {
    Node root;
    int capacity;

    public QuadTree(BoundingBox box, int capacity) {
        root =  new Node(box);
        this.capacity = capacity;
    }

    public void insert(Location point) {
        insert(root, point);
    }

    private void insert(Node node, Location point) {

        if (!node.getBox().contains(point))
            return;


        if (node.isLeaf()) {
            if (node.getPoint() == null) {
                node.setPoint(point);
            }
            else {
                node.subDivide();

                insert(node.getNorthWest(), node.getPoint());
                insert(node.getNorthEast(), node.getPoint());
                insert(node.getSouthWest(), node.getPoint());
                insert(node.getSouthEast(), node.getPoint());

                node.setPoint(null);

                insert(node.getNorthEast(), point);
                insert(node.getNorthEast(), point);
                insert(node.getSouthWest(), point);
                insert(node.getNorthEast(), point);
            }
        }
        else {
            insert(node.getNorthEast(), point);
            insert(node.getNorthEast(), point);
            insert(node.getSouthWest(), point);
            insert(node.getNorthEast(), point);
        }

    }
}


package dataStructures.exercise11_advancedDS.scenario1;

public class Node {
    BoundingBox box;
    Node northWest;
    Node northEast;
    Node southWest;
    Node southEast;
    Location point;

    public Node(BoundingBox box) {
        this.box = box;
        northWest = null;
        northEast = null;
        southWest = null;
        southEast = null;
        point = null;
    }
    public BoundingBox getBox() {
        return box;
    }

    public boolean isLeaf() {
        return (northWest == null && northEast == null && southWest == null && southEast == null);
    }

    public void subDivide() {
        double midX = (box.getMinX() + box.getMaxX()) / 2;
        double midY = (box.getMinY() + box.getMaxY()) / 2;

        northWest = new Node(new BoundingBox(box.getMinX(), box.getMinY(), midX, midY));
        northEast = new Node(new BoundingBox(midX, box.getMinY(), box.getMaxX(), midY));
        southWest = new Node(new BoundingBox(box.getMinX(), midY, midX, box.getMaxY()));
        northEast = new Node(new BoundingBox(midX, midY, box.getMaxX(), box.getMaxY()));
    }

    public Location getPoint() {
        return point;
    }
    public void setPoint(Location point) {
        this.point = point;
    }
    public Node getNorthEast() {
        return northEast;
    }
    public Node getNorthWest() {
        return northWest;
    }
    public Node getSouthEast() {
        return southEast;
    }
    public Node getSouthWest() {
        return southWest;
    }
    public void setBox(BoundingBox box) {
        this.box = box;
    }
    public void setNorthEast(Node northEast) {
        this.northEast = northEast;
    }
    public void setNorthWest(Node northWest) {
        this.northWest = northWest;
    }
    public void setSouthEast(Node southEast) {
        this.southEast = southEast;
    }
}


package dataStructures.exercise11_advancedDS.scenario1;

// Problem 6
public class Location {
    double x;
    double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}


package dataStructures.exercise11_advancedDS.scenario1;

public class BoundingBox {
    double minX;
    double minY;
    double maxX;
    double maxY;

    
    public BoundingBox(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    public double getMaxX() {
        return maxX;
    }
    public double getMaxY() {
        return maxY;
    }
    public double getMinX() {
        return minX;
    }
    public double getMinY() {
        return minY;
    }

    public boolean contains(Location point) {
        return (point.getX() > minX && point.getX() < maxX && point.getY() > minY && point.getY() < maxY);
    }

    public boolean insertSects(BoundingBox otherBox) {
        return (this.maxX >= otherBox.getMinX() && this.minX <= otherBox.getMaxX() && this.maxY >= otherBox.getMinY() && this.minY <= otherBox.getMaxY());
    }
}
*/
