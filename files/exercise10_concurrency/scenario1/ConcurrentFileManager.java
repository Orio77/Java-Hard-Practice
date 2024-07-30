package files.exercise10_.scenario1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;




public class ConcurrentFileManager {
    // Task 1
    // AI Copied
    public List<String> backupFiles(List<String> filePaths, String backupDirectory)  {
        List<String> threadSafeList = Collections.synchronizedList(new ArrayList<>());

        filePaths.parallelStream().forEach(filePath -> {
            File file = new File(filePath);
            if (file.exists() && !file.isDirectory()) {
                String backupFilePath = Paths.get(backupDirectory, file.getName()).toString();

                try {
                    Files.copy(file.toPath(), Paths.get(backupFilePath), StandardCopyOption.REPLACE_EXISTING);
                    threadSafeList.add(backupFilePath);
                } catch (IOException e) {
                    System.out.println("Failed to backup file: " + filePath);
                    e.printStackTrace();
                }
            }
        });

        return threadSafeList;
    }

    public List<String> restoreFiles(List<String> backupFilePaths, String restoreDirectory)  {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        backupFilePaths.parallelStream().forEach(filePath -> {
            try {
                Files.copy(Paths.get(filePath), Paths.get(restoreDirectory));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Arrays.stream(Paths.get(restoreDirectory).toFile().listFiles()).forEach(file -> list.add(file.getAbsolutePath().toString()));

        return list;
    }

    // Task 2
    public Map<String, Boolean> checkPermissions(List<String> filePaths)  {
        Map<String, Boolean> permissions = Collections.synchronizedMap(new HashMap<>());
        
        filePaths.parallelStream().forEach(filePath -> {
            permissions.put(filePath, Files.isWritable(Paths.get(filePath)));
        });
        return permissions;
    }

    public List<String> makeWritable(List<String> filePaths)  {
        List<String> paths = Collections.synchronizedList(new ArrayList<>());

        filePaths.parallelStream().forEach(filePath -> {
            Paths.get(filePath).toFile().setWritable(true);
            if (Paths.get(filePath).toFile().canWrite()) {
                paths.add(filePath);
            }
        });

        return paths;
    }

    // Task 3
    public Map<String, LocalDateTime> getCreationTimes(List<String> filePaths)  {
        Map<String, LocalDateTime> creationTimes = Collections.synchronizedMap(new HashMap<>());

        filePaths.parallelStream().forEach(filePath -> {
            // AI Helped
            try {
                BasicFileAttributes attrs = Files.readAttributes(Paths.get(filePath), BasicFileAttributes.class);
                creationTimes.put(filePath, LocalDateTime.ofInstant(attrs.creationTime().toInstant(), ZoneId.systemDefault()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return creationTimes;
    }

    public List<String> setLastModifiedTime(List<String> filePaths, LocalDateTime time)  {
        List<String> paths = Collections.synchronizedList(new ArrayList<>());
        
        filePaths.parallelStream().forEach(filePath -> {
            try {
                // AI Helped - I tried to pass a time.toInstant(null) as an argument
                paths.add(Files.setLastModifiedTime(Paths.get(filePath), FileTime.from(time.atZone(ZoneId.systemDefault()).toInstant())).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return paths;
    }

    // Task 4
    public Map<String, String> readFilesIntoMap(List<String> filePaths)  {
        Map<String, String> contents = Collections.synchronizedMap(new HashMap<>());

        filePaths.parallelStream().forEach(filePath -> {
            try {
                contents.put(Paths.get(filePath).toString(), Files.readAllLines(Paths.get(filePath)).stream().collect(Collectors.joining()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return contents;
    }

    // AI Helped - I got lost in getting the right paths with Paths.get() method
    public List<String> writeMapIntoFiles(Map<String, String> fileContents, String directory)  {
        List<String> paths = new ArrayList<>();

        fileContents.entrySet().parallelStream().forEach(es -> {
            try {
                Path filePath = Paths.get(directory, es.getKey());
                Files.write(filePath, es.getValue().getBytes(StandardCharsets.UTF_8));
                paths.add(filePath.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return paths;
    }

    public List<String> readFilesIntoList(List<String> filePaths)  {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        filePaths.parallelStream().forEach(filePath -> {
            try {
                BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
                list.add(reader.lines().collect(Collectors.joining("\n")));
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return list;
    }
}
