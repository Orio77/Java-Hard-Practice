package threads.exercise13_threadSafetyPatterns.scenario1;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class VideoEncoderService {

    // Task 1
    public void encodeVideo(File videoFile) {
        VideoEncoder encoder = new VideoEncoder(videoFile);
        encoder.run();
    }

    // Task 2
    public ExecutorService createThreadPool(int numberOfThreads) {
        return Executors.newFixedThreadPool(numberOfThreads);
    }

    public void encodeVideos(List<File> videoFiles) {
        for (File file : videoFiles) {
            encodeVideo(file);
        }
    }

    // Task 3
    public ExecutorService createExecutorService(int numberOfThreads) {
        return Executors.newFixedThreadPool(numberOfThreads);
    }

    // Task 4
    public void createForkJoinPool() {
        new ForkJoinPool();
    }

    public void tunePerformance(List<File> videoFiles) {
        videoFiles.parallelStream().forEach(video -> {
            encodeVideo(video);
        });
    }
}

/**
 * VideoEncoder implements Runnable
 */
class VideoEncoder implements Runnable {
    private File vidFile;

    public VideoEncoder(File vidFile) {
        this.vidFile = vidFile;
    }

    @Override
    public void run() {
        System.out.println("Encoding video: " + vidFile.getName());
        notifyWhenDone();
    }

    public File getVidFile() {
        return vidFile;
    }

    private void notifyWhenDone() {
        synchronized(this) {
            notify();
        }
    }
}
