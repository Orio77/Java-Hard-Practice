package generics.exercise9_typeCasting.scenario3;

public abstract class Query {
    private String message;
    private Response response;

    public Query(String message) {
        this.message = message;
    }

    public Response getRespose() {
        return response;
    }

    public void respond(String message) {
        response = new Response(message, "Ready to answer");
    }

    public String getMessage() {
        return message;
    }
}

