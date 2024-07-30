package algorithms.exercise4_graphs.scenario3;

import java.util.LinkedList;

// PROBLEM 4
public class Network {
    LinkedList<Router> routers;

    public void addRouter(Router router) {
        if (!routers.contains(router))
            routers.add(router);
    }

    public void removeRouter(Router router) {
        if (routers.contains(router))
            routers.remove(router);
    }

    public void addConnection(Router router1, Router router2, int constructionCost) {
        router1.getConnections().add(new Connection(router1, router2, constructionCost));
    }

    public void removeConnection(Router router1, Router router2) {
        for (int i = 0; i < router1.getConnections().size(); i++) {
            if (router1.getConnections().get(i).getRouter2().equals(router2))
                router1.getConnections().remove(i);
        }
        for (int i = 0; i < router2.getConnections().size(); i++) {
            if (router2.getConnections().get(i).getRouter2().equals(router1))
                router2.getConnections().remove(i);
        }
    }

    public LinkedList<Connection> getConnections(Router router) {
        return router.getConnections();
    }

    public LinkedList<Router> getRouters() {
        return routers;
    }
}
