package algorithms.exercise4_graphs.scenario3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Router {
    String name;
    int routerId;
    LinkedList<Connection> connections;

    public Router(String name) {
        this.name = name;
        routerId = name.hashCode();
        connections = new LinkedList<>();
    }
    public String getName() {
        return name;
    }

    public void addConnection(Router router, int constructionCost) {
        connections.add(new Connection(this, router, constructionCost));
    }

    public void removeConnection(Router router) {
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i).getRouter2().equals(router)) {
                connections.remove(i);
            }
        }
        for (int i = 0; i < router.getConnections().size(); i++) {
            if (router.getConnections().get(i).getRouter2().equals(router)) {
                connections.remove(i);
            }
        }
    }

    public LinkedList<Connection> getConnections() {
        return connections;
    }

    public ArrayList<Router> getConnectedRouters() {
        ArrayList<Router> connected = new ArrayList<>();
        for (Connection connection : connections) {
            connected.add(connection.getRouter2());
        }
        return connected;
    }
}
