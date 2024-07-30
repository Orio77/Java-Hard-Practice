package threads.exercise17_concurrencyBestPractices.scenario1;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class DataTransferManager {
    protected Map<String, Integer> serverDataMap;

    public void initiateTransfer(int dataSize, int numberOfServers) {

        int data = dataSize / numberOfServers;

        serverDataMap.keySet().stream().limit(numberOfServers).parallel().forEach(key -> {
            serverDataMap.replace(key, serverDataMap.get(key) + data);
        });
    }

    public List<Map<String, Integer>> getTransferStatus() {
        return serverDataMap.entrySet().stream().collect(Collectors.groupingBy(Map.Entry<String, Integer>::getKey, Collectors.summingInt(Map.Entry<String, Integer>::getValue))).entrySet().stream().toList().stream().map(es -> {
            return Map.of(es.getKey(), es.getValue());
        }).toList();
    }
}

class SynchronizedDataTransferManager extends DataTransferManager {

    @Override
    public synchronized void initiateTransfer(int dataSize, int numberOfServers) {
        super.initiateTransfer(dataSize, numberOfServers);
    }

    @Override
    public synchronized List<Map<String, Integer>> getTransferStatus() {
        return super.getTransferStatus();
    }
}

class ThreadPoolDataTransferManager extends DataTransferManager {
    private ExecutorService executor;

    @Override
    public void initiateTransfer(int dataSize, int numberOfServers) {
        executor.submit(() -> {
            super.initiateTransfer(dataSize, numberOfServers);
        });
    }
}



class AtomicDataTransferManager extends DataTransferManager {
    private AtomicInteger totalDataTransferred;

    @Override
    public void initiateTransfer(int dataSize, int numberOfServers) {
        super.initiateTransfer(dataSize, numberOfServers);
    }

    @Override
    public List<Map<String, Integer>> getTransferStatus() {
        return super.getTransferStatus();
    }

    public int getTotalDataTransferred() {
        return totalDataTransferred.get();
    }
}
