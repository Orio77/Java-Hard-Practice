package files.exercise15_documentation.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Record {
    private String content;

    public Record(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class FileDataManager {
    public List<Record> readAndParseFile(String filePath) {
        List<Record> records = new ArrayList<>();
        try {
            Files.readAllLines(Paths.get(filePath)).stream().forEach(line -> {
                records.add(new Record(line));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public void writeRecordsToFile(List<Record> records, String filePath) {
        try {
            String content = records.stream().map(Record::getContent).collect(Collectors.joining("\n"));
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FilePermissionManager {
    public Map<String, Boolean> checkFilePermissions(String filePath) {
        File file = Paths.get(filePath).toFile();
        Map<String, Boolean> perms = new HashMap<>();

        perms.put("canRead", file.canRead());
        perms.put("canWrite", file.canWrite());
        perms.put("canExecute", file.canExecute());

        return perms;
    }

    public void changeFilePermissions(String filePath, Map<String, Boolean> permissions) {
        File file = Paths.get(filePath).toFile();

        for (Map.Entry<String, Boolean> entry : permissions.entrySet()) {
            switch (entry.getKey()) {
                case "canRead":
                    file.setReadable(entry.getValue());
                    break;
                case "canWrite":
                    file.setWritable(entry.getValue());
                    break;   
                case "canExecute":
                    file.setExecutable(entry.getValue());
                    break;
                default:
                    break;
            }
        }
    }
}

class FilePerformanceManager {
    public List<String> readFileWithBuffer(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void writeFileWithBuffer(String filePath, List<String> data) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            writer.write(data.stream().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileDataStructureManager {
    // I assume the line content: "soiltype;content"
    public Map<String, List<Record>> readFileIntoMap(String filePath) {
        Map<String, List<Record>> map = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            reader.lines().forEach(line -> {
                String[] data = line.split(";");
                if (!map.keySet().contains(data[0])) {
                    map.put(data[0], new ArrayList<>());
                    map.get(data[0]).add(new Record(line));
                }
                else {
                    map.get(data[0]).add(new Record(line));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void writeMapToFile(Map<String, List<Record>> map, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            for (Map.Entry<String, List<Record>> entry : map.entrySet()) {
                writer.write(entry.getKey() + ";" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Record> searchRecords(Map<String, List<Record>> map, String soilType) {
        return map.get(soilType);
    }
}
