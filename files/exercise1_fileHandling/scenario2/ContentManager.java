package files.exercise1_fileHandling.scenario2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class ContentManager {
    private Path baseDirectory;
    private Stack<Exception> errorLog;

    public ContentManager(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    // Task 1
    public void publishContent(String content, String contentType, String fileName) {
        
        Path path = Paths.get(baseDirectory.toString(), contentType, fileName);

        try {
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String retrieveContent(String contentType, String fileName) {
        Path path = Paths.get(baseDirectory.toString(), contentType, fileName);

        try {
            return Files.readAllLines(path).stream().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 2
    public void setPermissions(String contentType, String fileName, Set<PosixFilePermission> permissions) {
        Path path = Paths.get(baseDirectory.toString(), contentType, fileName);

        try {
            Files.setPosixFilePermissions(path, permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<PosixFilePermission> checkPermissions(String contentType, String fileName) {
        Path path = Paths.get(baseDirectory.toString(), contentType, fileName);
        
        try {
            return Files.getPosixFilePermissions(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 3
    public void compressContent(String contentType, String fileName) {
        Path path = Paths.get(baseDirectory.toString(), contentType, fileName);

        try {
            String compressed = Files.readAllLines(path).stream().map(str -> str.trim()).collect(Collectors.joining("\n"));
            Files.writeString(path, compressed, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decompressContent(String contentType, String fileName) {
        Path path = Paths.get(baseDirectory.toString(), contentType, fileName);

        try {
            String compressed = Files.readAllLines(path).stream().map(str -> str.replace(",", ", ")).collect(Collectors.joining("\n"));
            Files.writeString(path, compressed, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public void tryPublishContent(String content, String contentType, String fileName) {
        Path path = Paths.get(baseDirectory.toString(), contentType, fileName);

        try {
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            errorLog.push(e);
        }
    }

    public Optional<String> tryRetrieveContent(String contentType, String fileName) {
        Path path = Paths.get(baseDirectory.toString(), contentType, fileName);

        try {
            return Optional.of(Files.readAllLines(path).stream().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            errorLog.push(e);
            return null;
        }
    }

    public void logError(String message) {
        errorLog.push(new Exception(message));
    }
}
