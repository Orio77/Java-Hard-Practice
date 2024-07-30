package oop.exercise6_exceptionHandling.scenario1;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public List<String> readFile(String path) {
        Path filePath = Paths.get(path);
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("File not found at: " + path);
            e.printStackTrace();
        }
        return content;
    }

    public boolean writeFile(String path, String content) {
        List<String> previousContent = readFile(path);
        try {
            Files.write(Paths.get(path), content.getBytes());
        } catch (AccessDeniedException e) {
            System.out.println("Unable to write file to: " + path);
            System.out.println("Restoring content");
            try {
                Files.write(Paths.get(path), previousContent);
            } catch (IOException ex) {
                System.out.println("Unable to restore content");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("File not found at: " + path);
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
