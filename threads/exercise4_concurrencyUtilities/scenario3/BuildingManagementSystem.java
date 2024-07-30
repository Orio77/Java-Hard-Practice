package threads.exercise4_concurrencyUtilities.scenario3;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.AtomicDouble;

class HVAC {
    private boolean energySavingMode;

    public boolean isEnergySavingMode() {
        return energySavingMode;
    }
}

class Lighting {
    private boolean energySavingMode;

    public boolean isEnergySavingMode() {
        return energySavingMode;
    }
}

class SecuritySystem {
    private List<Component> components;
    
    public List<Component> getComponents() {
        return components;
    }
}

class Component {
    private String name;
    private boolean failed;

    public String getName() {
        return name;
    }
    public boolean isFailed() {
        return failed;
    }
}

class ElevatorSystemTask implements Runnable {
    private String name;
    
    @Override
    public void run() {
        System.out.println("Running the elevator system: " + name);
    }

    public String getName() {
        return name;
    }
}

class PowerSystemTask extends RecursiveTask<Double> {
    private double powerResources;

    public PowerSystemTask(double powerResources) {
        this.powerResources = powerResources;
    }
    
    @Override
    protected Double compute() {    
        System.out.println("Distributing " + powerResources/5 + " of power resource");
        return powerResources/5;
    }
    
    public double getPowerResources() {
        return powerResources;
    }
}

class Room {
    private boolean lightTurnedOn;
    private double powerConsumption;

    public double getPowerConsumption() {
        return powerConsumption;
    }
    public boolean isLightTurnedOn() {
        return lightTurnedOn;
    }
    public void setLightTurnedOn(boolean lightTurnedOn) {
        this.lightTurnedOn = lightTurnedOn;
    }
    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}

class BuildingManagementSystem {
    private HVAC hvac;
    private Lighting lighting;
    private SecuritySystem securitySystem;
    private ElevatorSystemTask elevatorSystemTask;
    private PowerSystemTask powerSystemTask;
    private AtomicInteger failedComponents;
    private AtomicDouble powerUsed;

    public void synchronizeSystems() {
        synchronized(hvac) {
            synchronized(lighting) {
                new Thread(() -> {
                    while (!lighting.isEnergySavingMode()) {
                        System.out.println("HVAC system running and performing tasks");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                        }
                    }
                }).start();
        
                new Thread(() -> {
                    while (!hvac.isEnergySavingMode()) {
                        System.out.println("Lightning is turned on");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                        }
                    }
                }).start();
            }
        }
    }

    public void communicateStatus() {
        while (true) {
            if (lighting.isEnergySavingMode() || hvac.isEnergySavingMode()) {
                synchronizeSystems();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void initializeSecuritySystem() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (Component component : securitySystem.getComponents()) {
            executor.submit(() -> {
                System.out.println("Component: " + component.getName() + ", assigned");
            });
        }
    }

    public void monitorSecuritySystem() {
        new Thread(() -> {
            for (Component component : securitySystem.getComponents()) {
                if (component.isFailed()) {
                    failedComponents.incrementAndGet();
                }
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        });
    }

    public void operateElevators() {
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).submit(elevatorSystemTask);
    }

    public void handleInterruptions() {
        try {
            operateElevators();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void distributePower() {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(powerSystemTask);
        powerUsed.addAndGet(powerSystemTask.getPowerResources());
    }

    public double calculatePowerUsage() {
        return powerUsed.get();
    }

    public void optimizePowerUsage(List<Room> rooms) {
        for (Room room : rooms) {
            if (!room.isLightTurnedOn()) {
                double savedEnergy = room.getPowerConsumption();
                room.setPowerConsumption(0);
                System.out.println("Saved " + savedEnergy + " energy");
                powerUsed.set(powerUsed.get() - savedEnergy);
            }
        }
    }
}
