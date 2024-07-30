package oop.exercise6_exceptionHandling.scenario3;

public class FileDetail {
    private String path;
    private String operation;
    private String content;

    public FileDetail(String path, String operation, String content) {
        this.path = path;
        this.operation = operation;
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public String getOperation() {
        return operation;
    }
    public String getPath() {
        return path;
    }
}
