package streamAPI.exercise8_exceptionHandling.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EnvironmentalDataApp {
    

    public List<DataRecord> filterAndSortRecords(List<DataRecord> records) {
        return records.stream().filter(Objects::nonNull).filter(record -> record.getTemperature() >= 0).sorted(Comparator.comparing(DataRecord::getDate)).toList();
    }

    public double calculateAverageTemperature(List<DataRecord> records) {
        return records.stream().mapToInt(DataRecord::getTemperature).average().orElse(0);
    }

    public Integer findMaxTemperature(List<DataRecord> records) {
        return records.stream().mapToInt(DataRecord::getTemperature).max().orElse(0);
    }

    public Integer findMinTemperature(List<DataRecord> records) {
        return records.stream().mapToInt(DataRecord::getTemperature).min().orElse(0);
    }

    public Map<String, List<DataRecord>> groupByLocation(List<DataRecord> records) {
        return records.stream().collect(Collectors.groupingBy(DataRecord::getLocation));
    }

    public Map<String, Double> calculateAverageTemperatureByLocation(List<DataRecord> records) {
        return records.stream().collect(Collectors.groupingBy(DataRecord::getLocation, Collectors.averagingInt(DataRecord::getTemperature)));
    }

    public List<DataRecord> sortRecordsByDate(List<DataRecord> records) {
        return records.stream().sorted(Comparator.comparing(DataRecord::getDate)).toList();
    }

    public List<DataRecord> sortRecordsByTemperature(List<DataRecord> records) {
        return records.stream().sorted(Comparator.comparing(DataRecord::getTemperature)).toList();
    }

    public List<DataRecord> sortRecordsByLocation(List<DataRecord> records) {
        return records.stream().sorted(Comparator.comparing(DataRecord::getLocation)).toList();
    }
}
