package threads.exercise11_deadlocks.scenario3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

class EnergyDistributionSystem {
    private AtomicInteger totalEnergy;
    

    public synchronized void distributeEnergy(int meterId, int energyUnits) {
        totalEnergy.addAndGet(energyUnits);
    }

    public int getTotalEnergyConsumption() {
        return totalEnergy.get();
    }
}

class EnergyManagementSystem {
    private ConcurrentHashMap<Integer, AtomicInteger> data;
    

    public synchronized void sendEnergyData(int meterId, int energyUnits) {
        if (data.containsKey(meterId)) {
            data.replace(meterId, new AtomicInteger(data.get(meterId).get() + energyUnits));
        }

        data.put(meterId, new AtomicInteger(energyUnits));
    }

    public synchronized void processEnergyData() {
        for (Map.Entry<Integer, AtomicInteger> entry : data.entrySet()) {
            System.out.println("Processing energy data of meter " + entry.getKey() + " and value " + entry.getValue().get());
        }
    }

    public ConcurrentHashMap<Integer, AtomicInteger> getData() {
        return data;
    }
}

class ThreadPoolEnergyManagementSystem extends EnergyManagementSystem {
    private ExecutorService executorService;
    

    @Override
    public void processEnergyData() {
        executorService.submit(() -> {
            super.processEnergyData();
        });
    }
}

class AtomicEnergyManagementSystem extends EnergyManagementSystem {
    

    @Override
    public void sendEnergyData(int meterId, int energyUnits) {
        super.sendEnergyData(meterId, energyUnits);
    }

    @Override
    public void processEnergyData() {
        super.processEnergyData();
    }

    public int getTotalEnergyProcessed() {
        return getData().values().stream().mapToInt(AtomicInteger::get).sum();
    }
}
