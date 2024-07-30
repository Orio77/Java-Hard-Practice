package files.exercise5_buffering.scenario2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.naming.NoPermissionException;

import streamAPI.exercise4_collectors.scenario1.Pair;

public class FileOperations {

    // Task 1
    public String bufferedFileRead(String filePath) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            String result = reader.lines().collect(Collectors.joining("\n"));
            reader.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void bufferedFileWrite(String filePath, String content) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            writer.write(content);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    // Task 2
    public String bufferedFileReadWithPermissionCheck(String filePath) throws NoPermissionException {
        try {
            if (!Paths.get(filePath).toFile().canRead()) {
                throw new NoPermissionException();
            }
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            String result = reader.lines().collect(Collectors.joining("\n"));
            reader.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void bufferedFileWriteWithPermissionCheck(String filePath, String content) throws NoPermissionException {
        if (!Paths.get(filePath).toFile().canWrite()) {
            throw new NoPermissionException();
        }
        bufferedFileWrite(filePath, content);
    }

    // Task 3
    public String bufferedFileReadWithAttributeCheck(String filePath) throws NoPermissionException {
        File file = Paths.get(filePath).toFile();
        if (file.isHidden() || (!file.canWrite() && !file.canExecute())) {
            throw new NoPermissionException();
        }
        return bufferedFileRead(filePath);
    }

    public void bufferedFileWriteWithAttributeCheck(String filePath, String content) throws NoPermissionException {
        File file = Paths.get(filePath).toFile();
        if (file.isHidden() || (!file.canWrite() && !file.canExecute())) {
            throw new NoPermissionException();
        }
        bufferedFileWrite(filePath, content);
    }

    // Task 4
    public Pair<String, Long> bufferedFileReadWithPerformanceMonitoring(String filePath) {
        try {
            long start = System.nanoTime();
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            String result = reader.lines().collect(Collectors.joining("\n"));
            reader.close();
            long end = System.nanoTime();

            Pair<String, Long> answer = new Pair<String,Long>(result, (end - start));
            return answer;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long bufferedFileWriteWithPerformanceMonitoring(String filePath, String content) {
        
        try {
            long start = System.nanoTime();
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            writer.write(content);
            writer.close();
            long end = System.nanoTime();
            return end - start;

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String getPerformanceData(String filePathRead, String filePathWrite, String content) {
        return "Write operation took: " + bufferedFileWriteWithPerformanceMonitoring(filePathWrite, content) + "seconds" + 
        "\nRead operation took: " + bufferedFileReadWithPerformanceMonitoring(filePathRead).getValue() + "seconds";
    }
}
