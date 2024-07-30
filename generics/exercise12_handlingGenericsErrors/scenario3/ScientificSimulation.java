package generics.exercise12_handlingGenericsErrors.scenario3;

import java.util.Map;
import java.util.stream.Stream;

public class ScientificSimulation {
    private SimulationError simulationError;
    private Map<String, Object> parameters;
    
    public void runSimulation(Map<String, Object> map) {
        try {
            parameters.put(map.entrySet().iterator().next().getKey(), map.entrySet().iterator().next().getValue());
        } catch (Error e) {
            simulationError.logError(e);
        }
    }

    public void validateParameters(Map<String, Object> map) throws Error{
        for (Map.Entry<String, Object> value : map.entrySet()) {
            if (value.getKey() == null || value.getKey().isEmpty() || value.getKey().isBlank()) {
                throw new Error("Invalid String argument");
            }
            else if (value.getKey() == null) {
                throw new Error("Invalid Object argument");
            }
        }
    }

    public void processParameterStream(Stream<Map.Entry<String, Object>> parameterStream) {
        parameterStream.forEach(parameter -> {
            try {
                addParameter(parameter.getKey(), parameter.getValue());
            } 
            catch (ClassCastException e) {
                throw new ClassCastException("Parameter " + parameter.getKey() + " is of the wrong type");
            }
            catch (Error e) {
                simulationError.logError(e);
            }
        });
    }

    public void addParameter(String name, Object value) {
        parameters.put(name, value);
    }
}
