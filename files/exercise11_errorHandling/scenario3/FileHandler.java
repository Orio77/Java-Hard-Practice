package files.exercise11_errorHandling.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileHandler {
    public String readFileWithIOExceptionHandling(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }

    public boolean writeFileWithIOExceptionHandling(String filePath, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean[] checkFilePermissions(String filePath) {
        File file = Paths.get(filePath).toFile();
        boolean[] perms = new boolean[3];

        perms[0] = file.canRead();
        perms[1] = file.canWrite();
        perms[2] = file.canExecute();

        return perms;
    }

    public boolean changeFilePermissions(String filePath, boolean read, boolean write, boolean execute) {
        try {
            File file = Paths.get(filePath).toFile();
    
            file.setExecutable(execute);
            file.setReadable(read);
            file.setWritable(write);
            return true;
       } catch (Exception e) {
            e.printStackTrace();
            return false;
       }
    }

    public Map<String, Object> getFileAttributes(String filePath) {
        try {
            return Files.readAttributes(Paths.get(filePath), "*");
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public boolean setFileAttributes(String filePath, Map<String, Object> attributes) {
        try {
            Path path = Paths.get(filePath);
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                Files.setAttribute(path, entry.getKey(), entry.getValue());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<String, String> getFilePathDetails(String filePath) {
        Map<String, String> map = new HashMap<>();

        Path path = Paths.get(filePath);
        int dotIndex = path.toString().charAt('.');

        map.put("parentDirectory", path.toFile().getParent());
        map.put("fileName", path.toFile().getName());
        map.put("fileExtension", path.toString().substring(dotIndex));
        return map;
    }

    public boolean renameFile(String filePath, String newFileName) {
        try {
            Path oldFile = Paths.get(filePath);
            Path newFile = Paths.get(filePath, newFileName);

            Files.move(oldFile, newFile, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean moveFile(String sourceFilePath, String destinationFilePath) {
        try {
            Files.move(Paths.get(sourceFilePath), Paths.get(destinationFilePath), StandardCopyOption.ATOMIC_MOVE);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}