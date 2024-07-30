package files.exercise6_characterEncoding.scenario1;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class PatientRecordSystem {

    // AI Copied - I did not know how to handle encodings
    public void decodeFile(String inputFilePath, String outputFilePath, Charset inputEncoding, Charset outputEncoding) {
        
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(inputFilePath));
            String content = new String(encoded, inputEncoding);

            byte[] decoded = content.getBytes(outputEncoding);
            Files.write(Paths.get(outputFilePath), decoded);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // AI Copied
    public boolean verifyEncoding(String filePath, Charset encoding) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filePath));
            String content = new String(encoded, encoding);
            return Arrays.equals(encoded, content.getBytes(encoding));
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void decodeFileWithPermissions(String inputFilePath, String outputFilePath, Charset inputEncoding, Charset outputEncoding, Set<PosixFilePermission> permissions) {
        
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(inputFilePath));
            String content = new String(encoded, inputEncoding);

            byte[] decoded = content.getBytes(outputEncoding);

            Files.write(Paths.get(outputFilePath), decoded);
            Files.setPosixFilePermissions(Paths.get(outputFilePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeFilePermissions(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decodeFileWithAttributes(String inputFilePath, String outputFilePath, Charset inputEncoding, Charset outputEncoding, Map<String, Object> attributes) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath), inputEncoding)) {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath), outputEncoding);

            String line;
            while ((line = reader.readLine()) != null) {
                for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                    line = line.replace(entry.getKey(), entry.getValue().toString());
                }
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeFileAttributes(String filePath, Map<String, Object> attributes) {
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            try {
                Files.setAttribute(Paths.get(filePath), entry.getKey(), entry.getValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // AI Copied
    public void decodeFileWithChannels(String inputFilePath, String outputFilePath, Charset inputEncoding, Charset outputEncoding) {
        try (
            FileInputStream fileIn = new FileInputStream(inputFilePath);
            FileOutputStream fileOut = new FileOutputStream(outputFilePath);
            FileChannel inputChannel = fileIn.getChannel();
            FileChannel outChannel = fileOut.getChannel();
        ){
            ByteBuffer inputBuffer = ByteBuffer.allocateDirect(1024);
            CharBuffer charBuffer;
            ByteBuffer outputBuffer;

            while (inputChannel.read(inputBuffer) != -1) {
                inputBuffer.flip();
                charBuffer = inputEncoding.decode(inputBuffer);
                outputBuffer = outputEncoding.encode(charBuffer);
                outChannel.write(outputBuffer);
                inputBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // AI Copied
    public void copyFileWithChannels(String inputFilePath, String outputFilePath) {
        try (
            FileChannel srcChannel = new FileInputStream(inputFilePath).getChannel();
            FileChannel destChannel = new FileOutputStream(outputFilePath).getChannel();
            ) {
                
                destChannel.transferFrom(srcChannel, 0, srcChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // AI Copied
    public boolean verifyFileContentWithChannels(String filePath, String expectedContent, Charset encoding) {
        
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                return false;
            }

            try (
                FileChannel fileChannel = FileChannel.open(path);
            ) {

                ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size());

                fileChannel.read(buffer);
                buffer.flip();
                String fileContent = encoding.decode(buffer).toString();
                return fileContent.equals(expectedContent);
                
            } 

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
