package algorithms.exercise4_graphs.scenario3;

public class Connection {
    Router router1;
    Router router2;
    int transmissionTime;
    int constructionCost;

    public Connection(Router router1, Router router2, int constructionCost) {
        this.router1 = router1;
        this.router2 = router2;
        this.constructionCost = constructionCost;
    }
    public Router getRouter1() {
        return router1;
    }
    public Router getRouter2() {
        return router2;
    }

    public int getConstructionCost() {
        return constructionCost;
    }
    public int getTransmissionTime() {
        return transmissionTime;
    }
}