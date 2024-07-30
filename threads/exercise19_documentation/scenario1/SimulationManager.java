package threads.exercise19_documentation.scenario1;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SimulationManager {
    protected List<Simulation> simulations;
    protected List<SimulationResult> results;

    public void runSimulations(List<Simulation> simulations) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Simulation simulation : simulations) {
            executor.submit(() -> {
                results.add(new SimulationResult(simulation.run()));
            });
        }

        executor.shutdown();
    }

    public List<SimulationResult> getResults() {
        return Collections.unmodifiableList(results);
    }
}

class SynchronizedSimulationManager extends SimulationManager {

    @Override
    public synchronized void runSimulations(List<Simulation> simulations) {
        super.runSimulations(simulations);
    }

    @Override
    public synchronized List<SimulationResult> getResults() {
        return super.getResults();
    }
}

class ThreadPoolSimulationManager extends SimulationManager {
    @SuppressWarnings("unused")
    private ExecutorService executor;

    @Override
    public void runSimulations(List<Simulation> simulations) {
        super.runSimulations(simulations);
    }
}

class ExecutorsSimulationManager extends SimulationManager {
    private ExecutorService executorService;

    @Override
    public void runSimulations(List<Simulation> simulations) {
        super.runSimulations(simulations);
    }

    @Override
    public List<SimulationResult> getResults() {
        return super.getResults();
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

class Simulation {
    private String name;

    public double run() {
        System.out.println("Simulation " + name + "is running");

        return Math.random() * 100;
    }

    public String getName() {
        return name;
    }
}

class SimulationResult {
    private double successRate;

    public SimulationResult(double successRate) {
        this.successRate = successRate;
    }

    public double getSuccessRate() {
        return successRate;
    }


}