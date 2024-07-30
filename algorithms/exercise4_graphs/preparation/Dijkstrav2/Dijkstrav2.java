package algorithms.exercise4_graphs.preparation.Dijkstrav2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstrav2 {
    private ArrayList<LinkedList<Node>> graph;
    private PriorityQueue<Node> pQueue;
    private HashMap<Integer, Integer> visited;

    public Dijkstrav2() {
        graph = new ArrayList<>();
        pQueue = new PriorityQueue<>();
        visited = new HashMap<>();
    }

    public void Dijkstra(Node source) {
        for (LinkedList<Node> nodes : graph) {
            for (Node node : nodes) {
                pQueue.add(node);
            }
        }

        source.setDistance(0);

        while (!pQueue.isEmpty()) {
            Node currNode = pQueue.poll();
            visited.put(currNode.getId(), currNode.getDistance());

            for (Node node : currNode.getAdjacentNodes()) {
                int weight = node.getDistance();
                // This line is incorrect. It should be the weight of the edge between currNode and node, not node's distance.
                @SuppressWarnings("unused")
                int newDistance = visited.get(currNode.getId() + weight);

                // This line is incorrect. It should compare newDistance with node's current distance, not with weight.
                if (visited.get(node.getId()) > weight) {
                    // This line is incorrect. It should update node's distance to newDistance, not weight.
                    visited.replace(node.getId(), weight);
                }
            }
        }
    }
}
