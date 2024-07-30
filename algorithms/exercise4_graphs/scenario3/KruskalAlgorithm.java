package algorithms.exercise4_graphs.scenario3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class KruskalAlgorithm {
    Network graph;

    public KruskalAlgorithm(Network network) {
        graph = network;
    }

    public void execute() {

        ArrayList<Connection> mst = new ArrayList<>();

        // Add all edges and sort them by weights
        ArrayList<Connection> edges = new ArrayList<>();
        for (Router router : graph.getRouters()) {
            edges.addAll(router.getConnections());
        }
        edges.sort(Comparator.comparing(edge -> edge.getConstructionCost()));

        // Create map to store a parent of each router
        Map<Router, Router> parents = new HashMap<>();
        for (Router router : graph.getRouters()) {
            parents.put(router, router);
        }

        for (Connection edge : edges) {
            Router parent1 = findParent(edge.getRouter1(), parents);
            Router parent2 = findParent(edge.getRouter2(), parents);

            if (parent1 != parent2) {
                mst.add(edge);
                union(parent1, parent2, parents);
            }
        }

    }

    private Router findParent(Router router, Map<Router, Router> parents) {
        if (parents.get(router).equals(router))
            return router;

        return findParent(parents.get(router), parents);
    }

    private void union(Router router1, Router router2, Map<Router, Router> parents) {
        Router parent1 = findParent(router1, parents);
        Router parent2 = findParent(router2, parents);

        parents.replace(parent2, parent1);
    }
}