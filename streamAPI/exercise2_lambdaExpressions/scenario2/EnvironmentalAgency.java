package streamAPI.exercise2_lambdaExpressions.scenario2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class EnvironmentalAgency {
    private List<SensorData> data;
    private Stack<Exception> exceptionLog;

    public double getAverageAqirQualityIndex() {
        return data.stream().filter(sd -> sd.getAirQualityIndex() != 0).sorted(Comparator.comparing(SensorData::getAirQualityIndex)).mapToInt(SensorData::getAirQualityIndex).average().orElse(0.0);
    }

    public Map<String, Double> getAverageAirQualityIndexPerZone() {
        return data.stream().collect(Collectors.groupingBy(SensorData::getZone, Collectors.averagingDouble(SensorData::getAirQualityIndex)));
    }

    public Set<String> getWorstAirQualityZones(double treshold) {
        return data.parallelStream().filter(sd -> sd.getAirQualityIndex() != 0).collect(Collectors.groupingBy(sd -> {
            try {
                return sd.getZone();
            } catch (Exception e) {
                exceptionLog.push(e);
                return "null";
            }
        }, Collectors.averagingDouble(sd -> {
            try {
                return sd.getAirQualityIndex();
            } catch (Exception e) {
                exceptionLog.push(e);
                return 0;
            }
        }))).entrySet().stream().filter(es -> es.getValue() > treshold).map(es -> es.getKey()).collect(Collectors.toSet());
    }



}
