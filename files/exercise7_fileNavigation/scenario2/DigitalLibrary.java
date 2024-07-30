package files.exercise7_fileNavigation.scenario2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DigitalLibrary {

    // Task 1
    public List<File> navigateToDirectory(String directoryPath) {
        File dir = Paths.get(directoryPath).toFile();

        if (!dir.exists() || !dir.isDirectory()) {
            return null;
        }

        return Arrays.stream(dir.listFiles()).toList();
    }

    public String readFile(String filePath) throws FileNotFoundException {
        File file = Paths.get(filePath).toFile();

        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        try {
            return Files.readAllLines(Paths.get(filePath)).stream().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    // Task 2
    public String checkPermissions(String filePath) throws FileNotFoundException {
        File file = Paths.get(filePath).toFile();

        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        try {
            return Files.getPosixFilePermissions(Paths.get(filePath)).stream().map(perm -> perm.toString()).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public String changePermissions(String filePath, Set<PosixFilePermission> permissions) throws FileNotFoundException {
        File file = Paths.get(filePath).toFile();

        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
            return "Permissions set successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    // Task 3
    public long measureReadPerformance(String filePath) throws FileNotFoundException {
        File file = Paths.get(filePath).toFile();

        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        try {
            long start = System.nanoTime();
            Files.readAllLines(Paths.get(filePath));
            long end = System.nanoTime();
            return end - start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long measureWritePerformance(String filePath, String content) throws FileNotFoundException {
        File file = Paths.get(filePath).toFile();

        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        try {
            long start = System.nanoTime();
            Files.write(Paths.get(filePath), "content".getBytes());
            long end = System.nanoTime();
            return end - start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Task 4
    public Map<String, String> createFileIndex(String directoryPath) throws FileNotFoundException {
        File dir = Paths.get(directoryPath).toFile();

        if (!dir.exists()) {
            throw new FileNotFoundException();
        }

        Map<String, String> map = new HashMap<>();

        File[] files = dir.listFiles();

        for (File file : files) {
            map.put(file.getName(), file.getAbsolutePath());
        }
        return map;
    
    }

    public String searchFileIndex(Map<String, String> index, String fileName) throws FileNotFoundException {
        if (!index.containsKey(fileName)) {
            throw new FileNotFoundException();
        }

        return index.get(fileName);
    }

    public String deleteFileFromIndex(Map<String, String> index, String fileName) throws FileNotFoundException {
        if (!index.containsKey(fileName)) {
            throw new FileNotFoundException();
        }

        index.remove(fileName);
        return "Removal successful";
    }
}
