package oop.exercise6_exceptionHandling.scenario2;

import java.util.ArrayList;

public class Network {
    private ArrayList<Router> routers;
    private ArrayList<Connection> connections;

    public Network() {
        routers = new ArrayList<>();
        connections = new ArrayList<>();
    }
    public ArrayList<Router> getRouters() {
        return routers;
    }
    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public void connect(Router router1, Router router2) throws NetworkException {
        if (areCompatible(router1, router2))
            connections.add(new Connection(router1, router2));
        else 
            throw new NetworkException("Routers cannot be connected");
    }
    public void disconnect(Router router1, Router router2) throws NetworkException {
        boolean removed = false;
        for (Connection connection : connections) {
            if (connection.getRouter1().equals(router1) && connection.getRouter2().equals(router2)) {
                connections.remove(connection);
                removed = true;
            }
        }
        if (!removed) {
            throw new NetworkException("No such connection");
        }
    }

    private boolean areCompatible(Router router1, Router router2) {
        return (router1.getRouterID() % 2 == router2.getRouterID() % 2);
    }

    public void sendData(Router router1, Router router2) throws NetworkException{
        if (areCompatible(router1, router2)) {
            System.out.println("Data sent");
        }
        else
            throw new NetworkException("Data cannot be sent here");
    }

    public void receiveData(Router router1, Router router2) throws NetworkException {
        if (areCompatible(router2, router1)) {
            System.out.println("Data sent");
        }
        else
            throw new NetworkException("Data cannot be sent here");
    }
}
