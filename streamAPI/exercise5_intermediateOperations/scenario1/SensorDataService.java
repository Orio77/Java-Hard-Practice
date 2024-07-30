package streamAPI.exercise5_intermediateOperations.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SensorDataService {
    
    public List<Double> filterAndSortData(List<SensorData> data, String type) {
        return data.stream().filter(sData -> sData.getType().matches(type)).map(SensorData::getValue).sorted(Comparator.naturalOrder()).toList();
    }

    public double averageSensorData(List<SensorData> data, String type) {
        return data.stream().filter(sData -> sData.getType().matches(type)).mapToDouble(SensorData::getValue).average().orElse(0);
    }

    public List<Double> filterAndSortDataParallel(List<SensorData> data, String type) {
        return data.parallelStream().filter(sData -> sData.getType().matches(type)).map(SensorData::getValue).sorted(Comparator.naturalOrder()).toList();
    }

    public double averageSensorDataParallel(List<SensorData> data, String type) {
        return data.parallelStream().filter(sData -> sData.getType().matches(type)).mapToDouble(SensorData::getValue).average().orElse(0);
    }

    public List<Double> filterAndSortDataWithErrorHandling(List<SensorData> data, String type) {
        if (data == null || data.isEmpty() || type == null || type.isBlank()) {
            return null;
        }
        
        return data.stream().filter(sData -> sData.getType() != null && sData.getValue() > 0 &&sData.getType().matches(type)).map(SensorData::getValue).sorted(Comparator.naturalOrder()).toList();
    }

    public double averageSensorDataWithErrorHandling(List<SensorData> data, String type) {
        if (data == null || data.isEmpty() || type == null || type.isBlank()) {
            return 0;
        }

        return data.stream().filter(sData -> sData.getType() != null && sData.getValue() > 0 && sData.getType().matches(type)).mapToDouble(SensorData::getValue).average().orElse(0);
    }

    public PriorityQueue<Double> filterAndSortDataWithStructures(List<SensorData> data, String type) {
        PriorityQueue<Double> pQueue = new PriorityQueue<>(Comparator.naturalOrder());

        List<Double> list = data.stream().filter(sData -> sData.getType().matches(type)).map(SensorData::getValue).sorted(Comparator.naturalOrder()).toList();
        pQueue.addAll(list);
        return pQueue;
    }

    public OptionalDouble averageSensorDataWithStructures(List<SensorData> data, String type) {
        return data.parallelStream().filter(sData -> sData.getType().matches(type)).mapToDouble(SensorData::getValue).average();
    }

    public Map<String, List<SensorData>> groupDataByType(List<SensorData> data) {
        return data.stream().collect(Collectors.groupingBy(SensorData::getType));
    }
}
