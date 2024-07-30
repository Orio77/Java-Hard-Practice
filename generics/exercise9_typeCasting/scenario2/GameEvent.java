package generics.exercise9_typeCasting.scenario2;

public class GameEvent<T extends GameAction> {
    
    public void processEvent(T gameEvent) {
        gameEvent.showAction();
    }

    public boolean isEventValid(T gameEvent) {
        return gameEvent.checkActionValidity();
    }

    public void handleEvent(T gameEvent) {
        try {
            if (isEventValid(gameEvent)){
                processEvent(gameEvent);
            }
            else {
                throw new Exception("Error during event handling");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}
