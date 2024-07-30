package threads.exercise4_concurrencyUtilities.scenario2;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.google.common.util.concurrent.AtomicDouble;

class MeterData {
    String meterId;
    double consumption;

    public double getConsumption() {
        return consumption;
    }
    public String getMeterId() {
        return meterId;
    }
}

class RealTimeAnalyzer {
    private List<MeterData> database;

    public synchronized void addMeterData(MeterData data) {
        database.add(data);
    }

    public synchronized List<MeterData> analyzeData() {
        for (MeterData meterData : database) {
            System.out.println("Analyzing Meter " + meterData.getMeterId() + " with consumption of " + meterData.getConsumption());
        }

        return Collections.unmodifiableList(database);
    }
}

class ThreadPoolProcessor {
    private ExecutorService executor;

    public void processMeterData(MeterData data) {
        executor.submit(() -> {
            System.out.println("Processing Meter " + data.getMeterId() + "with consumtion of " + data.getConsumption());
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}

class AtomicEnergyTracker {
    private List<MeterData> database;
    private AtomicDouble energy;

    public void addMeterData(MeterData data) {
        synchronized(this) {
            database.add(data);
            energy.getAndAdd(data.getConsumption());
        }
    }

    public double getTotalConsumption() {
        return energy.get();
    }
}

class ExecutorServiceProcessor {
    private ExecutorService executor;
    private List<MeterData> database;

    public void processMeterData(MeterData data) {
        executor.submit(() -> {
            System.out.println("Processing Meter " + data.getMeterId() + "with consumtion of " + data.getConsumption());
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

    public Future<MeterData> getProcessedData(String meterId) {

        Future<MeterData> future = executor.submit(() -> {
            Map<String, MeterData> map = database.parallelStream().collect(Collectors.toMap(MeterData::getMeterId, data -> data));
            return map.get(meterId);
        });

        executor.shutdown();

        return future;
    }
}
