package generics.exercise9_typeCasting.scenario3;

public class GeneralQuery extends Query{
    private Response response;

    public GeneralQuery(String message) {
        super(message);
    }

    public Response getRespose() {
        return response;
    }

    public void respond(String message) {
        response = new Response(message, "Ready to answer");
    }
}
