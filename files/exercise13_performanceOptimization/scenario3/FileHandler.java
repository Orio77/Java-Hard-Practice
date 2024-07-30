package files.exercise13_performanceOptimization.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import streamAPI.exercise4_collectors.scenario1.Pair;

class FileOptimizationUtility {
    public Pair<String, Long> optimizedRead(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            long start = System.nanoTime();
            String content = reader.lines().collect(Collectors.joining("\n"));
            long end = System.nanoTime();

            return new Pair<String,Long>(content, end-start);


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long optimizedWrite(String filePath, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            
            long start = System.nanoTime();
            writer.write(content);
            long end = System.nanoTime();

            return end-start;

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

class FilePermissionUtility {
    public Map<String, Boolean> checkPermissions(String filePath) {
        File file = Paths.get(filePath).toFile();
        Map<String, Boolean> map = new HashMap<>();

        map.put("canRead", file.canRead());
        map.put("canWrite", file.canWrite());
        map.put("canExecute", file.canExecute());
        return map;
    }

    public boolean changePermissions(String filePath, Map<String, Boolean> permissions) {
        try {
            File file = Paths.get(filePath).toFile();
    
            file.setReadable(permissions.get("canRead"));
            file.setWritable(permissions.get("canWrite"));
            file.setExecutable(permissions.get("canExecute"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

class FileAttributeUtility {
    public Map<String, Object> getAttributes(String filePath) {
        try {
            return Files.readAttributes(Paths.get(filePath), "*");
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public boolean setLastModifiedTime(String filePath, long time) {
        try {
            Files.setLastModifiedTime(Paths.get(filePath), FileTime.from(time, TimeUnit.NANOSECONDS));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

class ReportManagementUtility {
    public boolean storeReport(String filePath, Map<String, String> report) {
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(new File(filePath)))) {
            objOut.writeObject(report);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> retrieveReport(String filePath) {
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(new File(filePath)))) {
            Object object = objIn.readObject();
            if (object instanceof Map<?, ?>) {
                return (Map<String, String>) object;
            }
            
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public List<Map<String, String>> getReportsWithKeyword(String keyword, String filePath) {
        List<Map<String, String>> list = new ArrayList<>();
        if (!Files.isDirectory(Paths.get(filePath))) {
            return list;
        }

        File[] files = Paths.get(filePath).toFile().listFiles();
        

        for (File file : files) {
            Map<String, String> map = retrieveReport(file.getAbsolutePath());

            if (map.get("content").contains(keyword)) {
                list.add(map);
            }
        }

        return list;
    }
}
