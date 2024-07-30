package oop.exercise6_exceptionHandling.scenario2;

public class ChatApp {
    private Network network;

    public ChatApp() {
        network = new Network();
    }

    public void simulateRouterBase(int routers) {
        for (int i = 0; i < routers; i++) {
            network.getRouters().add(new Router("Router" + i));
        }
    }

    public void run() {

        Router testRouter1 = network.getRouters().get(42);
        Router tesRouter2 = network.getRouters().get(23);
        
        try {
            network.connect(testRouter1, tesRouter2);
        } catch (NetworkException e) {
            System.out.println(e.getMessage());
        }
        finally {
            recover(testRouter1, tesRouter2);
        }
    }

    public void recover(Router router1, Router router2) {
        for (Connection connection : network.getConnections()) {
            if (!connection.getRouter1().equals(router1)) {
                if (!connection.getRouter2().equals(router2)) {
                    network.getConnections().add(new Connection(router1, router2));
                }
            }
        }
    }
}
