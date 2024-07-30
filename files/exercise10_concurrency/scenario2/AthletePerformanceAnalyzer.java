package files.exercise10_concurrency.scenario2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AthletePerformanceAnalyzer {

    // Task 1
    public List<File> readAndSortFiles(String directory) {
        File[] files = Paths.get(directory).toFile().listFiles();

        return Arrays.stream(files).sorted(Comparator.comparing(File::length)).toList();
    }

    public Map<String, List<Double>> aggregateSensorData(List<File> files) {
        
        return files.parallelStream().collect(Collectors.toMap(File::getName, (File file) -> {
            try {
                List<Double> lines = Files.lines(Paths.get(file.getAbsolutePath())).mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());
                return lines;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }));
    }

    // Task 2
    public List<File> checkAndFixPermissions(String directory) {
        return Arrays.stream(Paths.get(directory).toFile().listFiles()).parallel().map(file -> {
            file.setReadable(true);
            return file;
        }).toList();
    }

    public Map<String, List<Double>> readFiles(List<File> files) {
        return files.parallelStream().collect(Collectors.toMap(File::getName, (File file) -> {
            try {
                List<String> content = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                return content.stream().map(str -> Double.parseDouble(str)).toList();
            }
            catch (IOException e){
                e.printStackTrace();
                return null;
            }
        }));
    }

    // Task 3
    public List<File> sortFilesByCreationTime(String directory) {
        return Arrays.stream(Paths.get(directory).toFile().listFiles()).parallel().sorted(Comparator.comparing((File file) -> {
            try {
                return Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime().toMillis();
            }
            catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        })).toList();

    }

    public Map<String, Double> readAndAverageSensorData(List<File> files) {
        return files.parallelStream().collect(Collectors.toMap(File::getName, (File file) -> {
            try {
                BufferedReader reader = Files.newBufferedReader(file.toPath());
                Double result = reader.lines().mapToDouble(Double::parseDouble).average().orElse(0.0);
                reader.close();
                return result;
            }
            catch (IOException e) {
                e.printStackTrace();
                return 0.0;
            }
        }));
    }

    // Task 4
    public List<File> readFiles(String directory) {
        return Arrays.stream(Paths.get(directory).toFile().listFiles()).parallel().toList();
    }

    public Map<String, List<Double>> parseSensorData(List<File> files) {
        return aggregateSensorData(files);
    }

    public Map<String, Double> findPeakPerformance(Map<String, List<Double>> sensorData) {
        
        return sensorData.entrySet().stream().map(es -> {
            List<Double> data = es.getValue();
            Double max = data.stream().max(Comparator.naturalOrder()).orElse(0.0);
            
            return Map.entry(es.getKey(), max);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
