package streamAPI.exercise11_customCollectors.scenario3;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NetworkMonitor {

    public List<Integer> detectThreats(Stream<String> packets) {
        return packets.filter(packet -> packet.contains("threat")).map(String::length).collect(Collectors.toList());
    }

    public Map<Integer, Long> alertThreats(List<Integer> threats) {
        return threats.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Integer> detectThreatsFast(Stream<String> packets) {
        return packets.parallel().filter(packet -> packet.contains("threat")).map(String::length).collect(Collectors.toList());
    }

    public Map<Integer, Long> alertThreatsFast(List<Integer> threats) {
        return threats.parallelStream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Integer> detectThreatsWithExceptionHandling(Stream<String> packets) {
        return packets.filter(Objects::nonNull).filter(packet -> packet.contains("threat")).map(String::length).collect(Collectors.toList());
    }

    public Map<Integer, Long> alertThreatsWithExceptionHandling(List<Integer> threats) {
        return threats.stream().filter(num -> num > 0).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Set<Integer> detectThreatsDS(Stream<String> packets) {
        return packets.filter(packet -> packet.contains("threat")).map(String::length).collect(Collectors.toSet());
    }

    // AI Helped - I did not know how to return a Tree Map with Streams
    public TreeMap<Integer, Long> alertThreatsDS(List<Integer> threats) {
        Map<Integer, Long> map = threats.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new TreeMap<>(map);
    }

    // AI Helped - I did not know how to implement the comparator to the pQueue
    public PriorityQueue<Integer> analyzeThreatsDS(TreeMap<Integer, Long> threats) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> threats.get(a).compareTo(threats.get(b)));

        List<Integer> list = threats.entrySet().stream().map(Map.Entry::getKey).toList(); 

        pQueue.addAll(list);
    
        return pQueue;
    }

    
}
