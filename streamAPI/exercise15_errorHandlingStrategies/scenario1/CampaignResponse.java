package streamAPI.exercise15_errorHandlingStrategies.scenario1;

public class CampaignResponse {
    private String region;
    private String demographic;
    private int response;

    public CampaignResponse(String region, String demographic, int response) {
        this.region = region;
        this.demographic = demographic;
        this.response = response;
    }

    public String getDemographic() {
        return demographic;
    }
    public String getRegion() {
        return region;
    }
    public int getResponse() {
        return response;
    }
}
