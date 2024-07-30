package generics.exercise14_performanceConsiderations.scenario3;

import java.util.ArrayList;
import java.util.List;

public class Renderer<T extends GameObject<?>> extends GameObjectCollection<T>{
    private List<T> objects;

    public Renderer() {
        objects = new ArrayList<>();
    }

    public void render(T object) {
        objects.add(object);
    }
}
