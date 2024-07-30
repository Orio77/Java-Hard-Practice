package files.exercise13_performanceOptimization.scenario2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileOperations {

    // Task 1
    public Map<String, String> optimizeFileRead(String directory) {
        try {
            Map<String, String> map = new HashMap<>();
            File[] files = Paths.get(directory).toFile().listFiles();

            for (File file : files) {
                map.put(file.getName(), Files.readAllLines(file.toPath()).stream().collect(Collectors.joining("\n")));
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void writeOptimizedFiles(Map<String, String> files, String outputDirectory) {
        try {
            for (Map.Entry<String, String> entry : files.entrySet()) {
                File file = new File(outputDirectory, entry.getKey());
                Files.write(file.toPath(), entry.getValue().getBytes());
                File renamedFile = new File(outputDirectory + entry.getKey());
                Files.move(file.toPath(), renamedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public Map<String, Boolean> checkPermissions(String filePath) {
        
        Map<String, Boolean> map = new HashMap<>();
        File file = Paths.get(filePath).toFile();

        map.put("Readible", file.canRead());
        map.put("Writable", file.canWrite());
        map.put("Executable", file.canExecute());

        return map;
    }

    public void setPermissions(String filePath, Map<String, Boolean> permissions) {
        File file = Paths.get(filePath).toFile();
        for (Map.Entry<String, Boolean> entry : permissions.entrySet()) {
            switch (entry.getKey()) {
                case "Readible":
                    file.setReadable(entry.getValue());
                    break;
                case "Writable": 
                    file.setWritable(entry.getValue());
                    break;
                case "Executable": 
                    file.setExecutable(entry.getValue());
                    break;
                default:
                    break;
            }
        }
    }

    // Task 3
    public Map<String, Object> getFileAttributes(String filePath) {
        try {
            return Files.readAttributes(Paths.get(filePath), "*");
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void setFileAttributes(String filePath, Map<String, Object> attributes) {
        try {
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                Files.setAttribute(Paths.get(filePath), entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public String getRelativePath(String baseDirectory, String filePath) {
        return Paths.get(filePath).relativize(Paths.get(baseDirectory)).toString();
    }

    public String getAbsolutePath(String baseDirectory, String relativePath) {
        // My Implementation
        // return Paths.get(relativePath).toAbsolutePath().toString();

        // Correct Implementation
        return Paths.get(baseDirectory, relativePath).toAbsolutePath().toString();
    }

    public void moveFile(String sourceFilePath, String targetFilePath) {
        try {
            Files.move(Paths.get(sourceFilePath), Paths.get(targetFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
