package files.exercise8_streamManipulation.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class EnvironmentalDataProcessor {
    public List<Map<String, String>> readAndProcessData(String inputFile) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            List<Map<String, String>> list = new ArrayList<>();
            reader.lines().forEach(line -> {
                Map<String, String> map = new HashMap<>();
                String[] data = line.split(";");
                map.put(Integer.toString(Integer.parseInt(data[2]) - 173), data[4]);
                list.add(map);
            });
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void writeProcessedData(String outputFile, List<Map<String, String>> data) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile), StandardOpenOption.APPEND)) {
            for (Map<String,String> map : data) {
                writer.write("Temperature: " + map.keySet().iterator().next() + ", Air quality index: " + map.values().iterator().next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FilePermissionHandler {
    public boolean checkPermissions(String filePath) {
        File file = Paths.get(filePath).toFile();
        return (file.canRead() && file.canWrite());
    }

    public boolean setPermissions(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            path.toFile().setReadable(true);
            path.toFile().setWritable(true);
            return true;
        }
        else {
            try {
                Files.createFile(path);
                path.toFile().setReadable(true);
                path.toFile().setWritable(true);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}

class DataHandler {
    public List<Map<String, String>> loadData(String filePath) {
        EnvironmentalDataProcessor processor = new EnvironmentalDataProcessor();
        return processor.readAndProcessData(filePath);
    }

    public Map<String, String> queryData(List<Map<String, String>> data, String date) {
        for (Map<String,String> map : data) {
            if (map.containsKey(date.toString())) {
                return map;
            }
        }
        return null;
    }
}

class ErrorHandler {
    public List<Map<String, String>> safeRead(String filePath) {
        if (!Files.exists(Paths.get(filePath)) || filePath == null || filePath.isEmpty()) {
            return new ArrayList<>();
        }

        EnvironmentalDataProcessor processor = new EnvironmentalDataProcessor();
        return processor.readAndProcessData(filePath);
    }

    public boolean safeWrite(String filePath, List<Map<String, String>> data) {
        if (filePath == null || filePath.isEmpty() || data == null || data.isEmpty()) {
            return false;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            for (Map<String,String> map : data) {
                writer.write("Temperature: " + map.keySet().iterator().next() + ", Air quality index: " + map.values().iterator().next());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Map<String, String>> processData(String inputFile) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            List<Map<String, String>> list = new ArrayList<>();
            reader.lines().forEach(line -> {
                Map<String, String> map = new HashMap<>();
                String[] data = line.split(";");
                map.put(Integer.toString(Integer.parseInt(data[2]) - 173), data[4]);
                list.add(map);
            });
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            return new ArrayList<>();
            
        }
    }
}
