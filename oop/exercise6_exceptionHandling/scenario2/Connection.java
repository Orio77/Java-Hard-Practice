package oop.exercise6_exceptionHandling.scenario2;

public class Connection {
    private Router router1;
    private Router router2;

    public Connection(Router router1, Router router2) {
        this.router1 = router1;
        this.router2 = router2;
    }
    public Router getRouter1() {
        return router1;
    }
    public Router getRouter2() {
        return router2;
    }
}
