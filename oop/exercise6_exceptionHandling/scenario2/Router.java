package oop.exercise6_exceptionHandling.scenario2;

public class Router {
    private String name;
    private int routerID;

    public Router(String name) {
        this.name = name;
        this.routerID = name.hashCode();
    }
    public String getName() {
        return name;
    }
    public int getRouterID() {
        return routerID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRouterID(int routerID) {
        this.routerID = routerID;
    }
}
