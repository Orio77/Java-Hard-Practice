package threads.exercise10_threadStates.scenario3;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class MultilingualChatSystem {
    private AtomicInteger activeChats;
    private ThreadLocal<String> languagePreference;
    private Semaphore semaphore;
    private Object lock;
    private ExecutorService executor;
    private List<Agent> agents;

    public synchronized void synchronizedChat() {
        try {
            semaphore.acquire();
            System.out.println("Handling a customer");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            semaphore.release();
        }
    }

    public void interThreadCommunication() {
        synchronized(lock) {
            System.out.println("Agent needs assistance");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void supervisorIntervention() {
        synchronized(lock) {
            System.out.println("Providing assistance");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            lock.notify();
        }
    }

    public void threadPoolChat() {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    class Agent extends Thread {

        public boolean needsHelp() {
            return (new Random().nextInt(5) % 2 == 0);
        }
    }

    public void daemonSupervisor() {
        Thread supervisor = new Thread(() -> {
            while (activeChats.get() != 0) {
                for (Agent agent : agents) {
                    if (agent.needsHelp()) {
                        supervisorIntervention();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        supervisor.setDaemon(true);
        supervisor.start();
    }

    public void atomicChat() {
        try {
            semaphore.acquire();
            System.out.println("Handling a customer");
            activeChats.incrementAndGet();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            semaphore.release();
        }
    }

    public void threadLocalLanguage() {
        try {
            semaphore.acquire();
            System.out.println("Handling a customer");
            System.out.println("Chatting in: " + languagePreference.get());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            semaphore.release();
        }
    }

    public void executorChat() {
        try {
            executor.submit(() -> {
                System.out.println("Handling a customer");
            });
            activeChats.incrementAndGet();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void forkJoinTranslation(List<ThreadLocal<String>> tasks) {
        ForkJoinPool pool = new ForkJoinPool();

        pool.invoke(new TranslationRecursiveTask(tasks));
    }

    public void shutdownChat() {
        executor.shutdown();
        while (!executor.isShutdown()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        activeChats.set(0);
    }
}

class TranslationRecursiveTask extends RecursiveTask<Void> {
    private List<ThreadLocal<String>> languagePreference;

    public TranslationRecursiveTask(List<ThreadLocal<String>> languagePreference) {
        this.languagePreference = languagePreference;
    }

    @Override
    protected Void compute() {
        // parrallel streams inherently use fork join framework
        languagePreference.parallelStream().forEach(task -> {
            System.out.println("Translating customers message to " + task.get());
        });

        return null;
    }

}
