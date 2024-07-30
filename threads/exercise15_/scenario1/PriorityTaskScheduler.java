package threads.exercise15_.scenario1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import streamAPI.exercise4_collectors.scenario1.Pair;

public class PriorityTaskScheduler {
    private ExecutorService executor;
    private Queue<Pair<Runnable, Integer>> scheduler;
    ReentrantLock lock;

    public PriorityTaskScheduler(int nThreads) {
        executor = Executors.newFixedThreadPool(nThreads);
        scheduler = new PriorityQueue<Pair<Runnable, Integer>>(Comparator.comparing(pair-> pair.getItem2()));
        lock = new ReentrantLock();
    }

    // Task 1
    public void addTask(Runnable task, int priority) {
        scheduler.add(new Pair<Runnable,Integer>(task, priority));
    }

    public void executeTasks() {
        for (Pair<Runnable,Integer> pair : scheduler) {
            executor.submit(pair.getItem1());
        }
    }

    // Task 2
    public synchronized void synchronizedAddTask(Runnable task, int priority) {
        addTask(task, priority);
    }

    public synchronized void synchronizedExecuteTasks() {
        executeTasks();
    }

    // Task 3
    public void threadLocalAddTask(Runnable task, int priority) {
        ThreadLocal<Pair<Runnable, Integer>> local = new ThreadLocal<>();
        executor.submit(local.get().getItem1());
    }

    public void threadLocalExecuteTasks() {
        ThreadLocal<Queue<Pair<Runnable, Integer>>> local = new ThreadLocal<>();
        local.set(scheduler);

        Queue<Pair<Runnable, Integer>> localQueue = local.get();
        while (!localQueue.isEmpty()) {
            Pair<Runnable, Integer> task = localQueue.poll();
            executor.submit(task.getItem1());
        }
    }

    // Task 4
    public void executorAddTask(Runnable task, int priority) {
        executor.submit(scheduler.poll().getItem1());
    }

    public void executorExecuteTasks() {
        for (Pair<Runnable,Integer> pair : scheduler) {
            executor.submit(pair.getItem1());
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}
