package files.exercise11_.scenario1;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;

public class FileErrorHandler {
    // Task 1
    public boolean recoverFile(String filePath) throws IOException {
        // implementation here
    }

    public void logError(Exception e, String filePath) {
        // implementation here
    }

    // Task 2
    public boolean checkPermissions(String filePath) throws PermissionException {
        // implementation here
    }

    public boolean handlePermissionError(PermissionException e) {
        // implementation here
    }

    // Task 3
    public long monitorPerformance(String filePath) throws PerformanceException {
        // implementation here
    }

    public boolean handlePerformanceError(PerformanceException e) {
        // implementation here
    }

    // Task 4
    public Map<String, BasicFileAttributes> getFileAttributes(String filePath) throws AttributeException {
        // implementation here
    }

    public List<String> orderFiles(List<String> filePaths, String attributeKey) throws OrderingException {
        // implementation here
    }

    public boolean handleAttributeError(Exception e) {
        // implementation here
    }
}
