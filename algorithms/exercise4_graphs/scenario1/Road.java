package algorithms.exercise4_graphs.scenario1;

public class Road {
    City city1;
    City city2;
    int distance;

    public Road(City city1, City city2, int distance) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
    }
    public City getCity1() {
        return city1;
    }
    public City getCity2() {
        return city2;
    }
    public int getDistance() {
        return distance;
    }
}
