package threads.exercise6_handlingExceptions.scenario1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
// AI Guided & AI Copied
class Data {
    private AtomicInteger value;

    public AtomicInteger getValue() {
        return value;
    }

    public void setValue(AtomicInteger value) {
        this.value = value;
    }
}

class DataProcessingException extends Exception {
    public DataProcessingException() {
        super();
    }
}

class ThreadPoolException extends Exception {
    public ThreadPoolException() {
        super();
    }
}

class ConcurrentProcessingException extends Exception {
    public ConcurrentProcessingException() {
        super();
    }
}

class ExecutorServiceException extends Exception {
    public ExecutorServiceException() {
        super();
    }
}

class DataProcessor {
    private List<Data> dataList;
    private List<Data> results;

    void processData(List<Data> dataList, int nThreads) throws DataProcessingException {
        List<Data> list = Collections.synchronizedList(dataList);
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        AtomicInteger progress = new AtomicInteger();
        progress.set(0);

        for (int i = 0; i < nThreads; i++) {
            executor.submit(() -> {
                try {
                    int index;
                    while ((index = progress.getAndIncrement()) < list.size()) {
                        synchronized (list.get(index)) {
                            int val = list.get(index).getValue().get();
        
                            System.out.println("Processed and retrieved data fo value: " + val);
                        }   
                    }
                } catch (Exception e) {
                    throw new RuntimeException(new DataProcessingException());
                }
                });
            }

            executor.shutdown();
            try {
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                    if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                        throw new DataProcessingException();
                    }
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }

    List<Data> getResults() throws DataProcessingException {
        try {
            return results;
        } catch (Exception e) {
            throw new DataProcessingException();
        }
    }

    public List<Data> getDataList() {
        return dataList;
    }
}

class ThreadPool {
    private ExecutorService executorService;

    void createThreadPool(int n) throws ThreadPoolException {
        try {
            executorService = Executors.newFixedThreadPool(n);
        } catch (Exception e) {
            throw new ThreadPoolException();
        }
    }

    void shutdownThreadPool() throws ThreadPoolException {
        try {
            executorService.shutdown();
        } catch (Exception e) {
            throw new ThreadPoolException();
        }
    }
}

class ConcurrentDataProcessor {
    private List<Data> dataList;
    private List<Data> concurrentResults;

    void processDataConcurrently(List<Data> dataList) throws ConcurrentProcessingException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Data>> futures = new ArrayList<>();

        for (Data data : dataList) {
            Callable<Data> task = () -> {
                return data; // Processing would be done here
            };

            futures.add(executor.submit(task));
        }

        executor.shutdown();

        for (Future<Data> future : futures) {
            try {
                concurrentResults.add(future.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new ConcurrentProcessingException();
            }
        }
    }

    List<Data> getConcurrentResults() throws ConcurrentProcessingException {
        try {
            return concurrentResults;
        } catch (Exception e) {
            throw new ConcurrentProcessingException();
        }
    }

    public List<Data> getDataList() {
        return dataList;
    }
}

class ExecutorServiceProcessor {
    private ExecutorService executorService;
    private List<Data> executorServiceResults;

    void createExecutorService(int n) throws ExecutorServiceException {
        try {
            executorService = Executors.newFixedThreadPool(n);
        } catch (Exception e) {
            throw new ExecutorServiceException();
        }
    }

    void shutdownExecutorService() throws ExecutorServiceException {
        try {
            executorService.shutdown();
        } catch (Exception e) {
            throw new ExecutorServiceException();
        }
    }

    List<Data> getExecutorServiceResults() throws ExecutorServiceException {
        try {
            return executorServiceResults;
        } catch (Exception e) {
            throw new ExecutorServiceException();
        }
    }
}
