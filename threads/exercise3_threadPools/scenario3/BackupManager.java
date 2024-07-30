package threads.exercise3_threadPools.scenario3;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Server {
    private String ip;

    public String getIp() {
        return ip;
    }
}

class BackupManager {
    private List<Server> servers;

    public void initiateBackup() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            for (Server server : servers) {
                new Thread(() -> {
                    System.out.println("Backing up server " + server.getIp());
                }).start();
            }
        } finally {
            lock.unlock();
        }
    }

    public void monitorBackupProgress() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            for (Server server : servers) {
                new Thread(() -> {
                    try {
                        System.out.println("Backing up server " + server.getIp());
                        Thread.sleep(1);
                        System.out.println("Backing up of server " + server.getIp() + " finished");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        } finally {
            lock.unlock();
        }
    }
}

class SynchronizedBackupManager {
    private List<Server> servers;

    public void synchronizedBackup() {
        synchronized(servers) {
            for (Server server : servers) {
                new Thread(() -> {
                    System.out.println("Backing up server " + server.getIp());
                }).start();
            }
        }
    }

    public void monitorSynchronizedBackup() {
        synchronized(servers) {
            for (Server server : servers) {
                new Thread(() -> {
                    try {
                        System.out.println("Backing up server " + server.getIp());
                        Thread.sleep(1);
                        System.out.println("Backing up of server " + server.getIp() + " finished");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }
    }
}

class ThreadPoolBackupManager {
    private List<Server> servers;
    private int numThreads;

    public void efficientBackup() {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (Server server : servers) {
            executor.submit(() -> {
                System.out.println("Backing up server " + server.getIp());
            });
        }
    }

    public void monitorEfficientBackup() {
        for (Server server : servers) {
            try {
                System.out.println("Backing up server " + server.getIp());
                Thread.sleep(1);
                System.out.println("Backing up of server " + server.getIp() + " finished");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }   
    }
}

class AtomicBackupManager {
    private List<Server> servers;
    private AtomicInteger totalBackupProgress;

    public void atomicBackup() {
        for (Server server : servers) {
            new Thread(() -> {
                System.out.println("Backing up server " + server.getIp());
                totalBackupProgress.incrementAndGet();
            }).start();
        }
    }

    public void monitorAtomicBackup() {
        for (Server server : servers) {
            new Thread(() -> {
                System.out.println("Backing up server " + server.getIp());
                System.out.println("Current servers backed up " + totalBackupProgress.getAndIncrement());
            }).start();
        }
    }

    public int getTotalBackupProgress() {
        return totalBackupProgress.get();
    }
}
