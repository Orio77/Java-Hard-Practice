package generics.exercise14_performanceConsiderations.scenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GameObjectCollection<T extends GameObject<?>> implements Iterable<GameObject<?>>{
    private List<GameObject<?>> gameObjects;

    public GameObjectCollection() {
        gameObjects = new ArrayList<>();
    }

    public boolean addGameObject(T GameObject) {
        return gameObjects.add(GameObject);
    }

    public boolean removeGameObject(T gameObject) {
        return gameObjects.remove(gameObject);
    }

    public List<GameObject<?>> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }

    @Override
    public Iterator<GameObject<?>> iterator() {
        return gameObjects.iterator();
    }


    
}
