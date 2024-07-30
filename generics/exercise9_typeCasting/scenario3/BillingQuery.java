package generics.exercise9_typeCasting.scenario3;

public class BillingQuery extends Query{
    private Response response;

    public BillingQuery(String message) {
        super(message);
        response = null;
    }

    public Response getRespose() {
        return response;
    }

    public void respond(String message) {
        response = new Response(message, "Ready to answer");
    }
}
