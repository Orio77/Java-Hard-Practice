package generics.exercise9_typeCasting.scenario2;

import java.time.LocalDateTime;

public class ObjectInteraction extends GameAction{
    private final String type = "objectInteraction";
    private String object;

    public ObjectInteraction(String object, LocalDateTime timestamp) {
        super(timestamp);
        this.object = object;
    }
    
    public String getType() {
        return type;
    }
    public String getObject() {
        return object;
    }

    @Override
    public void showAction() {
        System.out.println(object + "interacted");
    }

    @Override
    public boolean checkActionValidity() {
        if (!super.checkActionValidity() || object == null || object.isEmpty()) {
            return false;
        }
        return true;
    }
}
