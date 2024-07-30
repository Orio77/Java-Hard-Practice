package threads.exercise10_deadlocks.scenario2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

class DeadlockDetector {
    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;
    private Stack<Integer> recursionStack;

    // Here a graph would be created out of the thread list (relationships included)
    public DeadlockDetector(List<Thread> threads) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        recursionStack = new Stack<>();
    }
    

    public boolean detectDeadlock() {
        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                if (DFS(node)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean DFS(Integer node) {
        visited.add(node);
        recursionStack.add(node);

        for (Integer neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                if (DFS(neighbor)) {
                    return true;
                }
            }
            else if (recursionStack.contains(neighbor)) {
                return true;
            }
        }
        recursionStack.remove(node);
        return false;
    }

    public List<Thread> resolveDeadlock() {
        while (detectDeadlock()) {
            Integer nodeToKill = recursionStack.iterator().next();
            killThread(nodeToKill);
        }
        return new ArrayList<>();
    }

    private void killThread(Integer threadID) {
        graph.remove(threadID);
        for (List<Integer> dependencies : graph.values()) {
            dependencies.remove(threadID);
        }
    }
}

class PriorityThreadManager {
    private List<Thread> threads;
    

    public void setPriorities() {
        for (Thread thread : threads) {
            thread.setPriority(new Random().nextInt(Thread.MAX_PRIORITY));
        }
    }

    public void runThreads() {
        threads.sort(Comparator.comparing(Thread::getPriority));

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class LockManager {
    private List<Thread> threads;
    private List<Lock> freeLocks;
    private List<Lock> occupiedLocks;
    

    public void acquireLocks() {
        try {
            for (int i = 0; i < threads.size(); i++) {
                if (freeLocks.isEmpty()) {
                    wait();
                }

                Lock acquiredLock = freeLocks.iterator().next();
                freeLocks.remove(acquiredLock);
                occupiedLocks.add(acquiredLock);
                acquiredLock.lock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void releaseLocks() {
        
    }
}

class AtomicVariableManager {
    private List<Thread> threads;
    private List<AtomicInteger> atomicVariables;
    

    public void initializeVariables() {
        atomicVariables = new ArrayList<>();
    }

    public void updateVariables() {
        for (AtomicInteger atomicInteger : atomicVariables) {
            atomicInteger.incrementAndGet();
        }
    }

    public boolean checkDeadlock() {
        DeadlockDetector detector = new DeadlockDetector(threads);
        return detector.detectDeadlock();
    }
}
