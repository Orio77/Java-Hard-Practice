package streamAPI.exercise17_codeReadibility.scenario1;

public class NetworkData {
    private int networkTraffic;
    private int serverLoad;
    private String potentialSecurityThreats;

    public NetworkData(int networkTraffic, int serverLoad, String potentialSecurityThreats) {
        this.networkTraffic = networkTraffic;
        this.serverLoad = serverLoad;
        this.potentialSecurityThreats = potentialSecurityThreats;
    }

    public int getNetworkTraffic() {
        return networkTraffic;
    }
    public String getPotentialSecurityThreats() {
        return potentialSecurityThreats;
    }
    public int getServerLoad() {
        return serverLoad;
    }
}
