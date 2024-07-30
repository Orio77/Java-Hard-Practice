package threads.exercise18_performanceMonitoring.scenario2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

// Assuming Packet, NetworkTraffic, and NetworkData are predefined classes
class Packet {
    private String id;

    public String getId() {
        return id;
    }
}

class NetworkTraffic {
    private String name;

    public String getName() {
        return name;
    }
}

class NetworkData {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class NetworkPacketProcessor {
    private List<Packet> processedPackets;

    public synchronized void processPacket(Packet packet) {
        System.out.println("Processing packet " + packet.getId());
        processedPackets.add(packet);
    }

    public synchronized List<Packet> getProcessedPackets() {
        return Collections.unmodifiableList(processedPackets);
    }
}

class NetworkTrafficAnalyzer {
    private List<NetworkTraffic> analyzedTraffic;
    private ExecutorService executor;

    public void analyzeTraffic(NetworkTraffic traffic) {
        executor.submit(() -> {
            System.out.println("Analysing traffic " + traffic.getName());
        });
    }

    public List<NetworkTraffic> getAnalyzedTraffic() {
        return Collections.unmodifiableList(analyzedTraffic);
    }
}

class NetworkIntrusionDetector {
    private AtomicInteger intrusionCount;
    private ReentrantLock lock;

    public void detectIntrusion(NetworkData data) {
        lock.lock();
        try {
            for (int i = 0; i < 30; i++) {
                int num = new Random().nextInt(54);
                if (num % 17 == 0) {
                    intrusionCount.incrementAndGet();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public int getIntrusionCount() {
        return intrusionCount.get();
    }
}

class NetworkDataSorter {
    private List<NetworkData> sortedData;
    private ForkJoinPool pool;

    public void sortData(List<NetworkData> data) {
        pool.invoke(new SortTask(data));
    }

    public void mergeData(NetworkData data1, NetworkData data2) {
        data1.setContent(data1.getContent().concat(data2.getContent()));
    }

    public List<NetworkData> getSortedData() {
        return Collections.unmodifiableList(sortedData);
    }
}

class SortTask extends RecursiveTask<List<NetworkData>> {
    private List<NetworkData> data;

    public SortTask(List<NetworkData> data) {
        this.data = data;
    }

    @Override
    protected List<NetworkData> compute() {
        if (data.size() < 1) {
            return data;
        }

        int mid = data.size() / 2;
        SortTask left = new SortTask(data.subList(0, mid));
        SortTask right = new SortTask(data.subList(mid, data.size()));

        right.fork();
        List<NetworkData> leftResult = left.compute();
        List<NetworkData> rightResult = right.join();

        return merge(leftResult, rightResult);
    }

    private List<NetworkData> merge(List<NetworkData> left, List<NetworkData> right) {
        List<NetworkData> result = new ArrayList<>();
        int i =0, j =0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getContent().compareTo(right.get(j).getContent()) <= 0) {
                result.add(left.get(i++));
            }
            else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) {
            result.add(left.get(i++));
        }
        while (j < right.size()) {
            result.add(right.get(j++));
        }
        return result;
    }
}
