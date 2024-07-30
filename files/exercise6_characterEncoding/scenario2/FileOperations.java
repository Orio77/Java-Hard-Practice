package files.exercise6_characterEncoding.scenario2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileOperations {

    // Task 1
    // AI Copied - I did not know how to detect encoding
    public String detectEncoding(String filePath) {
        String[] charsetToTest = {"UTF-8", "windows-1253", "ISO-8859-7"};

        Charset charset = Charset.defaultCharset();
        for (String charsetName : charsetToTest) {
            charset = Charset.forName(charsetName);
            CharsetDecoder decoder = charset.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPORT);
            decoder.onUnmappableCharacter(CodingErrorAction.REPORT);

            try (FileInputStream in = new FileInputStream(filePath);
                 InputStreamReader reader = new InputStreamReader(in, decoder);
            ){
                char[] buffer = new char[512];
                while (reader.read(buffer) != -1) {
                    
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return charset.name();
    }

    public void convertEncoding(String filePath, String targetEncoding) {
        File inputFile = new File(filePath);
        File tempFile = new File(filePath + ".tmp");

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(inputFile), Charset.defaultCharset());
             OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(tempFile), targetEncoding);
        ) {
            char[] buffer = new char[1024];
            int read;
            while ((read = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
        }
        else if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
        }
    }

    // Task 2
    public void setPermissions(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPermission(String filePath, PosixFilePermission permission) {
        try {
            return Files.getPosixFilePermissions(Paths.get(filePath)).contains(permission);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Task 3
    public Map<String, String> buildEncodingMap(String directoryPath) {
        File[] files = Paths.get(directoryPath).toFile().listFiles();
        Map<String, String> result = new HashMap<>();

        for (File file : files) {
            result.put(file.getAbsolutePath(), getEncoding(file.getAbsolutePath()));
        }

        return result;
    }

    public String getEncoding(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            byte[] bom = new byte[4];
            inputStream.read(bom);

            if (bom[0] == (byte) 0xEF && bom[1] == (byte) 0xBB && bom[2] == (byte) 0xBF) {
                return "UTF-8";
            } else if (bom[0] == (byte) 0xFE && bom[1] == (byte) 0xFF) {
                return "UTF-16BE";
            } else if (bom[0] == (byte) 0xFF && bom[1] == (byte) 0xFE) {
                return "UTF-16LE";
            } else if (bom[0] == 0 && bom[1] == 0 && bom[2] == (byte) 0xFE && bom[3] == (byte) 0xFF) {
                return "UTF-32BE";
            } else if (bom[0] == (byte) 0xFF && bom[1] == (byte) 0xFE && bom[2] == 0 && bom[3] == 0) {
                return "UTF-32LE";
            } else {
                return "Unknown";
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    // Task 4
    public void tryOpen(String filePath) throws FileNotFoundException {
        if (Paths.get(filePath).toFile() == null) {
            throw new FileNotFoundException();
        }
    }

    public void tryRead(String filePath) throws IOException {
        Files.readAllLines(Paths.get(filePath));
    }

    public void tryWrite(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }
}
