package files.exercise9_resourceManagement.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class EnvironmentalDataProcessor {
    public List<Double> readAndProcessData(String inputFile, double threshold) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            reader.lines().mapToDouble(line -> Double.parseDouble(line)).average().orElse(0.0);
            return reader.lines().map(line -> Double.parseDouble(line)).filter(data -> data < threshold).toList();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public int writeDataToFile(List<Double> data, String outputFile) {
        if (!Files.exists(Paths.get(outputFile))) {
            try {
                Files.createDirectories(Paths.get(outputFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile), StandardOpenOption.APPEND)) {
            int writtenCount = 0;
            for (Double content : data) {
                writer.write(Double.toString(content));
                writtenCount++;
            }
            return writtenCount;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

    }
}

class FilePermissionChecker {
    public boolean checkPermissions(String filePath) {
        if (Files.exists(Paths.get(filePath))) {
            return (Paths.get(filePath).toFile().canRead() && Paths.get(filePath).toFile().canWrite());
        }
        return false;
    }

    public int readAndWriteData(String inputFile, String outputFile) {
        File inFile = Paths.get(inputFile).toFile();
        File outFile = Paths.get(outputFile).toFile();

        if (inFile.canRead() && outFile.canWrite()) {
            try (BufferedReader reader = Files.newBufferedReader(inFile.toPath());
                 BufferedWriter writer = Files.newBufferedWriter(outFile.toPath())) {
                
                Double avg = reader.lines().mapToDouble(line -> Double.parseDouble(line)).average().orElse(0.0);
                writer.write(avg.toString());
                return 1;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }
}

class FileAttributeTracker {
    public Map<String, Object> readAndProcessData(String inputFile, double threshold) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            reader.lines().mapToDouble(line -> Double.parseDouble(line)).average().orElse(0.0);
            reader.lines().map(line -> Double.parseDouble(line)).filter(data -> data < threshold).toList();

            return Files.readAttributes(Paths.get(inputFile), "size,lastModifiedTime");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Object> writeDataToFile(List<Double> data, String outputFile) {

        if (!Files.exists(Paths.get(outputFile))) {
            try {
                Files.createDirectories(Paths.get(outputFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile), StandardOpenOption.APPEND)) {
            @SuppressWarnings("unused")
            int writtenCount = 0;
            for (Double content : data) {
                writer.write(Double.toString(content));
                writtenCount++;
            }
            return Files.readAttributes(Paths.get(outputFile), "size,lastModifiedTime");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean compareFileAttributes(Map<String, Object> inputAttributes, Map<String, Object> outputAttributes) {
        return (inputAttributes.get("size").equals(outputAttributes.get("size")) && inputAttributes.get("lastModifiedTime").equals(outputAttributes.get("lastModifiedTime")));
    }
}

class PerformanceMeasurer {
    public long readAndProcessData(String inputFile, double threshold) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            long start = System.nanoTime();
            reader.lines().mapToDouble(line -> Double.parseDouble(line)).average().orElse(0.0);
            reader.lines().map(line -> Double.parseDouble(line)).filter(data -> data < threshold).toList();
            long end = System.nanoTime();
            return end-start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long writeDataToFile(List<Double> data, String outputFile) {
        if (!Files.exists(Paths.get(outputFile))) {
            try {
                Files.createDirectories(Paths.get(outputFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile), StandardOpenOption.APPEND)) {
            @SuppressWarnings("unused")
            int writtenCount = 0;
            long start = System.nanoTime();
            for (Double content : data) {
                writer.write(Double.toString(content));
                writtenCount++;
            }
            long end = System.nanoTime();
            return end-start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long measureTotalTime(String inputFile, double threshold, List<Double> data, String outputFile) {
        long start = System.nanoTime();
        readAndProcessData(inputFile, threshold);
        writeDataToFile(null, outputFile);
        long end = System.nanoTime();
        return end-start;
    }
}
