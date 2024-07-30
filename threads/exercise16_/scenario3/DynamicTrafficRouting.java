package threads.exercise16_.scenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class Network {
    private String condition;
    private int measurement;

    public String getCondition() {
        return condition;
    }
    public int getMeasurement() {
        return measurement;
    }
}

class DynamicTrafficRouting {
    private List<Network> networks;

    public Map<String, Integer> monitorNetworkConditions() {
        ConcurrentHashMap<String, Integer> results = new ConcurrentHashMap<>();
        AtomicInteger index = new AtomicInteger(0);
        synchronized(networks) {
            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                new Thread(() -> {
                    while (index.get() <= networks.size()) {
                        Network network = networks.get(index.getAndIncrement());
                        results.put(network.getCondition(), network.getMeasurement());
                    }
                }).start();
            }
            return results;
        }
    }

    public Map<String, String> adjustRouting(Map<String, Integer> conditions, int treshold) {
        ConcurrentHashMap<String, String> results = new ConcurrentHashMap<>();
        AtomicInteger index = new AtomicInteger(0);
        synchronized(conditions) {
            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                new Thread(() -> {
                    while (index.get() <= conditions.size()) {
                        Set<Entry<String, Integer>> es = conditions.entrySet();
                        es.parallelStream().forEach(entry -> {
                            String value = new String();
                            if (treshold > entry.getValue()) {
                                value = "decrease";
                            } else value = "increase";

                            results.put(entry.getKey(), value);
                        });
                    }
                }).start();
            }
            return results;
        }
    }
}

class ThreadPoolTrafficRouting {
    public ExecutorService createThreadPool(int numberOfThreads) {
        return Executors.newFixedThreadPool(numberOfThreads);
    }

    public List<Future<?>> executeTasks(ExecutorService threadPool, List<Runnable> tasks) {
        List<Future<?>> results = Collections.synchronizedList(new ArrayList<>());
        for (Runnable task : tasks) {
            results.add(threadPool.submit(task));
        }
        return results;
    }
}

class AtomicTrafficRouting {
    private List<Network> networks;
    private final int treshold = 10; // Depending on the app

    public AtomicInteger monitorNetworkCondition() {
        ConcurrentHashMap<String, Integer> results = new ConcurrentHashMap<>();
        AtomicInteger index = new AtomicInteger(0);
        synchronized(networks) {
            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                new Thread(() -> {
                    while (index.get() <= networks.size()) {
                        Network network = networks.get(index.getAndIncrement());
                        results.put(network.getCondition(), network.getMeasurement());
                    }
                }).start();
            }
            return index;
        }
    }   

    public String adjustRouting(AtomicInteger condition) {
        if (condition.get() > treshold) {
            return "decrease";
        } else if (condition.get() == treshold) {
            return "perfect";
        }
        
        else return "increase";
    }
}

class ExecutorsTrafficRouting {
    public ExecutorService createExecutorService(int numberOfThreads) {
        return Executors.newFixedThreadPool(numberOfThreads);
    }

    public List<Future<?>> submitTasks(ExecutorService executorService, List<Runnable> tasks) {
        List<Future<?>> futures = Collections.synchronizedList(new ArrayList<>());

        for (Runnable task : tasks) {
            futures.add(executorService.submit(task));
        }
        return futures;
    }

    public void shutdownExecutorService(ExecutorService executorService) {
        executorService.shutdown();
    }
}
