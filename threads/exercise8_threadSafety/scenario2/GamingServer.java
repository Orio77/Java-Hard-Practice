package threads.exercise8_threadSafety.scenario2;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Player {
    private String name;
    private String request;

    public String getName() {
        return name;
    }
    public String getRequest() {
        return request;
    }
}

class GamingServer {
    private ReentrantLock lock;
    private ConcurrentHashMap<Player, ReentrantLock> playerLocks;
    private ExecutorService executor;
    private AtomicInteger globalScore;
    private ForkJoinPool forkPool;

    public void processRequest(Player player) {
        lock.lock();

        try {
            System.out.println("Processing request of " + player.getName() + ":");
            System.out.println("Request: " + player.getRequest());
            
        } finally {
            lock.unlock();
        }
    }

    public synchronized void synchronizedProcessRequest(Player player) {

        System.out.println("Processing request of " + player.getName() + ":");
        System.out.println("Request: " + player.getRequest());

    }

    public void optimizedSynchronizedProcessRequest(Player player) {
        if (!playerLocks.containsKey(player)) {
            playerLocks.put(player, new ReentrantLock());
        }

        playerLocks.get(player).lock();

        try {
            System.out.println("Processing request of " + player.getName() + ":");
            System.out.println("Request: " + player.getRequest());
        } finally {
            playerLocks.get(player).unlock();
        }
    }

    public void threadPoolProcessRequest(Player player) {
        executor.submit(() -> {
            System.out.println("Processing request:" );
            System.out.println(player.getRequest());
        });
    }

    public void optimizedThreadPoolProcessRequest(Player player) {
        executor = Executors.newCachedThreadPool();

        executor.submit(() -> {
            System.out.println("Processing request:" );
            System.out.println(player.getRequest());
        });
    }

    public void atomicProcessRequest(Player player) {
        System.out.println("Player " + player.getName() + " scorred!");
        globalScore.incrementAndGet();
    }

    public void optimizedAtomicProcessRequest(Player player) {
        globalScore.accumulateAndGet(1, Integer::sum);
    }

    public void forkJoinProcessRequest(List<Player> players) {
        for (Player player : players) {
            forkPool.submit(() -> {
                System.out.println("Processing request:" );
                System.out.println(player.getRequest());
            });
        }
    }

    public void optimizedForkJoinProcessRequest(List<Player> players) {
        players.parallelStream().forEach(player -> {
            forkPool.submit(() -> {
                System.out.println("Processing request:" );
                System.out.println(player.getRequest());
            });
        });
    }

    public void comparePerformance(List<Player> players) {
        long start1 = System.nanoTime();
        forkJoinProcessRequest(players);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        optimizedForkJoinProcessRequest(players);
        long end2 = System.nanoTime();

        long result1 = end1 - start1;
        long result2 = end2 - start2;
        
        System.out.println("Optimized version took " + (result1 - result2) + "seconds less");
    }
}
