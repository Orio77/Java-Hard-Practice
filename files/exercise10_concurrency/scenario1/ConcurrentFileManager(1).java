package files.exercise10_.scenario1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ConcurrentFileManager {
    // Task 1
    public List<String> backupFiles(List<String> filePaths, String backupDirectory) throws IOException {
        // implementation here
    }

    public List<String> restoreFiles(List<String> backupFilePaths, String restoreDirectory) throws IOException {
        // implementation here
    }

    // Task 2
    public Map<String, Boolean> checkPermissions(List<String> filePaths) throws IOException {
        // implementation here
    }

    public List<String> makeWritable(List<String> filePaths) throws IOException {
        // implementation here
    }

    // Task 3
    public Map<String, LocalDateTime> getCreationTimes(List<String> filePaths) throws IOException {
        // implementation here
    }

    public List<String> setLastModifiedTime(List<String> filePaths, LocalDateTime time) throws IOException {
        // implementation here
    }

    // Task 4
    public Map<String, String> readFilesIntoMap(List<String> filePaths) throws IOException {
        // implementation here
    }

    public List<String> writeMapIntoFiles(Map<String, String> fileContents, String directory) throws IOException {
        // implementation here
    }

    public List<String> readFilesIntoList(List<String> filePaths) throws IOException {
        // implementation here
    }
}
