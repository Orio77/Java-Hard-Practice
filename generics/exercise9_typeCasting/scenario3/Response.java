package generics.exercise9_typeCasting.scenario3;

public class Response {
    private String message;
    private String status;

    public Response(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public String getStatus() {
        return status;
    }
}
