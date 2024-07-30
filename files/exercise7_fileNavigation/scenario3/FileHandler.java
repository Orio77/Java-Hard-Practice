package files.exercise7_fileNavigation.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class ProductionRecord {
    private String productName;
    private int quantityProduced;
    private Date productionDate;

    public ProductionRecord(String productName, int quantityProduced, Date productionDate) {
        this.productName = productName;
        this.quantityProduced = quantityProduced;
        this.productionDate = productionDate;
    }
    public String getProductName() {
        return productName;
    }
    public Date getProductionDate() {
        return productionDate;
    }
    public int getQuantityProduced() {
        return quantityProduced;
    }
}

public class FileHandler {
    public List<ProductionRecord> processProductionRecord(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            List<ProductionRecord> records = new ArrayList<>();
            reader.lines().forEach(line -> {
                String[] data = line.split(";");
                records.add(new ProductionRecord(data[0], Integer.parseInt(data[1]), Date.from(Instant.parse(data[2]))));
            });
            return records;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void generateInventoryReport(List<ProductionRecord> records, Path targetPath) {
        try {
            for (ProductionRecord record : records) {
                Files.write(targetPath, ("Product: " + record.getProductName() + ", Quantity: " + record.getQuantityProduced()).getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean secureFile(String filePath) {
        try {
            File file = Paths.get(filePath).toFile();
    
            file.setReadOnly();
            file.setWritable(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkFileSecurity(String filePath) {
        // AI Copied
        try {
            Path path = Paths.get(filePath);
            PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
            PosixFileAttributes attributes = fileAttributeView.readAttributes();
            Set<PosixFilePermission> permissions = attributes.permissions();

            if (permissions.contains(PosixFilePermission.GROUP_READ) || permissions.contains(PosixFilePermission.GROUP_WRITE) || permissions.contains(PosixFilePermission.OTHERS_READ) || permissions.contains(PosixFilePermission.OTHERS_WRITE)) {
                return false;
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<String, Integer> readRecordsIntoMap(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            Map<String, Integer> records = new HashMap<>();
            reader.lines().forEach(line -> {
                String[] data = line.split(";");
                records.put(data[0], Integer.parseInt(data[1]));
            });
            return records;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void writeMapToNewFile(Map<String, Integer> records, String filePath) {
        try {
            Path path = Paths.get(filePath);
            for (Map.Entry<String, Integer> entry : records.entrySet()) {
                Files.write(path, ("Product: " + entry.getKey() + ", Quantity: " + entry.getValue()).getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ProductionRecord> readLargeFile(String filePath) {
        return processProductionRecord(filePath);
    }

    public Map<String, Integer> processRecords(List<ProductionRecord> records) {
        return records.stream().collect(Collectors.groupingBy(ProductionRecord::getProductName, Collectors.summingInt(ProductionRecord::getQuantityProduced)));
    }

    public void writeLargeFile(Map<String, Integer> records, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (Map.Entry<String, Integer> entry : records.entrySet()) {
                writer.write("Product: " + entry.getKey() + ", Quantity: " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
