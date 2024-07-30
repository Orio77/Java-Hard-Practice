package files.exercise11_.scenario1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileErrorHandler {
    private String absolutePath;    // to the log directory
    // Task 1
    public boolean recoverFile(String filePath) {
        
        if (Files.exists(Paths.get(filePath))) {
            return true;
        }
        else {
            System.out.println("Starting the recovery process");
            return (Math.random() % 2 == 0); // simulate recovery to the backup location
        }
    }

    public void logError(Exception e, String filePath) {
        try {
            Files.writeString(Paths.get(absolutePath), e.getMessage() + filePath);
        } catch (IOException r) {
            r.printStackTrace();
        }
    }

    // Task 2
    public boolean checkPermissions(String filePath) throws PermissionException {
        File file = Paths.get(filePath).toFile();

        if (!file.canRead() || !file.canWrite()) {
            throw new PermissionException();
        }
        return true;
    }

    public boolean handlePermissionError(PermissionException e) {
        
        try {
            Files.writeString(Paths.get(absolutePath), e.getMessage());
            Scanner sc = new Scanner(System.in);
            System.out.println("Respond with true/false");
            System.out.print("Approve request for the file to be readible and writable:");
            boolean response = sc.nextBoolean();
            sc.close();
            return response;
        } catch (Exception r) {
            r.printStackTrace();
        }
        return false;
    }

    // Task 3
    public long monitorPerformance(String filePath) throws PerformanceException {
        
        try {
            long start = System.nanoTime();
            Files.readAllLines(Paths.get(filePath));
            long end = System.nanoTime();
            long result = end - start;
            if (result > 0.1) { // example number
                throw new PerformanceException();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean handlePerformanceError(PerformanceException e) {

        try {
            Files.writeString(Paths.get(absolutePath), e.getMessage());
            
            System.out.println("Attemting to optimize the operation");
            return Math.random() % 2 == 0;
        } catch (Exception r) {
            r.printStackTrace();
        }
        return false;
    }

    // Task 4
    // AI COpied
    public Map<String, Object> getFileAttributes(String filePath) throws AttributeException {
        
        

        try {
            BasicFileAttributes attrs = Files.readAttributes(Paths.get(filePath), BasicFileAttributes.class);
            Map<String, Object> map = new HashMap<>();
            map.put("creationTime", attrs.creationTime());
            map.put("lastModifiedTime", attrs.lastModifiedTime());
            map.put("lastAccessTime", attrs.lastAccessTime());
            map.put("size", attrs.size());
            map.put("isRegularFile", attrs.isRegularFile());
            map.put("isDirectory", attrs.isDirectory());
            map.put("isSymbolicLink", attrs.isSymbolicLink());
            map.put("isOther", attrs.isOther());
            return map;
        } catch (Exception e) {
            throw new AttributeException();
        }
    }

    // AI Copied
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<String> orderFiles(List<String> filePaths, String attributeKey) throws OrderingException {
        
        // My Attempt
        // filePaths.stream().map(path -> Paths.get(path).toFile()).sorted(Comparator.comparing(Files::getAttribute(Paths.get(path), attributeKey))).toList();

        // Correct
        try {
            List<Path> paths = new ArrayList<>();
            for (String filePath : filePaths) {
                Path path = Paths.get(filePath);
                if (!Files.exists(path)) {
                    throw new FileNotFoundException();
                }
                paths.add(path);
            }
            paths.sort(Comparator.comparing(path -> {
                try {
                    return (Comparable) Files.getAttribute(path, attributeKey);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }));

            List<String> orderedFilePaths = new ArrayList<>();
            for (Path path : paths) {
                orderedFilePaths.add(path.toString());
            }
            return orderedFilePaths;
        } catch (Exception e) {
            throw new OrderingException();
        }
    }

    public boolean handleAttributeError(Exception e) {
        try {
            Files.writeString(Paths.get(absolutePath), e.getMessage());
            
            System.out.println("Attemting to recover the files");
            return Math.random() % 2 == 0;
        } catch (Exception r) {
            r.printStackTrace();
        }
        return false;
    }
}
