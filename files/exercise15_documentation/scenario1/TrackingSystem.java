package files.exercise15_documentation.scenario1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Optional;
import java.util.Set;

class GPSData {
    private String content;

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}

class GPSDevice {
    private GPSData data;

    public GPSData getData() {
        return data;
    }
    public void setData(GPSData data) {
        this.data = data;
    }
}

class User {
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }
}

public class TrackingSystem {

    // Task 1
    public GPSData readGPSData(GPSDevice gpsDevice) {
        return gpsDevice.getData();
    }

    public void writeToTrackingFile(GPSData data, File trackingFile) {
        try {
            Files.write(Paths.get(trackingFile.getAbsolutePath()), data.getContent().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public void setTrackingFilePermissions(File trackingFile, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(trackingFile.getAbsolutePath()), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkAccess(File trackingFile, User user) {
        return user.isAdmin();
    }

    // Task 3
    public Optional<GPSData> safeReadGPSData(GPSDevice gpsDevice) {
        return Optional.of(gpsDevice.getData());
    }

    public boolean safeWriteToTrackingFile(GPSData data, File trackingFile) {
        try {
            Files.write(Paths.get(trackingFile.getAbsolutePath()), data.getContent().getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Task 4
    public Set<File> addTrackingFile(Set<File> trackingFiles, File trackingFile) {
        trackingFiles.add(trackingFile);
        return trackingFiles;
    }

    public Set<File> removeTrackingFile(Set<File> trackingFiles, File trackingFile) {
        if (trackingFiles.contains(trackingFile)) {
            trackingFiles.remove(trackingFile);
        }
        return trackingFiles;
    }

    public void writeToAllTrackingFiles(Set<File> trackingFiles, GPSData data) {
        for (File file : trackingFiles) {
            try {
                Files.write(Paths.get(file.getAbsolutePath()), data.getContent().getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
