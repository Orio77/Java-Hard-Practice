package files.exercise5_buffering.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Campaign {
    private String campaignID;
    private String platform;
    private double metric1;
    private double metric2;
    private double metric3;

    public Campaign(String campaignID, String platform, double metric1, double metric2, double metric3) {
        this.campaignID = campaignID;
        this.platform = platform;
        this.metric1 = metric1;
        this.metric2 = metric2;
        this.metric3 = metric3;
    }
    
    public Campaign(String campaignID, String platform, double metric1) {
        this.campaignID = campaignID;
        this.platform = platform;
        this.metric1 = metric1;
    }

    public String getCampaignID() {
        return campaignID;
    }
    public double getMetric1() {
        return metric1;
    }
    public double getMetric2() {
        return metric2;
    }
    public double getMetric3() {
        return metric3;
    }
    public String getPlatform() {
        return platform;
    }
}

class BufferedCampaignDataAnalyzer {

    // Task 1
    public List<Campaign> readCampaignData(String filePath)  {
        List<Campaign> campaigns = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            reader.lines().toList().forEach(line -> {
                String[] data = line.split(";");
                campaigns.add(new Campaign(data[0], data[1], Double.parseDouble(data[2])));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return campaigns;
    }

    public Map<String, double[]> analyzeCampaignData(List<Campaign> campaigns) {
        return campaigns.stream().collect(Collectors.groupingBy(Campaign::getPlatform)).entrySet().stream().map(entry -> {
            double avg1 = entry.getValue().stream().mapToDouble(Campaign::getMetric1).average().orElse(0.0);
            double avg2 = entry.getValue().stream().mapToDouble(Campaign::getMetric2).average().orElse(0.0);
            double avg3 = entry.getValue().stream().mapToDouble(Campaign::getMetric3).average().orElse(0.0);

            double[] averages = new double[3];
            averages[0] = avg1;
            averages[1] = avg2;
            averages[2] = avg3;

            return Map.entry(entry.getKey(), averages);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

class BufferedFilePermissionsChecker {

    // Task 2
    public boolean checkReadPermission(String filePath) {
        return Paths.get(filePath).toFile().canRead();
    }

    public boolean checkWritePermission(String filePath) {
        return Paths.get(filePath).toFile().canWrite();
    }
}

class BufferedFileAttributesReader {

    // Task 3
    public long readFileSize(String filePath)  {
        return Paths.get(filePath).toFile().length();
    }

    public FileTime readFileCreationTime(String filePath)  {
        try {
            return (FileTime) Files.getAttribute(Paths.get(filePath), "basic:creationTime");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class BufferedFilePerformanceOptimizer {

    // Task 4
    public long optimizeReadPerformance(String filePath)  {
        List<Campaign> campaigns = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            long start = System.nanoTime();
            reader.lines().toList().forEach(line -> {
                String[] data = line.split(";");
                campaigns.add(new Campaign(data[0], data[1], Double.parseDouble(data[2])));
            });
            long end = System.nanoTime();
            return end - start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long optimizeWritePerformance(String filePath, List<String> data)  {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            long start = System.nanoTime();
            for (String string : data) {
                writer.write(string);
            }
            long end = System.nanoTime();
            return end - start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String comparePerformance(String filePath, List<String> data)  {
        long write = optimizeWritePerformance(filePath, data);
        long read = optimizeReadPerformance(filePath);
        if (read < write) {
            return "Reading was faster than writing";
        }
        else {
            return "Writing was faster than reading";
        }
    }
}
