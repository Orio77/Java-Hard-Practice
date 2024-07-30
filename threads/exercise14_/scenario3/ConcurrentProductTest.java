package threads.exercise14_.scenario3;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.AtomicDouble;

class ProductTest implements Runnable {
    private String productID;
    private AtomicDouble physicalTestResult;
    private AtomicDouble chemicalTestResult;

    public ProductTest(String productID) {
        this.productID = productID;
    }

    @Override
    public void run() {
        new Thread(() -> {
            physicalTest();
        }).start();

        new Thread(() -> {
            chemicalTest();
        }).start();
    }

    public void physicalTest() {
        try {
            System.out.println("Performing physical test");
            Thread.sleep(5000);
            physicalTestResult.set(new Random().nextDouble(100.1));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
    }

    public void chemicalTest() {
        while (physicalTestResult.get() == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            System.out.println("Performing chemical test");
            Thread.sleep(3000);
            chemicalTestResult.set(new Random().nextDouble(100.1));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public AtomicDouble getChemicalTestResult() {
        return chemicalTestResult;
    }
    public AtomicDouble getPhysicalTestResult() {
        return physicalTestResult;
    }
    public String getProductID() {
        return productID;
    }
}

class ConcurrentProductTest {
    private AtomicInteger passedTests;
    private ExecutorService threadPool;

    public void testProduct(int productId) {
        ProductTest product = new ProductTest(Integer.toString(productId));
        threadPool.submit(product);

        if (product.getChemicalTestResult().get() != 0) {
            passedTests.incrementAndGet();
        }
        if (product.getPhysicalTestResult().get() != 0) {
            passedTests.incrementAndGet();
        }
    }
}

class TimedProductTest {
    private ExecutorService executorService;

    public void startTest(int productId) {
        executorService.submit(new ProductTest(Integer.toString(productId)));
    }

    public void stopTest(int productId) {
        executorService.shutdownNow();
    }
}

class BatchProductTest {
    private ForkJoinPool forkJoinPool;
    private ConcurrentLinkedQueue<ProductTest> products;

    public ConcurrentLinkedQueue<ConcurrentLinkedQueue<ProductTest>> divideBatch(int batchSize) {
        ConcurrentLinkedQueue<ConcurrentLinkedQueue<ProductTest>> subBatches = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedQueue<ProductTest> subBatch;
        for (int i = 0; i < (products.size() / 10); i++) {
            subBatch = new ConcurrentLinkedQueue<>();
            for (int j = 0; j < (products.size() / 10); j++) {
                    subBatch.add(products.poll());
                }
                subBatches.add(subBatch);
        }
        return subBatches;
    }

    public void testSubBatch(ConcurrentLinkedQueue<ConcurrentLinkedQueue<ProductTest>> subBatches) {
        while (!subBatches.isEmpty()) {
            Thread outerThread = new Thread(() -> {
                ConcurrentLinkedQueue<ProductTest> subBatch = subBatches.poll();
                while (!subBatch.isEmpty()) {
                    Thread innerThread = new Thread(() -> {
                        ProductTest product = subBatch.poll();
                        forkJoinPool.submit(product);
                    });

                    innerThread.setPriority(Thread.MAX_PRIORITY);
                    forkJoinPool.submit(innerThread);
                }
            });
            outerThread.setPriority(Thread.MAX_PRIORITY / 2);
            forkJoinPool.submit(outerThread);
        }
    }

    public void combineResults(int batchSize) {
        ConcurrentLinkedQueue<ProductTest> results = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedQueue<ConcurrentLinkedQueue<ProductTest>> subBatches = divideBatch(batchSize);

        for (ConcurrentLinkedQueue<ProductTest> test : subBatches) {
            results.addAll(test);
        }
    }
}
