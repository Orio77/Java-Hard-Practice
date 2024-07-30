package generics.exercise11_genericsInStreams.scenario3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationStrategy implements UserInteractionStrategy{
    
    @Override
    public List<UserInteraction> filter(List<UserInteraction> interactions, String location) {
        return interactions.stream().filter(i -> i.getLocation().matches(location)).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<String>> group(List<UserInteraction> interactions) {
        Map<String, List<String>> returnMap = new HashMap<>();
        List<String> users = new ArrayList<>();

        for (UserInteraction userInteraction : interactions) {
            String location = userInteraction.getLocation();
            for (UserInteraction userInteraction2 : interactions) {
                if (userInteraction2.getLocation().matches(location)) {
                    users.add(userInteraction2.getUserId());
                }
                returnMap.put(location, users);
            }
        }
        return returnMap;
    }
}
