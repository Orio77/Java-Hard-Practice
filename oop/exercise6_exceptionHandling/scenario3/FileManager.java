package oop.exercise6_exceptionHandling.scenario3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileManager {
    
    public void openFile(String filePath) throws FileNotFoundException{
        if (checkPathCorrectness(filePath)) {
            System.out.println("Opening the file");
        }
        else {
            throw new FileNotFoundException();
        }
    }

    public void readFile(String filePath) throws IOException{
        if (checkPathCorrectness(filePath)) {
            System.out.println("Reading the file");
        }
        else {
            throw new IOException();
        }
    }

    public void writeFile(String filePath, String content) throws IOException{
        if (checkPathCorrectness(filePath)) {
            System.out.println("Writing the file");
        }
        else {
            throw new IOException();
        }
    }

    public void closeFile(String filePath) throws IOException{
        if (checkPathCorrectness(filePath)) {
            System.out.println("Closing the file");
        }
        else {
            throw new IOException();
        }
    }

    public void manageFile(String filePath, String operation, String content) throws IOException{
        switch (operation.toLowerCase()) {
            case "open":
                try {
                    openFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    throw new FileNotFoundException();
                }
                break;
            case "close":
                try {
                    closeFile(filePath);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    throw new IOException();
                }
                break;
            case "read":
                try {
                    readFile(filePath);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    throw new IOException();
                }
                break;
            case "write":
                try {
                    writeFile(filePath, content);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    throw new IOException();
                }
                break;
            default:
                break;
        }
    }

    private boolean checkPathCorrectness(String path) {
        return simulatePathChecking(path);
    }

    private boolean simulatePathChecking(String path) {
        if (path.hashCode() % 2 == 0)
            return true;
        return false;
    }

    public boolean isEligibleForWrite(File file) {
        return simulateFileForWriteEligibility(file);
    }

    private boolean simulateFileForWriteEligibility(File file) {
        return (file.hashCode() % 2 == 0);
    }
}
