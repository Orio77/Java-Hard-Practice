package files.exercise11_errorHandling.scenario2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DNASequenceAnalyzer {

    // Task 1
    public List<String> readAndValidateSequences(String filePath) {
        List<File> files = Arrays.stream(Paths.get(filePath).toFile().listFiles()).toList();
        
        files.stream().forEach(file -> {
            try {
                BufferedReader reader = Files.newBufferedReader(file.toPath());
                List<String> content = reader.lines().toList();
                reader.close();
                // AI Helped - I did not know how to filter this properly
                content.stream().filter(line -> line.matches("[ACTG]*"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        });

        return files.stream().map(file -> {
            try {
                BufferedReader reader = Files.newBufferedReader(file.toPath());
                List<String> content = reader.lines().toList();
                reader.close();
                return content;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).flatMap(List::stream).toList();
    }

    public void writeValidSequencesToFile(List<String> sequences, String filePath) {
        try {
            for (String content : sequences) {
                Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public List<String> readSequencesWithBuffer(String filePath) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            List<String> content = reader.lines().toList();
            reader.close();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeSequencesWithBuffer(List<String> sequences, String filePath) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            for (String content : sequences) {
                writer.write(content);
            }
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    // Task 3
    public Map<String, Long> readSequencesToMap(String filePath) {
        return Arrays.stream(Paths.get(filePath).toFile().listFiles()).flatMap(file -> {
            try {
                BufferedReader reader = Files.newBufferedReader(file.toPath());
                Stream<String> content = reader.lines();
                reader.close();
                return content;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void writeMapToFile(Map<String, Integer> sequenceMap, String filePath) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND);
            for (Map.Entry<String, Integer> entry : sequenceMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + ",");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public List<String> readSequencesAndAttributes(String filePath) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            List<String> content = reader.lines().toList();
            reader.close();
            content.add(Long.toString(Paths.get(filePath).toFile().lastModified()));
            content.add(Long.toString(Paths.get(filePath).toFile().length()));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void writeSequencesAndAttributes(List<String> sequences, String filePath) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND);
            for (String content : sequences) {
                writer.write(content);
            }
            writer.close();
            // AI Helped with the ZoneOffset, I reached the point of providing null as an argument
            Files.setLastModifiedTime(Paths.get(filePath), FileTime.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getFileAttributes(String filePath) {
        Map<String, Object> map = new HashMap<>();

        File file = Paths.get(filePath).toFile();

        map.put("last modified time", file.lastModified());
        map.put("size", file.length());
        return map;
    }
}
