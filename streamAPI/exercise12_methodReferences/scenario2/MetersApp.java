package streamAPI.exercise12_methodReferences.scenario2;

import java.time.DayOfWeek;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetersApp {
    

    public Map<String, Double> getAverageReadingPerMeter(List<MeterReading> readings) {
        return readings.stream().collect(Collectors.groupingBy(MeterReading::getMeterId, Collectors.averagingDouble(MeterReading::getReading)));
    }

    public Map<Integer, Long> getPeakReadingTimes(List<MeterReading> readings) {
        return readings.stream().collect(Collectors.groupingBy(reading -> reading.getTimestamp().getHour(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(es -> {
            Map<Integer, Long> map = new HashMap<>();
            map.put(es.getKey(), es.getValue());
            return map;
        }).orElse(null);
    }

    // AI Hint - for summarizing double and sorting
    public List<String> getFastestGrowingMeters(List<MeterReading> readings) {
        return readings.stream().collect(Collectors.groupingBy(MeterReading::getMeterId, Collectors.summarizingDouble(MeterReading::getReading))).entrySet().stream().sorted((a, b) -> Double.compare(
            (b.getValue().getMax() - b.getValue().getMin()),
            (a.getValue().getMax() - a.getValue().getMin()))).map(Map.Entry::getKey).toList();
    }

    // AI Copied - Standard deviation
    public List<String> getMostConsistentMeters(List<MeterReading> readings) {
        Map<String, List<MeterReading>> groupedReadings = readings.stream().collect(Collectors.groupingBy(MeterReading::getMeterId));

        Map<String, Double> standardDeviations = new HashMap<>();
        for (Map.Entry<String, List<MeterReading>> entry : groupedReadings.entrySet()) {
            DoubleSummaryStatistics stats = entry.getValue().stream().collect(Collectors.summarizingDouble(MeterReading::getReading));
        
            double mean = stats.getAverage();
            double variance = entry.getValue().stream().mapToDouble(meterReading -> meterReading.getReading()).map((reading -> Math.pow(reading - mean, 2))).average().orElse(0.0);

            double standardDeviation = Math.sqrt(variance);
            standardDeviations.put(entry.getKey(), standardDeviation);
        }
        return standardDeviations.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toList();
    }

    public List<MeterReading> getReadingsWithErrors(List<MeterReading> readings) {
        List<MeterReading> errorCausingReadings = new LinkedList<>();

        return readings.stream().peek(reading -> {
            if (reading == null || reading.getMeterId() == null || reading.getReading() == 0.0 || reading.getTimestamp() == null) {
                errorCausingReadings.add(reading);
            }
        }).toList();
    }

    public List<MeterReading> getReadingsWithoutErrors(List<MeterReading> readings) {
        return readings.stream().filter(reading -> reading != null && reading.getMeterId() != null && reading.getReading() != 0.0 && reading.getTimestamp() != null).toList();
    }

    public Map<String, Long> getMeterReadingFrequency(List<MeterReading> readings) {
        return readings.stream().collect(Collectors.groupingBy(MeterReading::getMeterId, Collectors.counting())).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<DayOfWeek, Double> getPeakReadingDays(List<MeterReading> readings, int n) {
        return readings.stream().collect(Collectors.groupingBy(reading -> reading.getTimestamp().getDayOfWeek(), Collectors.averagingDouble(MeterReading::getReading))).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, List<Double>> getReadingTrends(List<MeterReading> readings) {
        return readings.stream().collect(Collectors.toMap((MeterReading reading) -> reading.getMeterId(), reading -> (readings.stream().collect(Collectors.groupingBy(reading2 -> reading2.getTimestamp().getDayOfMonth(), Collectors.averagingDouble(MeterReading::getReading))).entrySet().stream().map(Map.Entry::getValue)).toList()));
    }
}


//      List<MeterReading> readings