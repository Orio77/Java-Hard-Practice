package generics.exercise13.scenario2;

public class EnemyAI<T extends GameState> implements Strategy<T>{

    @Override
    public void execute(T state) {
        switch (state.getPlayerState()) {
            case "Player fighting an enemy":
                System.out.println("Enemy fighting the player back");
                break;
            case "Player exploring the world":
                System.out.println("Enemy waiting for the player to engage in a combat");
                break;
            default:
                break;
        }
    }
    
}
