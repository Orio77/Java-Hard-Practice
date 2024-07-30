package generics.exericse10.scenario1;

public class Content {
    private String contentID;
    private String data;

    public Content(String contentID, String data) {
        this.contentID = contentID;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getContentID() {
        return contentID;
    }
}
