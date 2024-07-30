package threads.exercise8_threadSafety.scenario1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

enum Direction {
    NORTH, SOUTH, EAST, WEST
}

class TrafficLightSystem {
    @SuppressWarnings("unused")
    private Direction currentDirection;
    private Direction currentGreenLight;

    public void changeLight(Direction direction) {
        synchronized(this) {
            currentDirection = direction;
        }
    }

    public Direction currentLight() {
        synchronized(this) {
            return currentGreenLight;
        }
    }
}

class SharedCounter {
    private AtomicInteger counter;

    public void incrementCounter() {
        this.counter.incrementAndGet();
    }

    public int getCounter() {
        return this.counter.get();
    }
}

class SharedData {
    private AtomicInteger data;

    public void updateData(int value) {
        this.data.set(value);
    }

    public int readData() {
        return this.data.get();
    }
}

class TaskExecutor {
    private ExecutorService executorService;

    public void submitTask(Runnable task) {
        executorService.submit(task);
    }

    public void shutdown() {
        executorService.shutdown();
    }

    public boolean isShutdown() {
        return executorService.isShutdown();
    }
}
