package streamAPI.exercise9_streamPerformance.scenario1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogDemo {
    

    public List<Log> readLogs(List<Log> logs) {
        return logs.stream().filter(log -> log.getType().matches("ERROR")).distinct().toList();
    }

    public Map<Log, String> getLogData(List<Log> logs) {
        return logs.stream().collect(Collectors.toMap(l -> l, Log::getType));
    }

    public long getErrorLogs(List<Log> logs) {
        return logs.stream().filter(l -> l.getType().matches("ERROR")).distinct().count();
    }

    public void handleLogs(List<Log> logs1, List<Log> logs2) {
        Map<String, Map<String, Long>> result = Stream.concat(logs1.stream(), logs2.stream()).filter(l -> l.getType().matches("ERROR")).collect(Collectors.groupingBy(Log::getSeverityLevel, Collectors.groupingBy(Log::getContent, Collectors.counting())));

        result.forEach((severityLevel, map) -> {
            map.forEach((content, count) -> {
                System.out.println("Severity: " + severityLevel + "\nMessage: " + content + "\nCount: " + count);
            });
        });
    }

    public void printMostFrequentError(List<Log> logs1, List<Log> logs2) {

        Map<String, Long> map = Stream.concat(logs1.stream(), logs2.stream()).filter(log -> log.getType().matches("ERROR")).collect(Collectors.groupingBy(Log::getSeverityLevel, Collectors.counting()));

        String mostFrequentError = map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);

        System.out.println("Most frequent error: " + mostFrequentError);

    }

}
