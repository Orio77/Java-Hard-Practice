package generics.exercise11_genericsInStreams.scenario1;

public class Insights {
    private int mostActiveTime;
    private Device mostUsedDevice;
    private Location mostFrequentLocation;

    public Insights(int mostActiveTime, Device mostUsedDevice, Location mostFrequentLocation) {
        this.mostActiveTime = mostActiveTime;
        this.mostUsedDevice = mostUsedDevice;
        this.mostFrequentLocation = mostFrequentLocation;
    }

    public Device getMostUsedDevice() {
        return mostUsedDevice;
    }

    public Location getMostFrequentLocation() {
        return mostFrequentLocation;
    }

    public int getMostActiveTime() {
        return mostActiveTime;
    }
    
    public void setMostActiveTime(int mostActiveTime) {
        this.mostActiveTime = mostActiveTime;
    }
    public void setMostFrequentLocation(Location mostFrequentLocation) {
        this.mostFrequentLocation = mostFrequentLocation;
    }
    public void setMostUsedDevice(Device mostUsedDevice) {
        this.mostUsedDevice = mostUsedDevice;
    }
}
