package generics.exercise12_handlingGenericsErrors.scenario3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimulationError {
    private Map<Error, List<String>> errorLog;
    
    public void logError(Error error) {
        errorLog.put(error, new ArrayList<>());
        errorLog.get(error).add(error.getMessage());
        errorLog.get(error).add(error.getStackTrace().toString());
    }

    public void notifyUser(Error error) {
        System.out.println("An error occured");
        System.out.println(error.getMessage());
    }
}
