package generics.exercise9_typeCasting.scenario2;

import java.time.LocalDateTime;

public class PlayerAction extends GameAction{
    private final String typeOfAction = "playerAction";
    private String playerNick;
    private String action;

    public PlayerAction(String playerNick, String action, LocalDateTime timestamp) {
        super(timestamp);
        this.action = action;
        this.playerNick = playerNick;
    }

    @Override
    public void showAction() {
        System.out.println(playerNick + "did" + action + "at" + getTimestamp());
    }

    @Override
    public boolean checkActionValidity() {
        if (!super.checkActionValidity()) {
            return false;
        }
        else if (playerNick == null || playerNick.isEmpty() || action == null || action.isEmpty()) {
            return false;
        }
        return true;
    }

    public String getTypeOfAction() {
        return typeOfAction;
    }
    public String getPlayerNick() {
        return playerNick;
    }
    public String getAction() {
        return action;
    }
}
