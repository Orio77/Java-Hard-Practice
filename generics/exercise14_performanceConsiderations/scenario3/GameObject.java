package generics.exercise14_performanceConsiderations.scenario3;

public class GameObject<T> implements IGameObject<T> {
    private int[] position;
    private int size;

    public GameObject(int[] position, int size) {
        this.position = position;
        this.size = size;
    }

    @Override
    public int[] getPosition() {
        return this.position;
    }
    public int getSize() {
        return size;
    }

    @Override
    public void update(int[] position) {
        this.position = position;
    }
}
