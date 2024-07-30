package generics.exercise3_wildcards.scenario3;

public class Plugin {
    private String name;
    private Object data;

    public Plugin(String name, Object data) {
        this.name = name;
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public <T> T getData() {
        return (T) data;
    }

    public String getName() {
        return name;
    }
}
