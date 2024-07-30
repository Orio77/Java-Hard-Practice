package generics.exercise11_genericsInStreams.scenario3;

import java.util.List;
import java.util.Map;

public interface UserInteractionStrategy {
    
    public List<UserInteraction> filter(List<UserInteraction> interactions, String location);
    public Map<String, List<String>> group(List<UserInteraction> interactions);
}
