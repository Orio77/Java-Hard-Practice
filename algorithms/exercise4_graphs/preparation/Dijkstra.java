package algorithms.exercise4_graphs.preparation;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    // AI generated steps
    // Step 1: Create a class for the graph with a LinkedList and a priority queue
    // LinkedList will be used to store the vertices and their adjacent vertices
    // PriorityQueue will be used to select the vertex with the minimum distance at each step

    // Step 2: Create a class for the vertices with properties for the vertex id, distance from the source, and a list of adjacent vertices

    // Step 3: Initialize the graph with the vertices and their adjacent vertices

    // Step 4: Implement Dijkstra's algorithm
    // Set the distance from the source to itself as 0
    // Set the distance from the source to all other vertices as infinity
    // Add all vertices to the priority queue

    // Step 5: While the priority queue is not empty, do the following:
    // Remove the vertex with the minimum distance from the priority queue
    // For each adjacent vertex, calculate the distance through the current vertex
    // If the calculated distance is less than the known distance, update the distance

    // Step 6: After the algorithm has been run, the shortest distance from the source to all other vertices will be known


    class Graph {
        LinkedList<Vertex> graph;
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparing(V -> V.getDistance()));

        public void addVertex(Vertex V, LinkedList<Edge> neighbours) {
            if (!graph.contains(V)) {
                V.addNeighbours(neighbours);
                graph.add(V);
            }
            else {
                System.out.println("Vertex already included in the graph");
            }
        } 

        public void Dijkstra(Vertex source) {
            source.setDistance(0);
            queue.addAll(graph);

            while (!queue.isEmpty()) {
                Vertex currVertex = queue.poll();
                for (Edge edge : currVertex.getNeighbours()) {
                    Vertex currNeighbour = edge.getV2();
                    int minDistance = currVertex.getDistance() + edge.getWeight();
                    if (minDistance < currNeighbour.getDistance()) {
                        currNeighbour.setDistance(minDistance);
                        currNeighbour.setPrevious(currVertex);
                        queue.remove(currNeighbour);
                        queue.add(currNeighbour);
                    }
                }
            }
        }
        // public LinkedList<Vertex> getShortestPath(Vertex target) {

        // }
    }

    class Vertex {
        LinkedList<Edge> neighbours;
        Vertex previous;
        int distance;
        String name;
        int id;

        public Vertex(String name) {
            this.name = name;
            this.distance = Integer.MAX_VALUE;
            id = name.hashCode();
            neighbours = new LinkedList<>();
        }
        public void setPrevious(Vertex previous) {
            this.previous = previous;
        }
        public LinkedList<Edge> getNeighbours() {
            return neighbours;
        }
        public int getDistance() {
            return distance;
        }
        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void addNeighbours(LinkedList<Edge> neighbours) {
            for (Edge edge : neighbours) {
                this.neighbours.add(edge);
            }
        }

        public Edge addEdge(Vertex V1, Vertex V2, int weight) {
            return new Edge(V1, V2, weight);
        }
    }

    class Edge {
        Vertex V1;
        Vertex V2;
        int weight;

        public Edge(Vertex V1, Vertex V2, int weight) {
            this.V1 = V1;
            this.V2 = V2;
            setWeight(weight);
        }
        public Vertex getV2() {
            return V2;
        }
        public Vertex getV1() {
            return V1;
        }
        public void setWeight(int weight) {
            if (weight > 0) {
                this.weight = weight;
            }
            else
                System.out.println("Edges can not have negative values");
        }
        public int getWeight() {
            return weight;
        }
    }
}