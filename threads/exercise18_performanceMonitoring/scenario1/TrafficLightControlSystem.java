package threads.exercise18_performanceMonitoring.scenario1;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class TrafficLightControlSystem {
    protected int[] trafficCounts;

    public void adjustTrafficFlow(int[] trafficCounts) {
        Arrays.stream(trafficCounts).parallel().forEach(i -> {
            Thread thread = new Thread();
            thread.setPriority(i);
            thread.start();
        });
    }

    public void controlTraffic() {
        synchronized(this) {
            Arrays.sort(trafficCounts);
        }
    }
}

class ConcurrencyUtilitiesTrafficSystem extends TrafficLightControlSystem {
    private ScheduledExecutorService trafficLightScheduler;
    private Phaser trafficLightPhaser;

    public void initiateTrafficLights() {
        trafficLightScheduler.schedule(() -> {
            System.out.println("Traffic lights are being scheduled");
        }, 1, TimeUnit.SECONDS);

        System.out.println("Traffic lights scheduled");
    }

    public void adjustLightDuration(int[] trafficCounts) {
        if (trafficCounts == null || trafficCounts.length != 4) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < trafficCounts.length; i++) {
            final int index = i;
            trafficLightScheduler.schedule(() -> {
                System.out.println("Adjusting light duration for direction " + index + "based on traffic count");
                trafficLightPhaser.arriveAndAwaitAdvance();
            }, 0, TimeUnit.SECONDS);
        }
    }
}

class LockObjectsTrafficSystem extends TrafficLightControlSystem {
    private ReentrantLock trafficLightLock;
    private Condition trafficLightCondition;

    public void toggleTrafficLights() {
        trafficLightLock.lock();
    }

    public void adjustLightSequence(int[] trafficCounts) {
        if (trafficCounts == null || trafficCounts.length != 4) {
            throw new IllegalArgumentException();
        }

        try {
            trafficLightLock.lock(); 
            Arrays.sort(trafficCounts);
            trafficLightCondition.signal();
        } finally {
        trafficLightLock.unlock();
        }
    }
}

class ForkJoinTrafficSystem extends TrafficLightControlSystem {
    private ForkJoinPool trafficSystemPool;

    public void initiateTrafficSystem() {
        trafficSystemPool = new ForkJoinPool();
    }

    public void adjustTrafficFlow(int[] trafficCounts) {
        TrafficFlowAdjuster task = new TrafficFlowAdjuster(trafficCounts, 0, trafficCounts.length);
        int maxTrafficFlow = trafficSystemPool.invoke(task);
        System.out.println("The maximum traffic flow is: " + maxTrafficFlow);
    }

    public void monitorTraffic() {
        while (true) {
            adjustTrafficFlow(trafficCounts);
        
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

class TrafficFlowAdjuster extends RecursiveTask<Integer> {
    private int[] trafficCounts;
    private int start;
    private int end;

    public TrafficFlowAdjuster(int[] trafficCounts, int start, int end) {
        this.trafficCounts = trafficCounts;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 1) {
            return trafficCounts[start];
        }
        else {
            int mid = (start + end) / 2;
        
            TrafficFlowAdjuster left = new TrafficFlowAdjuster(trafficCounts, start, mid);
            TrafficFlowAdjuster right = new TrafficFlowAdjuster(trafficCounts, mid, end);
            left.fork();
            return Math.max(right.compute(), left.join());
        }
    }
}
