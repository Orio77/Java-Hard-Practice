package streamAPI.exercise17_codeReadibility.scenario1;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

public class NetworkOperationsCentre {
    private List<NetworkData> networkData;
    private Stack<Error> errorLog; 

    public double op() {
        return networkData.parallelStream().filter(d -> !d.getPotentialSecurityThreats().matches("none")).mapToInt(d -> d.getServerLoad()).reduce((count, value) -> count + value).orElse(0) / networkData.size();
    }

    public Map<String, Integer> groupByThreat() {
        return networkData.parallelStream().filter(d -> {
            try {
                return Objects.nonNull(d); // Doesn't actually throw an error, but it's for error handling demonstration
            } catch (Error e) {
                errorLog.push(e);
                return false;
            }
        }).filter(d -> d.getNetworkTraffic() > 0 && d.getServerLoad() > 0).collect(Collectors.groupingBy(NetworkData::getPotentialSecurityThreats, Collectors.summingInt(NetworkData::getServerLoad)));
    }

    public Map<String, Integer> handleNulls() {
        Optional<Map<String, Integer>> map =  Optional.ofNullable(groupByThreat());

        if (map.isPresent()) {
            return map.get();
        }
        else {
            return null;
        }
    }



}
