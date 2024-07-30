package streamAPI.exercise7_parallelStreams.scenario2;

/**
 * SensorData
 */
public class SensorData {
    private String zone;
    private String sensorId;
    private double pollutionLevel;

    public SensorData(String zone, String sensorId, double pollutionLevel) {
        this.zone = zone;
        this.sensorId = sensorId;
        this.pollutionLevel = pollutionLevel;
    }
    
    public double getPollutionLevel() {
        return pollutionLevel;
    }
    public String getSensorId() {
        return sensorId;
    }
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
    public void setPollutionLevel(double pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }
    
    
    
}