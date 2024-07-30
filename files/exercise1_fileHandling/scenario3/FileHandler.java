package files.exercise1_fileHandling.scenario3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileHandler {

    // Task 1
    public List<String> readFileWithBuffer(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void writeFileWithChannel(String filePath, List<String> data) {
        try (FileChannel channel = FileChannel.open(Paths.get(filePath))) {

            ByteBuffer buffer = ByteBuffer.wrap(data.stream().collect(Collectors.joining("\n")).getBytes());
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public Map<String, Boolean> checkFilePermissions(String filePath) {

        File file = Paths.get(filePath).toFile();
        Map<String, Boolean> map = new HashMap<>();

        map.put("canRead", file.canRead());
        map.put("canWrite", file.canWrite());
        map.put("canExecute", file.canExecute());
        return map;
        
    }

    public void setFilePermissions(String filePath, Map<String, Boolean> permissions) {
        File file = Paths.get(filePath).toFile();

        file.setExecutable(permissions.get("canExecute"));
        file.setReadable(permissions.get("canRead"));
        file.setWritable(permissions.get("canWrite"));
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

    public void setLastModifiedTime(String filePath, FileTime time) {
        try {
            Files.setLastModifiedTime(Paths.get(filePath), time);
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    // Task 4
    public Map<String, String> getFilePathDetails(String filePath) {
        Map<String, String> details = new HashMap<>();
        File file = Paths.get(filePath).toFile();

        details.put("name", file.getName());
        details.put("parent directory", file.getParent());
        details.put("absolute path", file.getPath());
        details.put("relative path", file.toPath().toString());

        return details;
    }

    public void renameFile(String filePath, String newName) {
        
        try {
            Files.move(Paths.get(filePath), Paths.get(filePath).resolveSibling(newName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveFile(String sourcePath, String destinationPath) {
        
        try {
            Files.move(Paths.get(sourcePath), Paths.get(destinationPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
