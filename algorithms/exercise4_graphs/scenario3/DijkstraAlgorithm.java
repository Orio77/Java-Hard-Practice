package algorithms.exercise4_graphs.scenario3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    Network graph;

    public DijkstraAlgorithm(Network network) {
        graph = network;
    }

    public String execute(Router source, Router destination) {
        HashSet<Router> visited = new HashSet<>();
        HashMap<Router, Integer> costs = new HashMap<>();
        PriorityQueue<Router> pQueue = new PriorityQueue<>(Comparator.comparing(router -> costs.get(router)));
        HashMap<Router, Router> previous = new HashMap<>();

        for (Router router : graph.getRouters()) {
            costs.put(router, Integer.MAX_VALUE);
        }
        costs.replace(source, 0);
        pQueue.add(source);

        while (!pQueue.isEmpty()) {
            Router currentRouter = pQueue.poll();
            
            if (visited.contains(currentRouter))
                continue;

            visited.add(currentRouter);

            for (Connection connection : graph.getConnections(currentRouter)) {
                Router connectedRouter = connection.getRouter2();
                int currentCost = costs.get(connectedRouter);
                int tentativeCost = costs.get(currentRouter) + connection.getConstructionCost();

                if (tentativeCost < currentCost) {
                    costs.replace(connectedRouter, tentativeCost);
                    previous.put(connectedRouter, currentRouter);
                }

                if (!pQueue.contains(connectedRouter))
                    pQueue.add(connectedRouter);
            }
        } 

        String path = "";
        Router tempRouter = destination;
        if (!costs.containsKey(destination))
            return path;

        while (!previous.get(tempRouter).equals(source)) {
            path = path.concat(" -> " + tempRouter.getName());
            tempRouter = previous.get(tempRouter);
        }
        return path;
    }
}