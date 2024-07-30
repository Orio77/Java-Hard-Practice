package files.exercise7_fileNavigation.scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ImageFileManager {

    // Task 1
    public void storeImageFile(String directory, String filename, byte[] imageData) throws FileNotFoundException{
        
        if (!Files.exists(Paths.get(directory))) {
            try {
                Files.createDirectory(Paths.get(directory));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File[] files = Paths.get(directory).toFile().listFiles();
        Optional<File> file = Arrays.stream(files).filter(f -> f.getName().matches(filename)).findAny();
        File target = null;

        if (!file.isPresent()) {
            throw new FileNotFoundException();
        }
        else {
            target = file.get();
        }

        try (FileOutputStream out = new FileOutputStream(target);
        ) {
            out.write(imageData);    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] retrieveImageFile(String directory, String filename) throws FileNotFoundException{
        
        File[] files = Paths.get(directory).toFile().listFiles();
        Optional<File> file = Arrays.stream(files).filter(f -> f.getName().matches(filename)).findAny();
        File target = null;

        if (!file.isPresent()) {
            throw new FileNotFoundException();
        }
        else {
            target = file.get();
        }

        try (FileInputStream in = new FileInputStream(target)) {
            return in.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 2
    public void setFilePermissions(String directory, String filename, Set<PosixFilePermission> permissions) throws FileNotFoundException{
        Path filePath = Paths.get(directory, filename);

        if (!Files.exists(filePath)) {
            throw new FileNotFoundException();
        }
        else {
            try {
                Files.setPosixFilePermissions(filePath, permissions);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }

    public Set<PosixFilePermission> getFilePermissions(String directory, String filename) {
        
        try {
            return Files.getPosixFilePermissions(Paths.get(directory, filename));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 3
    public void setFileAttributes(String directory, String filename, Map<String, Object> attrs) {
        
        try {
            for (Map.Entry<String, Object> entry : attrs.entrySet()) {
                Files.setAttribute(Paths.get(directory, filename), entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getFileAttributes(String directory, String filename) {
        
        Map<String, Object> attributes = null;
        try {
            attributes = Files.readAttributes(Paths.get(directory, filename),".*");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return attributes;
    }

    // Task 4
    public String getAbsolutePath(String directory, String filename) {
        return Paths.get(directory, filename).toAbsolutePath().toString();
    }

    public String getRelativePath(String directory, String filename) {
        return Paths.get(directory, filename).relativize(Paths.get(directory)).toString();
    }

    public void renameFile(String directory, String oldFilename, String newFilename) {
        Paths.get(directory, oldFilename).toFile().renameTo(Paths.get(directory, newFilename).toFile());
    }
}
