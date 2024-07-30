package threads.exercise9_threadSafety.scenario3;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveTask;

class CandidateSolution {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class GeneticAlgorithm {
    private CandidateSolution[] population;

    public void generatePopulation(int size) {
        synchronized(population) {
            population = new CandidateSolution[size];
            for (int i = 0; i < population.length; i++) {
                final int position = i;
                new Thread(() -> {
                    population[position] = new CandidateSolution();
                }).start();
            }
        }
    }

    public Queue<String> evolvePopulation() {
        synchronized(population) {
            LinkedBlockingQueue<CandidateSolution> queue = new LinkedBlockingQueue<>(Arrays.asList(population));
            LinkedBlockingQueue<String> newGeneration = new LinkedBlockingQueue<>();

            while (!queue.isEmpty()) {

                CandidateSolution candidate1 = null;
                CandidateSolution candidate2 = null;

                try {
                    candidate1 = queue.take();
                    candidate2 = queue.take();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                final CandidateSolution finalCandidate1 = candidate1;
                final CandidateSolution finalCandidate2 = candidate2;

                new Thread(() -> {
                    System.out.println("Preparing crossover with " + finalCandidate1.getName() + " and " + finalCandidate2.getName());
                }).start();

                new Thread(() -> {
                    System.out.println("Creating new child");
                    newGeneration.add(finalCandidate1.getName() + "x" + finalCandidate2.getName());
                }).start();
            }
            return newGeneration;
        }
    }
}

class ThreadPoolGeneticAlgorithm {
    private ExecutorService executorService;
    private CandidateSolution[] population;

    public void initializeThreadPool(int size) {
        executorService = Executors.newFixedThreadPool(size);
    }

    public Queue<String> runGeneration(ExecutorService executorService, CandidateSolution[] population) {
        LinkedBlockingQueue<CandidateSolution> queue = new LinkedBlockingQueue<>(Arrays.asList(population));
        LinkedBlockingQueue<String> newGeneration = new LinkedBlockingQueue<>();

        while (!queue.isEmpty()) {

            CandidateSolution candidate1 = null;
            CandidateSolution candidate2 = null;

            try {
                candidate1 = queue.take();
                candidate2 = queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            final CandidateSolution finalCandidate1 = candidate1;
            final CandidateSolution finalCandidate2 = candidate2;

            executorService.submit(() -> {
                System.out.println("Preparing crossover with " + finalCandidate1.getName() + " and " + finalCandidate2.getName());
            });

            executorService.submit(() -> {
                System.out.println("Creating new child");
                newGeneration.add(finalCandidate1.getName() + "x" + finalCandidate2.getName());
            });
        }
        return newGeneration;
    }
    
    public ExecutorService getExecutorService() {
        return executorService;
    }
    public CandidateSolution[] getPopulation() {
        return population;
    }
}

class AtomicGeneticAlgorithm {
    private CandidateSolution[] population;
    private ThreadLocal<CandidateSolution> threadLocalBestSolution;

    public void initializePopulation(int size) {
        population = new CandidateSolution[size];

        for (int i = 0; i < size; i++) {
            final int position = i;
            new Thread(() -> {
                population[position] = new CandidateSolution();
            });
        }
    }

    public void runGenerationThreadLocal() {
        LinkedBlockingQueue<CandidateSolution> queue = new LinkedBlockingQueue<>(Arrays.asList(population));
        int size = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(size);
        threadLocalBestSolution = new ThreadLocal<>();
        threadLocalBestSolution.set(new CandidateSolution());

        for (int i = 0; i < size; i++) {
            executor.submit(() -> {
                threadLocalBestSolution.set(queue.poll());
            });
        }
        executor.shutdown();
    }
}

class ExecutorsForkJoinGeneticAlgorithm {
    private ExecutorService executorService;
    private ForkJoinPool forkJoinPool;
    private CandidateSolution[] population;

    public void initializeExecutors(int size) {
        executorService = Executors.newFixedThreadPool(size);
    }

    public void runGenerationExecutors() {
        ThreadPoolGeneticAlgorithm alg = new ThreadPoolGeneticAlgorithm();
        alg.runGeneration(executorService, population);
    }

    public void runGenerationForkJoin() {
        forkJoinPool = new ForkJoinPool();
    }
    public ForkJoinPool getForkJoinPool() {
        return forkJoinPool;
    }
}

class GeneticRecursiveTask extends RecursiveTask<CandidateSolution> {
    private List<CandidateSolution> population;

    public GeneticRecursiveTask(CandidateSolution[] population) {
        this.population = Arrays.asList(population);
    }
    
    @Override
    protected CandidateSolution compute() {
        if (population.size() < 10) {
            return computeDirectly();
        }
        int mid = population.size() / 2;
        List<CandidateSolution> population1 = population.subList(0, getForkJoinTaskTag());
        List<CandidateSolution> population2 = population.subList(mid, population.size());

        GeneticRecursiveTask task1 = new GeneticRecursiveTask(population1.toArray(new CandidateSolution[0]));
        GeneticRecursiveTask task2 = new GeneticRecursiveTask(population2.toArray(new CandidateSolution[0]));

        task1.fork();
        CandidateSolution result2 = task2.compute();
        CandidateSolution result1 = task1.join();


        return combine(result1, result2);
    }

    private CandidateSolution combine(CandidateSolution solution1, CandidateSolution solution2) {
        CandidateSolution result = new CandidateSolution();
        result.setName(solution1.getName() + "x" + solution2.getName());

        return result;
    }

    private CandidateSolution computeDirectly() {
        int i = 0;
        //  Simulate processing
        for (i = 0; i < population.size() - 2; i++) {
            combine(population.get(i), population.get(i - 1));
        }

        return combine(population.get(i), population.get(i - 1));
    }


    public List<CandidateSolution> getPopulation() {
        return population;
    }
}