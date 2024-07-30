package threads.exercise19_documentation.scenario3;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;


public class AutonomousVehicle {
    private List<String> sensorData;
    private String receivedData;
    private List<String> communicationData;
    private Object sharedResource;
    private Lock resourceLock;
    private AtomicInteger dataProcessed;

    public void processSensorData() {
        synchronized(sensorData) {
            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                new Thread(() -> {
                    while (dataProcessed.get() <= sensorData.size()) {
                        System.out.println("Processing Sensor Data: " + sensorData.get(dataProcessed.getAndIncrement()));
                    }
                }).start();
            }
        }
    }

    public void makeDecision() {
        while (dataProcessed.get() != sensorData.size()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Making decision based on processed data");
        new String();
    }

    public void sendData(String data) {
        synchronized(communicationData) {
            communicationData.add(data);
        }
    }

    public void receiveData() {
        synchronized(receivedData) {
            receivedData = new String();
        }
    }

    public void initiateCommunication(List<String> vehicles) {
        synchronized(vehicles) {
            vehicles.parallelStream().forEach(vehicle -> {
                for (int i = 0; i < vehicles.size(); i++) {
                    System.out.println("Vehicle communicating with " + vehicles.get(new Random().nextInt(vehicles.size())));
                }
            });
        }
    }

    public void manageThreads() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        System.out.println("Deadlocked threads: " + Arrays.toString(threadMXBean.findDeadlockedThreads()));
    }

    public void accessSharedResource() {
        synchronized(sharedResource) {

        }
    }

    public void lockResource() {
        resourceLock.lock();
    }

    public void unlockResource() {
        resourceLock.unlock();
    }
}
