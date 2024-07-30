package files.exercise2_streamHandling.scenario1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MusicLibraryManager {
    
    public void storeMusicFile(String filePath, byte[] musicData) {
        
        try {
            FileOutputStream out = new FileOutputStream(new File(filePath), false);
            out.write(musicData);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] retrieveMusicFile(String filePath) {
        byte[] result = null;
        try (FileInputStream in = new FileInputStream(new File(filePath))){
            result = in.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setFilePermissions(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<PosixFilePermission> getFilePermissions(String filePath) {
        
        Set<PosixFilePermission> permissions = new HashSet<>();

        try {
            permissions = Files.getPosixFilePermissions(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return permissions;
    }

    public void setFileAttributes(String filePath, Map<String, Object> attributes) {
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            try {
                Files.setAttribute(Paths.get(filePath), entry.getKey(), entry.getValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, Object> getFileAttributes(String filePath) {
        try {
            return Files.readAttributes(Paths.get(filePath), "*");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long measureFileOperationTime(String filePath, FileOperation operation) {
        
        long start = System.nanoTime();
        try {
            Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        return end - start;
    }

    public void optimizeFileOperation(String filePath, FileOperation operation) {
        switch (operation) {
            case READ:
                try {
                    Reader reader = new FileReader(new File(filePath));
                    BufferedReader bReader = new BufferedReader(reader);
                    bReader.lines().toList();
                    bReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case WRITE:
                try {
                    Writer writer = new FileWriter(new File(filePath));
                    BufferedWriter bWriter = new BufferedWriter(writer);
                    bWriter.write('a');
                    bWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    public PerformanceMetrics getFileOperationPerformance(String filePath, FileOperation operation) {
        
        long start = System.nanoTime();

        switch (operation) {
            case READ:
                try {
                    Files.readAllBytes(Paths.get(filePath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case WRITE:
                try {
                    Files.write(Paths.get(filePath), new byte[1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        long end = System.nanoTime();

        PerformanceMetrics metrics = new PerformanceMetrics();
        metrics.addMetrics(end - start);
        return metrics;
    }
}
