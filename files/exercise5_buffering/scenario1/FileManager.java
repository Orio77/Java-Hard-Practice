package files.exercise5_buffering.scenario1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import java.util.stream.Collectors;

public class FileManager {

    public String bufferedRead(String filePath)  {
        try (BufferedReader bReader = new BufferedReader(new FileReader(new File(filePath)))) {
            return bReader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void bufferedWrite(String filePath, String content)  {
        
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(filePath)))) {
            bWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<PosixFilePermission> checkPermissions(String filePath)  {

        try {
            return Files.getPosixFilePermissions(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void changePermissions(String filePath, Set<PosixFilePermission> permissions)  {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BasicFileAttributes getFileAttributes(String filePath)  {
        try {
            BasicFileAttributes attributes = Files.readAttributes(Paths.get(filePath), BasicFileAttributes.class);
            return attributes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setLastModifiedTime(String filePath, FileTime time)  {
        try {
            Files.setAttribute(Paths.get(filePath), "basic:lastModifiedTime", time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAbsolutePath(String filePath)  {
        return Paths.get(filePath).toAbsolutePath().toString();
    }

    public String getRelativePath(String filePath, String basePath)  {
        return Paths.get(basePath).relativize(Paths.get(filePath)).toString();
    }

    public String normalizePath(String filePath)  {
        return Paths.get(filePath).normalize().toString();
    }
}
