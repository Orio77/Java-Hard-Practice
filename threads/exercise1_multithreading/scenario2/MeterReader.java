package threads.exercise1_multithreading.scenario2;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;

class MeterReader implements Runnable {
    private String data;
    private GridController gridController;

    public void sendData() {
        gridController.receiveData(data);
    }

    public void readData() {
        gridController.receiveData(data);
    }

    @Override
    public void run() {
        readData();
    }
}

class GridController {
    private List<String> dataList;

    public synchronized void receiveData(String data) {
        synchronized(this) {
            dataList.add(data);
        }
    }
}

class SmartGrid {
    private ExecutorService executorService;

    public void addMeter(MeterReader meter) {
        executorService.execute(meter);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

class AtomicMeterReader extends MeterReader {
    private AtomicInteger dataCount;

    @Override
    public void sendData() {
        super.sendData();
        dataCount.incrementAndGet();
    }

    public int getDataCount() {
        return dataCount.get();
    }
}

class DataAnalyzer extends RecursiveTask<Integer> {
    private List<String> data;
    private static final int THRESHOLD = 100;

    public DataAnalyzer(List<String> data) {
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if (data.size() <= THRESHOLD) {
            return analyzeDirectly();
        }
        else {
            int mid = data.size() / 2;
            DataAnalyzer firstSubtask = new DataAnalyzer(data.subList(0, mid));
            DataAnalyzer secondSubstask = new DataAnalyzer(data.subList(mid, data.size()));

            firstSubtask.fork();
            Integer secondSubtaskResult = secondSubstask.compute();
            Integer firstSubtaskResult = firstSubtask.join();

            return firstSubtaskResult + secondSubtaskResult;
        }
    }

    public Integer analyzeDirectly() {
        return data.size();
    }
}
