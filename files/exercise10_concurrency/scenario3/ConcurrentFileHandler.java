package files.exercise10_concurrency.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class MaintenanceRecord {
    private String vehicleID;
    private String maintenanceDate;
    private String maintenanceType;
    private String maintenanceDetails;

    public MaintenanceRecord(String vehicleID, String maintenanceDate, String maintenanceType,
            String maintenanceDetails) {
        this.vehicleID = vehicleID;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceType = maintenanceType;
        this.maintenanceDetails = maintenanceDetails;
    }
    public String getMaintenanceDate() {
        return maintenanceDate;
    }
    public String getMaintenanceDetails() {
        return maintenanceDetails;
    }
    public String getMaintenanceType() {
        return maintenanceType;
    }
    public String getVehicleID() {
        return vehicleID;
    }
}

class ConcurrentFileHandler {
    public List<MaintenanceRecord> readFilesConcurrently(List<String> filePaths) {
        List<MaintenanceRecord> records = new ArrayList<>();
        filePaths.parallelStream().forEach(line -> {
            String[] data = line.split(", ");
            records.add(new MaintenanceRecord(data[0], data[1], data[2], data[3]));
        });
        return records;
    }

    public void writeToConsolidatedFile(List<MaintenanceRecord> records, String filePath) {
        if (!Files.exists(Paths.get(filePath))) {
            try {
                Files.createFile(Paths.get(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            for (MaintenanceRecord maintenanceRecord : records) {
                writer.write(maintenanceRecord.getVehicleID() + ", " + maintenanceRecord.getMaintenanceDate() + ", " + maintenanceRecord.getMaintenanceType() + ", " + maintenanceRecord.getMaintenanceDetails());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FilePermissionHandler {
    public String checkFilePermissions(String filePath) {
        String perms = "Permissions: ";
        File file = Paths.get(filePath).toFile();

        if (file.canExecute()) {
            perms.concat("canExecute;");
        }
        if (file.canRead()) {
            perms.concat("canRead;");
        }
        if (file.canWrite()) {
            perms.concat("canWrite");
        }
        return perms;
    }

    public boolean modifyFilePermissions(String filePath, String permissions) {
        try {
            String[] perms = permissions.split(";");
    
            File file = Paths.get(filePath).toFile();
    
            for (int i = 0; i < perms.length; i++) {
                switch (perms[i]) {
                    case "canExecute":
                        file.setExecutable(true);
                        break;
                    case "canRead":
                        file.setReadable(true);
                        break;
                    case "canWrite":
                        file.setWritable(true);
                        break;
                
                    default:
                        break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

class RecordDataStructureHandler {
    public Map<String, List<MaintenanceRecord>> loadRecordsIntoDataStructure(String filePath) {
        Map<String, List<MaintenanceRecord>> records = new HashMap<>();
        
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            reader.lines().parallel().collect(Collectors.groupingBy(line -> line.substring(0, 4))).entrySet().parallelStream().forEach(entry -> {
                List<String> subRecords = entry.getValue();

                for (String record : subRecords) {
                    records.put(entry.getKey(), new ArrayList<>());
                    String[] data = record.split(";");
                    records.get(entry.getKey()).add(new MaintenanceRecord(data[0], data[1], data[2], data[3]));
                }
                
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }

    public List<MaintenanceRecord> findMaintenanceRecord(String vehicleID, String filePath) {
        return loadRecordsIntoDataStructure(filePath).get(vehicleID);
    }
}

class ErrorHandler {
    public String safeReadFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return new String();
        }

        try {
            return Files.readAllLines(Paths.get(filePath)).stream().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }

    public boolean safeWriteFile(String filePath, String content) {
        if (filePath == null || filePath.isEmpty() || content == null || content.isEmpty()) {
            return false;
        }

        try {
            Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean safeModifyFilePermissions(String filePath, String permissions) {
        if (filePath == null || filePath.isEmpty() || permissions == null || permissions.isEmpty()) {
            return false;
        }

        FilePermissionHandler handler = new FilePermissionHandler();
        return handler.modifyFilePermissions(filePath, permissions);
        
    }
}
