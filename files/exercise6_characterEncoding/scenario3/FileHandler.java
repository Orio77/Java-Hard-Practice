package files.exercise6_characterEncoding.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class FileHandler {
    private Stack<Exception> errorLog;

    public FileHandler() {
        errorLog = new Stack<>();
    }

    // Task 1
    public void encodeFile(String sourceFilePath, String targetPath, String encoding) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(sourceFilePath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(targetPath), Charset.forName(encoding), StandardOpenOption.APPEND);
        ){
            String content = reader.lines().collect(Collectors.joining("\n"));
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decodeFile(String sourceFilePath, String targetPath, String encoding) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(sourceFilePath), Charset.forName(encoding));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(targetPath), Charset.defaultCharset(), StandardOpenOption.APPEND);) {
            String content = reader.lines().collect(Collectors.joining("\n"));
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public void changeFilePermissions(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<PosixFilePermission> checkFilePermissions(String filePath) {
        try {
            return Files.getPosixFilePermissions(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    // Task 3
    public String readLargeFile(String filePath, String encoding) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), Charset.forName(encoding))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) { 
            e.printStackTrace();
            return new String();
        }
    }

    public void writeLargeFile(String filePath, String content, String encoding) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), Charset.forName(encoding), StandardOpenOption.APPEND)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public String safeReadFile(String filePath, String encoding) {
        if (filePath == null || encoding == null || filePath.isEmpty() || encoding.isEmpty()) {
            return new String();
        }
        return readLargeFile(filePath, encoding);
    }

    public void safeWriteFile(String filePath, String content, String encoding) {
        if (filePath == null || encoding == null || content == null || filePath.isEmpty() || encoding.isEmpty() || content.isEmpty()) {
            return;
        }

        writeLargeFile(filePath, content, encoding);
    }

    public void logError(Exception e) {
        errorLog.push(e);
    }
}
