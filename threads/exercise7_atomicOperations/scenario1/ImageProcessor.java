package threads.exercise7_atomicOperations.scenario1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.IntStream;

// AI Guided & AI Copied
public class ImageProcessor {
    private List<BufferedImage> batchImages;
    private AtomicLong numberOfTasks;

    public void applyFilterConcurrently(BufferedImage image) {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processors);

        int sectionHeight = image.getHeight() / processors;
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < processors; i++) {
            int startY = i * sectionHeight;
            int endY = (i + 1) * sectionHeight;
            if (i == processors - 1) {
                endY = image.getHeight();
            }

            final int finalEndY = endY;

            // For filtering we will change the pixel's colour to grayscale equivalent (AI's idea)
            Runnable task = () -> {
                for (int y = startY; y < finalEndY; y++) {
                    for (int x = 0; x < image.getWidth(); x++) {
                        int rgb = image.getRGB(x, y);
                        // AI Copied - I do not know bitwise operations that well
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >> 8) & 0xFF;
                        int b = rgb & 0xFF;

                        int gray = ( r + g + b) / 3;

                        rgb = (gray << 16) + (gray << 8) + gray;
                        image.setRGB(x, y, rgb);
                    }
                }
            };

            futures.add(executor.submit(task));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public long getProcessingTime(BufferedImage image) {
        long start = System.nanoTime();
        applyFilterConcurrently(image);
        long end = System.nanoTime();

        return end - start;
    }

    public void applyFilterToBatch() {
        synchronized(batchImages) {
            for (BufferedImage bufferedImage : batchImages) {
                applyFilterConcurrently(bufferedImage);
            }
        }
    }

    public double getAverageProcessingTime() {
        List<Long> time = new ArrayList<>();
        synchronized(batchImages) {
            for (BufferedImage bufferedImage : batchImages) {
                time.add(getProcessingTime(bufferedImage));
            }
        }
        return time.stream().mapToDouble(result -> result).average().orElse(0.0);
    }

    public void applyFiltersConcurrently() {
        applyFilterToBatch();
    }

    public long getTotalProcessingTime() {
        long start = System.nanoTime();
        applyFilterToBatch();
        long end = System.nanoTime();

        return end - start;
    }

    public void applyTransformationConcurrently(BufferedImage image, Function<Integer, Integer> transformation) {
        ForkJoinPool pool = new ForkJoinPool();
        
        pool.submit(() -> {
            IntStream.range(0, image.getHeight()).parallel().forEach(y -> {
                for (int x = 0; x < image.getWidth(); x++) {
                    int rgb = image.getRGB(x, y);
                    int transformedRgb = transformation.apply(rgb);
                    image.setRGB(x, y, transformedRgb);
                }
                numberOfTasks.incrementAndGet();
            });
        });
    }

    public long getNumberOfTasks() {
        return numberOfTasks.get();
    }

}


