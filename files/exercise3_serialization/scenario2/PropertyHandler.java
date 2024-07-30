package files.exercise3_serialization.scenario2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import java.util.Stack;

class Property {
    private String address;
    private String type;
    private int area;
    private String image;

    public String getAddress() {
        return address;
    }
    public int getArea() {
        return area;
    }
    public String getImage() {
        return image;
    }
    public String getType() {
        return type;
    }
}

public class PropertyHandler {
    private Stack<Exception> errorLog;

    // Task 1
    public void serializeProperty(Property property, String filePath) {
        try (
            FileOutputStream out = new FileOutputStream(new File(filePath));
            ObjectOutputStream objOut = new ObjectOutputStream(out)
        ){
            objOut.writeObject(property);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Property deserializeProperty(String filePath) {
        try (
            FileInputStream in = new FileInputStream(new File(filePath));
            ObjectInputStream objIn = new ObjectInputStream(in);
        ){
          return (Property) objIn.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 2
    public Set<PosixFilePermission> checkFilePermission(String filePath) {
        try {
            return Files.getPosixFilePermissions(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void modifyFilePermission(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 3
    public long timeSerialization(Property property, String filePath) {
        long start = System.nanoTime();
        try (
            FileOutputStream out = new FileOutputStream(new File(filePath));
            ObjectOutputStream objOut = new ObjectOutputStream(out)
        ){
            objOut.writeObject(property);
            long end = System.nanoTime();
            return end - start;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long timeDeserialization(String filePath) {
        long start = System.nanoTime();
        try (
            FileInputStream in = new FileInputStream(new File(filePath));
            ObjectInputStream objIn = new ObjectInputStream(in);
        ){
          objIn.readObject();  
          long end = System.nanoTime();
          return end - start;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Task 4
    public boolean safeSerializeProperty(Property property, String filePath) {
        try (
            FileOutputStream out = new FileOutputStream(new File(filePath));
            ObjectOutputStream objOut = new ObjectOutputStream(out)
        ){
            objOut.writeObject(property);
            return true;
        } catch (IOException e) {
            logError(e);
            return false;
        }
    }

    public Property safeDeserializeProperty(String filePath) {
        try (
            FileInputStream in = new FileInputStream(new File(filePath));
            ObjectInputStream objIn = new ObjectInputStream(in);
        ){
          return (Property) objIn.readObject();  
        } catch (IOException | ClassNotFoundException e) {
            logError(e);
            return null;
        }
    }

    public void logError(Exception e) {
        errorLog.push(e);
    }
}
