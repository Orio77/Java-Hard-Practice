package generics.exercise9_typeCasting.scenario3;

public class TechnicalQuery extends Query{
    private Response response;

    public TechnicalQuery(String message) {
        super(message);
    }

    public Response getRespose() {
        return response;
    }

    public void respond(String message) {
        response = new Response(message, "Ready to answer");
    }
}
