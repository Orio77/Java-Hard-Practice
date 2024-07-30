package threads.exercise7_atomicOperations.scenario3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

class TrafficData {
    
}

class PollutionData {
    
}

class WeatherData {
    
}

class SensorData {
    
}

class TrafficSensorDataProcessor {
    private ConcurrentLinkedQueue<TrafficData> queue;

    public void addData(TrafficData data) {
        synchronized(queue) {
            queue.add(data);
        }
    }

    public TrafficData processData() {
        synchronized(queue) {
            try {
                while (queue.isEmpty()) {
                    Thread.sleep(1000);
                }

                TrafficData data = queue.poll();
                System.out.println("Processing data at: " + data.toString());
                return data;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
    }
}

class PollutionSensorDataProcessor {
    private ConcurrentLinkedQueue<PollutionData> queue;
    private ExecutorService executorService;

    public void addData(PollutionData data) {
        synchronized(queue) {
            queue.add(data);
        }
    }

    public PollutionData processData() {
        synchronized(queue) {
            PollutionData data = queue.poll();
            executorService.submit(() -> {
                System.out.println("Processing data at: " + data.toString());
            });
            return data;
        }
    }
}

class WeatherSensorDataProcessor {
    private ConcurrentLinkedQueue<WeatherData> queue;
    private AtomicInteger processedDataCount;

    public void addData(WeatherData data) {
        synchronized(queue) {
            queue.add(data);
        }
    }

    public WeatherData processData() {
        synchronized(queue) {
            WeatherData data = queue.poll();
            System.out.println("Processing data at: " + data.toString());
            processedDataCount.incrementAndGet();
            return data;
        }
    }
}

class SensorDataProcessor {
    private ConcurrentLinkedQueue<SensorData> queue;
    private ExecutorService executorService;

    public void addData(SensorData data) {
        synchronized(queue) {
            queue.add(data);
        }
    }

    public SensorData processData() {
        synchronized(queue) {
            SensorData data = queue.poll();
            executorService.submit(() -> {
                System.out.println("Processing data at: " + data.toString());
            });
            return data;
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
