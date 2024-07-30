package threads.exercise17_concurrencyBestPractices.scenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

class ThreatData {
    private String id;

    public String getId() {
        return id;
    }
}

class ThreatSummary {
    private List<String> raports;

    public ThreatSummary(List<String> raports) {
        this.raports = raports;
    }
    
    public List<String> getRaports() {
        return Collections.unmodifiableList(raports);
    }
}

public class CyberSecuritySystem {
    private List<ThreatData> threatDataList;
    private ExecutorService threadPool;
    private AtomicInteger numberOfThreatsAnalyzed;
    private Lock threatDataLock;

    public List<String> processThreatData(List<ThreatData> data) { // Assuming the input is a synchronized List
        List<String> raports = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            new Thread(() -> {
                while (!data.isEmpty()) {
                    String currentThreadID = data.remove(new Random().nextInt(data.size())).getId();
                    System.out.println("Processing data: " + currentThreadID);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    raports.add("Raport summary for thread " + currentThreadID);
                }
            }).start();
        }
        return raports;
    }

    public ThreatSummary getThreatSummary() {
        return new ThreatSummary(processThreatData(threatDataList));
    }

    public void distributeThreatData(List<ThreatData> data) {
        AtomicInteger index = new AtomicInteger();
        while (index.get() <= data.size()) {
            threadPool.submit(() -> {
                System.out.println("Analysing data " + data.get(index.getAndIncrement()).getId());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        threadPool.shutdown();
    }

    public void updateDefenseMechanisms() {
        while (!threadPool.isShutdown()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Updating defense mechanisms");
    }

    public void analyzeThreatData(List<ThreatData> data) {
        distributeThreatData(data);
    }

    public int getNumberOfThreatsAnalyzed() {
        return numberOfThreatsAnalyzed.get();
    }

    public void lockThreatData(ThreatData data) {
        threatDataLock.lock();
    }

    public void unlockThreatData(ThreatData data) {
        threatDataLock.unlock();
    }
}
