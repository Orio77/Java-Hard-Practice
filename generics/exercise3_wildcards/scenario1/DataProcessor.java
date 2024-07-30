package generics.exercise3_wildcards.scenario1;

public class DataProcessor {

    public void processData(SensorData<?> data) {
        System.out.println(data.getDataList());
    }

    public void displaySensorData(SensorData<?> data) {
        System.out.println(data.getDataList());
    }
}
