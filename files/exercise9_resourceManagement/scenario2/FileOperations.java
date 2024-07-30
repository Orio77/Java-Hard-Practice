package files.exercise9_resourceManagement.scenario2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileOperations {

    // Task 1
    public String readContent(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public void writeContent(String filePath, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public boolean checkPermission(String filePath) {
        File file = Paths.get(filePath).toFile();
        return (file.canExecute() && file.canRead() && file.canWrite());
    }

    public boolean changePermission(String filePath, boolean canRead, boolean canWrite) {
        File file = Paths.get(filePath).toFile();

        return (file.setReadable(canRead) && file.setWritable(canWrite));
    }

    // Task 3
    public Map<String, Object> getFileAttributes(String filePath) {
        try {
            return Files.readAttributes(Paths.get(filePath), "*");
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public boolean updateFileAttributes(String filePath, Map<String, Object> attributes) {

        try {
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                Files.setAttribute(Paths.get(filePath), entry.getKey(), entry.getValue());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Task 4
    // AI Copied - I did not know how to use Mapped Byte Buffer
    public String readFileFast(String filePath) {
        try {
            RandomAccessFile file = new RandomAccessFile(filePath, "r");
            FileChannel fileChannel = file.getChannel();
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            byte[] data = new byte[(int) fileChannel.size()];
            buffer.get(data);
            file.close();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    // AI Copied - I did not know how to use FileChannels
    public void writeFileFast(String filePath, String content) {
        try (FileChannel fileChannel = FileChannel.open(Paths.get(filePath), StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            fileChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFileFast(String sourceFilePath, String destinationFilePath) {
        try (FileChannel sourChannel = new FileInputStream(sourceFilePath).getChannel(); 
            FileChannel destChannel = new FileOutputStream(destinationFilePath).getChannel();)
            {
                destChannel.transferFrom(sourChannel, 0, sourChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
