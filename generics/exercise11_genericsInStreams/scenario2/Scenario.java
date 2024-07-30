package generics.exercise11_genericsInStreams.scenario2;

import java.util.List;

public class Scenario<T extends Phenomenon<?>> {
    private List<T> phenomenonList;

    public void runSimulation() {
        for (T phenomenon : phenomenonList) {
            phenomenon.simulate();
        }
    }
}
