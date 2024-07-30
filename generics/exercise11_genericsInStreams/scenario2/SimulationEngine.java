package generics.exercise11_genericsInStreams.scenario2;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine<T extends Phenomenon<?>> {
    private List<T> phenomenonList;

    public SimulationEngine() {
        phenomenonList = new ArrayList<>();
    }

    public boolean addPhenomenon(T phenomenon) {
        return phenomenonList.add(phenomenon);
    }

    public void runSingleSimulation(T phenomenon) {
        phenomenon.simulate();
    }

    public void simulateScenario(Scenario<T> scenario) {
        scenario.runSimulation();
    }
}
