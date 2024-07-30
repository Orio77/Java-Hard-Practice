package generics.exercise9_typeCasting.scenario2;

import java.time.LocalDateTime;

public abstract class GameAction {
    private String type;
    private LocalDateTime timestamp;

    public GameAction(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public boolean checkActionValidity() {
        if (type == null || type.isEmpty() || timestamp == null || (!checkTimeStampValidity())) {
            return false;
        }

        return true;
    }

    private boolean checkTimeStampValidity() {
        if (timestamp.getYear() < 2023 || timestamp.getMonthValue() <=0 || timestamp.getMonthValue() > 12 || timestamp.getHour() <= 0) { // And so on
            return false;
        }
        return true;
    }

    public abstract void showAction();
}
