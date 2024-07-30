package streamAPI.exercise7_parallelStreams.scenario2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalysisApp {
    
    public Map<String, Double> findMaxPollutedZonesParallel(List<SensorData> data, int n) {
        return data.parallelStream().collect(Collectors.groupingBy(SensorData::getZone, Collectors.averagingDouble(SensorData::getPollutionLevel))).entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).limit(n).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public List<String> findSensorsWithHighVarianceParallel(List<SensorData> data, double treshold) {

        Map<String, List<Double>> map = data.parallelStream().collect(Collectors.groupingBy(SensorData::getSensorId, Collectors.mapping(SensorData::getPollutionLevel, Collectors.toList())));
        
        // AI Copied - I did not know how to measure the growth rate
        return map.entrySet().stream().filter(es -> {

            double mean = es.getValue().stream().mapToDouble(num -> num).average().orElse(0.0);

            double variance = es.getValue().stream().map(val -> Math.pow(val - mean, 2)).mapToDouble(val -> val).average().orElse(0.0);

            if (variance > treshold) {
                return true;
            }
            return false;
        }).map(Map.Entry::getKey).toList();
    
    }


    public List<String> findFastestGrowingPollutionZonesParallel(List<SensorData> data, int n) {
        Map<String, List<Double>> map = data.parallelStream().collect(Collectors.groupingBy(SensorData::getZone, Collectors.mapping(SensorData::getPollutionLevel, Collectors.toList())));

        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, es -> (es.getValue().get(es.getValue().size() - 1) - es.getValue().get(0) / es.getValue().get(0)))).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).map(Map.Entry::getKey).toList();
    }

    public List<String> findZonesWithMissingDataParallel(List<SensorData> data) {
        return data.parallelStream().filter(sd -> {
            if (sd.getZone() == null) {
                sd.setZone("Unknown Zone");
                return true;
            }
            else if (sd.getPollutionLevel() == 0.0) {
                return true;
            }
            else if (sd.getSensorId() == null || sd.getSensorId().isEmpty()) {
                return true;
            }
            else {
                return false;
            }
        }).collect(Collectors.groupingBy(SensorData::getZone)).entrySet().stream().map(Map.Entry::getKey).toList();
    }

    public List<SensorData> handleMissingDataParallel(List<SensorData> data, String defaultValueStr, double defaultValueDbl) {

        return data.parallelStream().map(sd -> {
            if (sd.getZone() == null) {
                sd.setZone(defaultValueStr);
            }
            else if (sd.getPollutionLevel() == 0.0) {
                sd.setPollutionLevel(defaultValueDbl);
            }
            else if (sd.getSensorId() == null || sd.getSensorId().isEmpty()) {
                sd.setSensorId(defaultValueStr);
            }
            return sd;
            }).toList();
        }

        public String findZoneWithMostSensorsParallel(Map<String, List<SensorData>> data) {
            return data.entrySet().parallelStream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().map(SensorData::getSensorId).collect(Collectors.toSet()).size())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("none");
        }

        public String findSensorWithHighestPollutionParallel(Map<String, List<SensorData>> data) {
            return data.entrySet().parallelStream().flatMap(es -> es.getValue().stream()).max(Comparator.comparing(SensorData::getPollutionLevel)).map(v -> v.getSensorId()).orElse("none");
        }

        public Map<String, String> groupSensorsByPollutionLevelParallel(Map<String, List<SensorData>> data, double treshold) {

            return data.entrySet().stream().flatMap(e -> e.getValue().stream()).collect(Collectors.groupingBy(SensorData::getSensorId, Collectors.averagingDouble(SensorData::getPollutionLevel))).entrySet().stream().map(es -> {
                if (es.getValue() > treshold) {
                    return Map.entry(es.getKey(), "High");
                }
                else
                    return Map.entry(es.getKey(), "Low");
            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
    }

// Great exercise, however I would eliminate 4th task. Make the Copilot generate 1st task only, then the last two