package generics.exercise15.scenario1;

public class Test<T> {
    private Simulation<T> simulation;
    private String exepectedResult;

    public Test(Simulation<T> simulation, String exepectedResult) {
        this.simulation = simulation;
        this.exepectedResult = exepectedResult;
    }

    public Simulation<T> getSimulation() {
        return simulation;
    }
    public String getExepectedResult() {
        return exepectedResult;
    }
}
