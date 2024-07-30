package files.exercise13_.scenario1;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;

public class MeteorologicalDataManager {
    // Task 1
    public void readAndFilterData(String filePath, String outputFilePath, double temperatureThreshold) throws IOException {
        // implementation here
    }

    public double calculateAverageTemperature(String filePath) throws IOException {
        // implementation here
    }

    // Task 2
    public void setReadPermissions(String directoryPath) throws IOException {
        // implementation here
    }

    public List<String> readAllFiles(String directoryPath) throws IOException {
        // implementation here
    }

    // Task 3
    public BasicFileAttributes getFileAttributes(String filePath) throws IOException {
        // implementation here
    }

    public List<String> filterByDate(String filePath, String startDate, String endDate) throws IOException {
        // implementation here
    }

    // Task 4
    public Map<String, Double> readDataIntoMap(String filePath) throws IOException {
        // implementation here
    }

    public double getTemperatureOnDate(String date) {
        // implementation here
    }

    public double getAverageTemperature() {
        // implementation here
    }
}
