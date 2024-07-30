package dataStructures.exercise10_graphs.scenario3;

import java.util.HashMap;
import java.util.PriorityQueue;

public class InternetAlgorithms {
    Internet graph;

    public InternetAlgorithms(Internet internet) {
        graph = internet;
    }

    public void executeDijkstra(WebPage source) {
        PriorityQueue<WebPage> pQueue = new PriorityQueue<>();
        HashMap<WebPage, Integer> distances = new HashMap<>();
        HashMap<WebPage, WebPage> previous = new HashMap<>();
        source.setDistance(0);

        pQueue.add(source);

        for (WebPage page : graph.getInternet()) {
            distances.put(page, page.getDistance());
        }

        while (!pQueue.isEmpty()) {
            WebPage current = pQueue.poll();

            for (Link link : current.getLinks()) {
                WebPage neighbor = link.getPage2();
                int tentativeDistance = current.getDistance() + link.getWeight();
                int currentDistance = distances.get(neighbor);

                if (tentativeDistance < currentDistance) {
                    neighbor.setDistance(tentativeDistance);
                    distances.replace(neighbor, tentativeDistance);
                    previous.put(neighbor, current);
                }

                if (!pQueue.contains(neighbor)) {
                    pQueue.add(neighbor);
                }
            }
        }
    }
}