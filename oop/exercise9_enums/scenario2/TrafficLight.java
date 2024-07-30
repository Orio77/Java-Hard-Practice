package oop.exercise9_enums.scenario2;

public enum TrafficLight {
    RED (60),
    YELLOW (10),
    GREEN (50);

    private final int duration;
    private boolean sensorTriggered;
    private String current;

    private TrafficLight(int duration) {
        this.duration = duration;
        sensorTriggered = false;
        current = "red";
    }
    public String getCurrent() {
        return current;
    }
    public int getDuration() {
        return duration;
    }

    public TrafficLight nexLight() {
        boolean wasRed = false;
        switch (current) {
            case "red":
                current = "yellow";
                wasRed = true;
                sensorTriggered = false;
                return YELLOW;
            case "yellow":
                if (wasRed) {
                    current = "green";
                    wasRed = false;
                    sensorTriggered = false;
                    return GREEN;
                }
                current = "red";
                return RED;
            case "green":
                current = "yellow";
                sensorTriggered = false;
                return YELLOW;
            default:
                return RED;
        }
    }

    public String getColorCode() {
        switch (current) {
            case "red":
                return "#FF0000";
            case "yellow":
                return "#FFFF00";
            case "green":
                return "#00FF00";
            default:
                return "";
        }
    }

    public void triggerSensor() {
        sensorTriggered = true;
    }
    public boolean getSensorTriggered() {
        return sensorTriggered;
    }
    public void setCurrent(String current) {
        this.current = current;
    }
}