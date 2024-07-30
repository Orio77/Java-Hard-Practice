package files.exercise8_streamManipulation.scenario2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MarketDataProcessor {

    // Task 1
    public Map<Long, List<File>> readAndAggregate(String directory) {
        return Arrays.stream(Paths.get(directory).toFile().listFiles()).collect(Collectors.groupingBy(File::lastModified));
    }

    public void writeAggregatedDataToFile(Map<String, List<Double>> aggregatedData, String outputFile) {
        try {
            for (Map.Entry<String, List<Double>> entry : aggregatedData.entrySet()) {
                Files.writeString(Paths.get(outputFile), entry.getKey() + entry.getValue().toString(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public boolean checkPermissions(String filePath) {
        File file = Paths.get(filePath).toFile();

        return (file.canExecute() && file.canRead() && file.canWrite());
    }

    public void setPermissions(String filePath) {
        File file = Paths.get(filePath).toFile();

        file.setExecutable(true);
        file.setReadable(true);
        file.setWritable(true);
    }

    // Task 3
    public boolean checkIfHidden(String filePath) {
        return Paths.get(filePath).toFile().isHidden();
    }

    public void setHidden(String filePath) {
        try {
            Files.setAttribute(Paths.get(filePath), "dos:hidden", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public List<String> readFileWithBuffer(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().toList();    
            
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void writeFileWithBuffer(String filePath, List<String> data) {
        
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (String content : data) {
                writer.write(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFileWithBuffer(String sourcePath, String destinationPath) {
        
        try {
            Files.copy(Paths.get(sourcePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
