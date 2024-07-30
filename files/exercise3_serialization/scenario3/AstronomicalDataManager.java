package files.exercise3_serialization.scenario3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.AccessDeniedException;
import java.nio.file.Paths;

class AstronomicalData implements Serializable{
    private int id;
    private String name;
    private double distance;
    private double mass;
    private double radius;

    public AstronomicalData(int id, String name, double distance, double mass, double radius) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.mass = mass;
        this.radius = radius;
    }

    public AstronomicalData() {
        this(0, "Error", 0, 0, 0);
    }

    public double getDistance() {
        return distance;
    }
    public int getId() {
        return id;
    }
    public double getMass() {
        return mass;
    }
    public String getName() {
        return name;
    }
    public double getRadius() {
        return radius;
    }
}

public class AstronomicalDataManager {

    // Task 1
    public void serializeData(AstronomicalData data, String filePath)  {
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(new File(filePath)))) {
            objOut.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AstronomicalData deserializeData(String filePath) {
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(new File(filePath)))) {
            return (AstronomicalData) objIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new AstronomicalData();
        }
    }

    // Task 2
    public void serializeDataWithPermissions(AstronomicalData data, String filePath)  {
        serializeData(data, filePath);
        File file = Paths.get(filePath).toFile();
        file.setReadable(true);
        file.setWritable(true);
    }

    public AstronomicalData deserializeDataWithPermissions(String filePath, int userID) throws AccessDeniedException{
        // simulate permission check
        if (userID % 2 == 0) {
            throw new AccessDeniedException(filePath);
        }

        return deserializeData(filePath);
    }

    // Task 3
    public void serializeDataEfficiently(AstronomicalData data, String filePath)  {
        try (ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(filePath))))) {
            objOut.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AstronomicalData deserializeDataEfficiently(String filePath) {
        try (ObjectInputStream objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(filePath))))) {
            return (AstronomicalData) objIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new AstronomicalData();
        }
    }

    // Task 4
    public void serializeDataSafely(AstronomicalData data, String filePath) {
        if (data == null || filePath == null || filePath.isEmpty()) {
            return;
        }
        serializeData(data, filePath);
    }

    public AstronomicalData deserializeDataSafely(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return new AstronomicalData();
        }
        return deserializeDataSafely(filePath);
    }

    public AstronomicalData handleError(IOException e) {
        e.printStackTrace();
        return new AstronomicalData();
    }
}
