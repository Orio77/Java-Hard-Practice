package generics.exericse10.scenario1;

public class ContentPlugin implements Plugin<Content> {
    private String contentsName;
    private String data;

    @Override
    public void initialize(Content content) {
        this.data = content.getData();
    }

    @Override
    public void execute() {
        System.out.println(contentsName + ": " + data);
    }
    
}
