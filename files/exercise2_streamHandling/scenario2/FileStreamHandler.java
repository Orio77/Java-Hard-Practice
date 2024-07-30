package files.exercise2_streamHandling.scenario2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FileStreamHandler {

    // Task 1
    public List<String> bufferedRead(String filePath) {
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

    public void writeWithChannel(String filePath, List<String> data) {
        try (FileChannel channel = FileChannel.open(Paths.get(filePath))){
            channel.write(ByteBuffer.wrap(data.stream().collect(Collectors.joining("\n")).getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public Map<String, Boolean> checkPermissions(String filePath) {

        try {
            Map<String, Boolean> perms = new HashMap<>();
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(Paths.get(filePath));
            for (PosixFilePermission posixFilePermission : permissions) {
                // AI Helped - I did not know how to get the Boolean value
                perms.put(posixFilePermission.toString(), true); // sets the permissions that exist to true
            }
            return perms;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPermissions(String filePath, Map<String, Boolean> permissions) {
        try {
            Set<PosixFilePermission> filePermissions = new HashSet<>();
            for (Map.Entry<String, Boolean> permission : permissions.entrySet()) {
                filePermissions.add(PosixFilePermission.valueOf(permission.getKey()));  
            }
            Files.setPosixFilePermissions(Paths.get(filePath), filePermissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 3
    public Map<String, Object> getFileAttributes(String filePath) {
        try {
            return Files.readAttributes(Paths.get(filePath), "*");
        } catch (IOException e) {
            return null;
        }
    }

    public void setLastModifiedTime(String filePath, FileTime time) {
        try {
            Files.setLastModifiedTime(Paths.get(filePath), time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public Path getAbsolutePath(String filePath) {
        return Paths.get(filePath).toAbsolutePath();
    }

    public Path getRelativePath(String filePath, String basePath) {
        return Paths.get(basePath).relativize(Paths.get(filePath));
    }

    public void renameFile(String filePath, String newName) {
        File oldFile = Paths.get(filePath).toFile();
        File newFile = new File(oldFile.getParent(), newName);
        oldFile.renameTo(newFile);
    }
}
