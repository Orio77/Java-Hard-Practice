package files.exercise3_serialization.scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SecureFileTransmissionSystem {
    
    public void serializeObjectToFile(Object obj, String filePath) {
       
        try {
            FileOutputStream fileOut = new FileOutputStream(new File(filePath));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object deserializeObjectFromFile(String filePath) {
        
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(new File(filePath)))){
            return objIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setFilePermissions(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<PosixFilePermission> getFilePermissions(String filePath) {
        Set<PosixFilePermission> perms = new TreeSet<>();
        try {
            perms = Files.getPosixFilePermissions(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return perms;
    }

    public void serializeObjectsToFiles(Map<String, Object> objects, String directoryPath) {
        List<Object> objs = objects.values().stream().toList();

        for (Object object : objs) {
            try {
                FileOutputStream fileOut = new FileOutputStream(new File(directoryPath));
                ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                objOut.writeObject(object);
                fileOut.close();
                objOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, Object> deserializeObjectsFromFiles(String directoryPath) {
        
        Map<String, Object> objects = new HashMap<>();
        File dir = new File(directoryPath);

        for (File file : dir.listFiles()) {
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objIn = new ObjectInputStream(fileIn);
                objects.put(file.getName(), objIn.readObject());
                fileIn.close();
                objIn.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    public void serializeLargeObjectToFile(Object obj, String filePath) {
        
        try {
            FileOutputStream fileOut = new FileOutputStream(new File(filePath));
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(obj);
            fileOut.close();
            objOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object deserializeLargeObjectFromFile(String filePath) {
        
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(new File(filePath)))){
            return objIn.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String comparePerformance(String smallFilePath, String largeFilePath) {
        
        try {
            long smallStart = System.nanoTime();
            FileInputStream smallFileIn = new FileInputStream(new File(smallFilePath));
            ObjectInputStream smallObjIn = new ObjectInputStream(smallFileIn);
            long smallEnd = System.nanoTime();

            long smallResult = smallEnd - smallStart;
            smallFileIn.close();
            smallObjIn.close();

            long largeStart = System.nanoTime();
            FileInputStream largeFileIn = new FileInputStream(new File(largeFilePath));
            ObjectInputStream largeObjIn = new ObjectInputStream(largeFileIn);
            long largeEnd = System.nanoTime();

            long largeResult = largeEnd - largeStart;
            largeFileIn.close();
            largeObjIn.close();

            return "Deserializing the large file is slower than the small file by " + (largeResult - smallResult);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
