package threads.exercise7_atomicOperations.scenario2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;

class NetworkPacket {
    private String name;

    public String getName() {
        return name;
    }
}

class NetworkTraffic extends RecursiveTask<Void> {
    private String name;

    @Override
    protected Void compute() {
        System.out.println("Analysing " + name + " traffic");
        return null;
    }
}

class AnalysisResult {
    private double successRate;

    public double getSuccessRate() {
        return successRate;
    }
    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }
}

class NetworkPacketProcessor {
    private BlockingQueue<NetworkPacket> packetQueue;

    public synchronized void receivePacket(NetworkPacket packet) {
        packetQueue.add(packet);
    }

    public synchronized NetworkPacket processPacket() {
        if (packetQueue.isEmpty()) {
            return null;
        }

        return packetQueue.poll();
    }
}

class ConcurrentNetworkMonitor {
    AtomicLong packetCount;

    public void monitorTraffic(NetworkTraffic traffic) {
        System.out.println("Monitoring new Traffic");

        packetCount.incrementAndGet();
    }

    public long getPacketCount() {
        return packetCount.get();
    }
}

class NetworkExecutor {
    ExecutorService executorService;

    public void submitPacket(NetworkPacket packet) {
        executorService.submit(() -> {
            System.out.println("Processing new packet " + packet.getName());
        });
    }

    public boolean isProcessingComplete() {
        return executorService.isShutdown();
    }
}

class NetworkAnalyzer {
    ForkJoinPool forkJoinPool;
    private AnalysisResult result;

    public void analyzeTraffic(NetworkTraffic traffic) {
        forkJoinPool.submit(traffic);
        result.setSuccessRate(new Random().nextDouble() * 100);
    }

    public boolean isAnalysisComplete() {
        return forkJoinPool.isQuiescent();
    }

    public AnalysisResult getAnalysisResult() {
        return result;
    }
}
