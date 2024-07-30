package files.exercise9_resourceManagement.scenario1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HistoricalRecordsManager {
    // Task 1
    public String scanDocument(String filePath) {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))){
            return reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String categorizeDocument(String documentText) {
        if (documentText == null || documentText.isEmpty()) {
            return null;
        }
        if (Arrays.stream(documentText.split(" ")).count() < 100) {
            return "Short";
        }
        else {
            return "Long";
        }
    }

    // Task 2
    public void setPermissions(String filePath, String permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), Arrays.stream(permissions.split(", ")).map(PosixFilePermission::valueOf).collect(Collectors.toSet()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPermissions(String filePath) {
        
        try {
            return Files.getPosixFilePermissions(Paths.get(filePath)).stream().map(perm -> perm.toString()).collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 3
    public void setAttribute(String filePath, String attribute, String value) {
        try {
            Files.setAttribute(Paths.get(filePath), attribute, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAttribute(String filePath, String attribute) {
        
        try {
            return Files.getAttribute(Paths.get(filePath), attribute).toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 4
    public String readFileWithBuffer(String filePath) {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeFileWithBuffer(String filePath, String content) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getFileSize(String filePath) {
        
        try {
            return Files.size(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
