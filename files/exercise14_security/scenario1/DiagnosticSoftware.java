package files.exercise14_security.scenario1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DiagnosticSoftware {
    private String databasePath;

    // Task 1
    public SensorData readSensorData(String sensorId) {
        Path path = Paths.get(databasePath, sensorId);

        try {
            String data = Files.readAllLines(path).stream().collect(Collectors.joining());
            return new SensorData(data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public void writeToLogFile(SensorData data, String key) {
        try {
            Files.write(Paths.get(databasePath, key), data.getContent().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Task 2
    public void setLogFilePermissions(File logFile, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(logFile.getAbsolutePath()), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkAccess(File logFile, User user) {
        return user.isAdmin();
    }

    // Task 3
    public Optional<SensorData> safeReadSensorData(String sensorId) {
        Path path = Paths.get(databasePath, sensorId);

        try {
            String data = Files.readAllLines(path).stream().collect(Collectors.joining());
            Optional<SensorData> sensorData = Optional.of(new SensorData(data));
            return sensorData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean safeWriteToLogFile(SensorData data, String key) {
        try {
            Files.write(Paths.get(databasePath, key), data.getContent().getBytes(), StandardOpenOption.CREATE);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Task 4 
    public Set<File> addLogFile(Set<File> logFiles, File logFile) { // ?
        logFiles.add(logFile);
        return logFiles;
    }

    public Set<File> removeLogFile(Set<File> logFiles, File logFile) { // ?
        if (logFiles.contains(logFile)) {
            logFiles.remove(logFile);
        }
        return logFiles;
    }

    public void writeToAllLogFiles(Set<File> logFiles, SensorData data, String key) {
        for (File file : logFiles) {
            try {
                Files.write(Paths.get(file.getAbsolutePath()), data.getContent().getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
