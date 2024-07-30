package files.exercise4_exceptionHandling.scenario2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimationAssetManager {

    // Task 1
    public List<String> findBrokenReferences(String directoryPath) {
        List<String> brokenReferences = new ArrayList<>();

        Path scanPath = Paths.get(directoryPath);
        File[] files = scanPath.toFile().listFiles();
        for (File file : files) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
                String contentPath = reader.readLine();
                if (!Files.exists(Paths.get(contentPath))) {
                    brokenReferences.add(contentPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return brokenReferences;   
    }

    public int fixBrokenReferences(String directoryPath, Map<String, String> replacements) {
        
        Path scanPath = Paths.get(directoryPath);
        File[] files = scanPath.toFile().listFiles();
        int fixedCount = 0;
        for (File file : files) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                 BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getAbsolutePath()));
            ) {
                String contentPath = reader.readLine();
                if (!Files.exists(Paths.get(contentPath))) {
                    writer.write(replacements.get(contentPath));
                    fixedCount++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fixedCount;


    }

    // Task 2
    public List<File> checkFilePermissions(String directoryPath) {
        File[] files = Paths.get(directoryPath).toFile().listFiles();
        List<File> noPermissions = new ArrayList<>();

        for (File file : files) {
            if (!file.canRead() || !file.canWrite()) {
                noPermissions.add(file);
            }
        }
        return noPermissions;
    }

    public int fixFilePermissions(String directoryPath) {
        File[] files = Paths.get(directoryPath).toFile().listFiles();
        int count = 0;

        for (File file : files) {
            if (!file.canRead() || !file.canWrite()) {
                file.setReadable(true);
                file.setWritable(true);
                count++;
            }
        }
        return count;
    }

    // Task 3
    public Map<File, Long> getLastModifiedTimes(String directoryPath) {
        File[] files = Paths.get(directoryPath).toFile().listFiles();
        Map<File, Long> mofifiedTimes = new HashMap<>();

        for (File file : files) {
            mofifiedTimes.put(file, file.lastModified());
        }

        return mofifiedTimes;
    }

    public boolean updateLastModifiedTime(String filePath, long newTime) {
        return Paths.get(filePath).toFile().setLastModified(newTime);
    }

    // Task 4
    public long measureReadPerformance(String filePath) {
        try {
            long start = System.nanoTime();
            Files.readAllLines(Paths.get(filePath));
            long end = System.nanoTime();
            return end - start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long measureWritePerformance(String filePath, String content) {
        try {
            long start = System.nanoTime();
            Files.write(Paths.get(filePath), content.getBytes());
            long end = System.nanoTime();
            return end - start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Map<String, Map<String, Long>> comparePerformance(String filePath1, String filePath2) {
        
        long write1 = measureWritePerformance(filePath1, "content");
        long write2 = measureWritePerformance(filePath2, "content");
        long read1 = measureReadPerformance(filePath1);
        long read2 = measureReadPerformance(filePath2);

        Map<String, Long> readWrite1 = new HashMap<>();
        Map<String, Long> readWrite2 = new HashMap<>();
        Map<String, Map<String, Long>> result = new HashMap<>();

        readWrite1.put("read", read1);
        readWrite1.put("write", write1);
        readWrite2.put("read", read2);
        readWrite2.put("write", write2);

        result.put(filePath1, readWrite1);
        result.put(filePath2, readWrite2);
        
        return result;
    }
}
