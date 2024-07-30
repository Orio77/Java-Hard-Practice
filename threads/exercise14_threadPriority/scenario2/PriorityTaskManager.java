package threads.exercise14_threadPriority.scenario2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

class PriorityTaskManager {
    private ConcurrentHashMap<Runnable, Integer> manager;
    

    public void addTask(int priority, Runnable task) {
        manager.put(task, priority);
    }

    public void runTasks() {
        manager.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue));
        for (Map.Entry<Runnable, Integer> entry : manager.entrySet()) {
            entry.getKey().run();
        }
    }
}

class ThreadSafePriorityTaskManager extends PriorityTaskManager {
    
    

    @Override
    public synchronized void addTask(int priority, Runnable task) {
        super.addTask(priority, task);
    }

    @Override
    public synchronized void runTasks() {
        super.runTasks();
    }
}

class PriorityTaskExecutor {
    private ExecutorService executor;
    

    public <T> Future<T> submitTask(Callable<T> task) {
        return executor.submit(task);
    }

    public void shutdown() {
        executor.shutdown();
    }
}

class PriorityTaskForkJoinPool<T> {
    private ForkJoinPool pool;
    private List<RecursiveTask<T>> tasks;
    

    public ForkJoinTask<T> submitTask(RecursiveTask<T> task) {
        return pool.submit(task);
    }

    public void invokeAllTasks() {

        for (RecursiveTask<T> forkJoinTask : tasks) {
            pool.submit(forkJoinTask);
        }

    }

    public void shutdown() {
        pool.shutdown();
    }
}
