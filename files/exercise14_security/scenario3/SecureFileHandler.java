package files.exercise14_security.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.logging.Level;

class SecureFileHandler {
    // AI Copied
    public boolean encryptFileData(String filePath, String key) {
        try {
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
            int shiftValue = Integer.parseInt(key);
            for (int i = 0; i < fileBytes.length; i++) {
                fileBytes[i] = (byte) (fileBytes[i] + shiftValue);
            }
            Files.write(Paths.get(filePath), fileBytes);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // AI Copied
    public boolean decryptFileData(String filePath, String key) {
        try {
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
            int shiftValue = Integer.parseInt(key);

            for (int i = 0; i < fileBytes.length; i++) {
                fileBytes[i] = (byte) (fileBytes[i] - shiftValue);
            }
            Files.write(Paths.get(filePath), fileBytes);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

class PermissionManager {
    public boolean setFilePermissions(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getFilePermissions(String filePath) {
        try {
            return Files.getPosixFilePermissions(Paths.get(filePath)).stream().map(PosixFilePermission::toString).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }
}

class PerformanceOptimizer {
    public String readFileWithBuffer(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }

    public boolean writeFileWithBuffer(String filePath, String data) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            writer.write(data);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

class ErrorHandler {
    public Optional<String> safeReadFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return Optional.of(new String());
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return Optional.of(reader.lines().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.of(new String());
        }
    }

    public boolean safeWriteFile(String filePath, String data) {
        if (filePath == null || data == null || filePath.isEmpty() || data.isEmpty()) {
            return false;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            writer.write(data);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void logFileError(IOException error) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Severe", error);
    }
}