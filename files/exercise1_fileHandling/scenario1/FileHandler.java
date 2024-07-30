package files.exercise1_fileHandling.scenario1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class FileHandler {

    public String bufferedFileRead(String filePath) throws Exception {
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File(filePath)))){
            // return bin.readAllBytes().toString(); // my take
            return new String(bin.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean fileChannelCopy(String sourcePath, String destinationPath) throws Exception {
        
        try {
            Files.copy(Paths.get(sourcePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
            if (Files.exists(Paths.get(destinationPath))) {
                return true;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Set<PosixFilePermission> checkFilePermissions(String filePath) throws Exception {
        
        return Files.getPosixFilePermissions(Paths.get(filePath));
    }

    public boolean setFilePermissions(String filePath, Set<PosixFilePermission> permissions) throws Exception {
        Files.setPosixFilePermissions(Paths.get(filePath), permissions);

        return true;
    }

    public BasicFileAttributes getFileAttributes(String filePath) throws Exception {

        return Files.readAttributes(Paths.get(filePath), BasicFileAttributes.class);
    }

    public boolean setFileAttributes(String filePath, FileTime lastModifiedTime) throws Exception {
        Files.setAttribute(Paths.get(filePath), "basic:lastModifiedTime", lastModifiedTime);
        FileTime updatedTime = (FileTime) Files.getAttribute(Paths.get(filePath), "basic:lastModifiedTime");
        return lastModifiedTime.equals(updatedTime);
    }

    public String getFilePath(String fileName) throws Exception {
        return Paths.get(fileName).toAbsolutePath().toString();
    }

    public String getFileName(String filePath) throws Exception {
        File file = new File(filePath);
        return file.getName();
    }

    public boolean renameFile(String oldFilePath, String newFilePath) throws Exception {
        
        Files.move(Paths.get(oldFilePath), Paths.get(newFilePath));

        return Files.exists(Paths.get(newFilePath));
    }
}
