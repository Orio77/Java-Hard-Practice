package generics.exercise4_typeErasure.scenario2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSerializer<T> implements Serializable {
    private List<T> data;
    private T type;

    public DataSerializer() {
        data = new ArrayList<>();
    }

    // AI helped
    public void serializeData(String path) {

        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // AI helped
    public void deserializeData(String path) {

        try (FileInputStream fileIn = new FileInputStream(path)) {
            ObjectInputStream in = new ObjectInputStream(fileIn);

            System.out.println(in.readObject());
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object checkTypeAtRuntime() {
        return type.getClass();
    }

    // AI helped (I thought it would be possible to add an annotation to the destination of serialization, making the work with such file easier)
    public void annotateType(List<T> data) {
        System.out.println("The type of the data is: " + type.getClass());


    }

    public List<T> getData() {
        return Collections.unmodifiableList(data);
    }
}
