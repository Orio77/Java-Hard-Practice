package files.exercise4_exceptionHandling.scenario1;

public class ErrorLog {
    private String timestamp;
    private String errorLevel;
    private String message;

    public String getErrorLevel() {
        return errorLevel;
    }
    public String getMessage() {
        return message;
    }
    public String getTimestamp() {
        return timestamp;
    }
    
    public ErrorLog(String timestamp, String errorLevel, String message) {
        this.timestamp = timestamp;
        this.errorLevel = errorLevel;
        this.message = message;
    }

    
}
