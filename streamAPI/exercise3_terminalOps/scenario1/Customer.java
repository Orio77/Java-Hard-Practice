package streamAPI.exercise3_terminalOps.scenario1;

public class Customer {
    private String name;
    private int id;
    private String region;
    private boolean isActive;

    public Customer(String name, String region, boolean isActive) {
        this.name = name;
        this.region = region;
        this.isActive = isActive;
        id = name.hashCode();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getRegion() {
        return region;
    }
    public boolean isActive() {
        return isActive;
    }

    
}
