package files.exercise16_bestPractces.scenario2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MediaFileManager {

    // Task 1
    public Map<String, Map<String, Object>> extractMetadata(String directoryPath) {
        try {
            File[] files = Paths.get(directoryPath).toFile().listFiles();
            Map<String, Map<String, Object>> map = new HashMap<>();

            for (File file : files) {
                Map<String, Object> attrs = Files.readAttributes(file.toPath(), "*");
                map.put(file.getName(), attrs);
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void modifyMetadata(String filePath, Map<String, Object> newMetadata) {
        Path path = Paths.get(filePath);
        try {
            for (Map.Entry<String, Object> entry : newMetadata.entrySet()) {
                Files.setAttribute(path, entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public Map<String, Map<String, Boolean>> checkPermissions(String directoryPath) {
        File[] files = Paths.get(directoryPath).toFile().listFiles();
        Map<String, Map<String, Boolean>> map = new HashMap<>();

        for (File file : files) {
            Map<String, Boolean> attrs = new HashMap<>();
            attrs.put("canRead", file.canRead());
            attrs.put("canWrite", file.canWrite());
            attrs.put("canExecute", file.canExecute());
        }
        return map;
    }

    public void changePermissions(String filePath, Map<String, Boolean> newPermissions) {
        File file = Paths.get(filePath).toFile();

        for (Map.Entry<String, Boolean> entry : newPermissions.entrySet()) {
            switch (entry.getKey()) {
                case "canRead":
                    file.setReadable(entry.getValue());
                    break;
                case "canWrite":
                    file.setWritable(entry.getValue());
                    break;
                case "canExecute":
                    file.setExecutable(entry.getValue());
                    break;
                default:
                    break;
            }
        }
    }

    // Task 3
    public void compressFiles(String directoryPath, String outputPath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))){
            
            File[] files = Paths.get(directoryPath).toFile().listFiles();
            BufferedReader reader = null;

            for (File file : files) {
                reader = Files.newBufferedReader(file.toPath());
                writer.write(reader.lines().collect(Collectors.joining("\n")));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decompressFile(String filePath, String outputPath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            List<String> contents = reader.lines().map(content -> content.split("\n\n")).flatMap(str -> Arrays.stream(str)).toList();

            BufferedWriter writer = null;
            int fileCount = 1;
            for (String content : contents) {
                writer = Files.newBufferedWriter(Paths.get(outputPath, "\file" + fileCount + ".txt"));
                writer.write(content);
                fileCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public Map<String, List<String>> categorizeFiles(Map<File, String> fileCategoryMap) {
        return fileCategoryMap.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(entry -> entry.getKey().getName(), Collectors.toList())));
    }

    public String searchFile(String directoryPath, String fileType, String fileName) {
  
        File[] files = Paths.get(directoryPath).toFile().listFiles();
        for (File file : files) {
            if (file.getAbsolutePath().matches(fileName + fileType)) {
                return file.getAbsolutePath();
            }
        }

        return "File not found";

    }

    public List<String> sortFiles(String directoryPath, String fileType) {
        List<File> files = Arrays.stream(Paths.get(directoryPath).toFile().listFiles()).toList();

        return files.stream().sorted(Comparator.comparing(File::length).reversed()).map(File::getName).toList();
    }
}