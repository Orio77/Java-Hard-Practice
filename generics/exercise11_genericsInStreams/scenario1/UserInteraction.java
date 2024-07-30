package generics.exercise11_genericsInStreams.scenario1;

public class UserInteraction {
    private Location location;
    private Device device;
    private int time;

    public UserInteraction(Location location, Device device, int time) {
        this.location = location;
        this.device = device;
        this.time = time;
    }

    public int getTime() {
        return time;
    }
    public Location getLocation() {
        return location;
    }
    public Device getDevice() {
        return device;
    }
}
