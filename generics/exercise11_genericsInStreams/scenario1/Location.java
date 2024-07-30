package generics.exercise11_genericsInStreams.scenario1;

public class Location {
    private String name;
    private double coordinates;
    
    public Location(String name, double coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public double getCoordinates() {
        return coordinates;
    }
}
