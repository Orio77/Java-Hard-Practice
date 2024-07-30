package generics.exercise14_performanceConsiderations.scenario3;

public interface IGameObject<T> {
    
    public int[] getPosition();
    public int getSize();
    public void update(int[] position);
}
