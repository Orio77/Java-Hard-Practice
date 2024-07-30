package generics.exercise11_genericsInStreams.scenario1;

public class Device {
    private String deviceType;
    private String deviceModel;

    public Device(String deviceType, String deviceModel) {
        this.deviceType = deviceType;
        this.deviceModel = deviceModel;
    }

    public String getDeviceType() {
        return deviceType;
    }
    public String getDeviceModel() {
        return deviceModel;
    }
}
