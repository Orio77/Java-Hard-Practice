package generics.exercise14_performanceConsiderations.scenario3;

public class Player<T> extends GameObject<T> {
    private int health;

    public Player(int[] position, int size, int health) {
        super(position, size);
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    
}
