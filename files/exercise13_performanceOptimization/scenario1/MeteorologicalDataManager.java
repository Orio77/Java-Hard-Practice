package files.exercise13_.scenario1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeteorologicalDataManager {
    // Task 1
    public void readAndFilterData(String filePath, String outputFilePath, double temperatureThreshold) {
        try {
            List<String> filtered = Files.readAllLines(Paths.get(filePath)).stream().filter(file -> {
                int comaIndex = file.indexOf(',');
                String subs = file.substring(comaIndex + 1);
                Double.parseDouble(subs);
                if (Double.parseDouble(subs) > temperatureThreshold) {
                    return true;
                }
                return false;
            }).toList();

            Files.writeString(Paths.get(filePath), filtered.stream().collect(Collectors.joining()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double calculateAverageTemperature(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath)).stream().mapToDouble(str -> {
                int comaIndex = str.indexOf(',');
                String subs = str.substring(comaIndex + 1);
    
                return Double.parseDouble(subs);
            }).average().orElse(0.0);
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // Task 2
    public void setReadPermissions(String directoryPath) {
        Arrays.stream(Paths.get(directoryPath).toFile().listFiles()).forEach(file -> file.setReadable(true));
    }

    public List<String> readAllFiles(String directoryPath) {
        List<String> list = new ArrayList<>();
        Arrays.stream(Paths.get(directoryPath).toFile().listFiles()).forEach(file -> {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                list.add(reader.lines().collect(Collectors.joining()));
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return list;
    }

    // Task 3
    public BasicFileAttributes getFileAttributes(String filePath) {
        try {
            return Files.readAttributes(Paths.get(filePath), BasicFileAttributes.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> filterByDate(String filePath, LocalDateTime startDate, LocalDateTime endDate) {
        try {
            List<String> filtered = Files.readAllLines(Paths.get(filePath)).stream().filter(file -> {
                int comaIndex = file.indexOf(',');
                String subs = file.substring(0, comaIndex);
                String[] data = subs.split("-");
                LocalDateTime date = LocalDateTime.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), 0, 0);

                if (date.isAfter(endDate) || date.isBefore(startDate)) {
                    return true;
                }
                return false;
                
            }).toList();

            Files.writeString(Paths.get(filePath), filtered.stream().collect(Collectors.joining()));

            return filtered;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 4
    public Map<String, Double> readDataIntoMap(String filePath) {
        Map<String, Double> map = new HashMap<>();

        try {
            Files.readAllLines(Paths.get(filePath)).stream().forEach(str -> {
                int comaIndex = str.indexOf(',');
                String date = str.substring(0, comaIndex);
                Double temperature = Double.parseDouble(str.substring(comaIndex));
                map.put(date, temperature); 
            });
        } catch (IOException e) {
            e.printStackTrace();
        }        
        return map;
 
    }

    public double getTemperatureOnDate(String date, String filePath) {
        Map<String, Double> map = readDataIntoMap(filePath);
        return map.get(date);
    }

    public double getAverageTemperature(String filePath) {
        Map<String, Double> map = readDataIntoMap(filePath);
        return map.entrySet().stream().mapToDouble(Map.Entry::getValue).average().orElse(0);
    }
}
