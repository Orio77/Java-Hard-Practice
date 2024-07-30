package threads.exercise12_threadDebugging.scenario2;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

class SimulationRunner {
    private AtomicBoolean running;
    
    

    public boolean runSimulations(int n) {
        running = new AtomicBoolean(true);
        for (int i = 0; i < n; i++) {
            new Thread(() -> {
                while (running.get()) {
                    for (int j = 0; j < new Random().nextInt(100); j++) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }).start();
        }
        return true;
    }

    public void stopSimulations() {
        running.set(false);
    }
    public AtomicBoolean getRunning() {
        return running;
    }
}

class SynchronizedSimulationRunner extends SimulationRunner {
    
    

    @Override
    public synchronized boolean runSimulations(int n) {
        return super.runSimulations(n);
    }

    @Override
    public synchronized void stopSimulations() {
        super.stopSimulations();
    }
}

class ThreadPoolSimulationRunner extends SimulationRunner {
    private ExecutorService executorService;
    

    @Override
    public boolean runSimulations(int n) {
        for (int i = 0; i < n; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < new Random().nextInt(100); j++) {
                    try {
                        wait(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
        return true;
    }

    @Override
    public void stopSimulations() {
        executorService.shutdown();
    }
}

class DeadlockFreeSimulationRunner extends SimulationRunner {

    @Override
    public boolean runSimulations(int n) {
        return super.runSimulations(n);
    }

    @Override
    public void stopSimulations() {
        super.stopSimulations();
    }

    // My implementation
    // public boolean isDeadlocked(int n) {
    //     long start = System.nanoTime();
    //     boolean verdict = false;

    //     while (start - System.nanoTime() < n*101) {
    //         verdict = runSimulations(n);
    //     }

    //     return verdict;
    // }

    // Correct Implementation
    public boolean isDeadlocked() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();

        if (deadlockedThreads != null && deadlockedThreads.length > 0) {
            return true;
        }

        return false;
    }
}