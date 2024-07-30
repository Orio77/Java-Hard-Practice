package oop.exercise14_fileIO.scenario3;

public class File {
    private String name;
    private String contents;
    private String location;
    private String metadata;

    public File(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }

    public String getLocation() {
        return location;
    }
    public String getMetadata() {
        return metadata;
    }
    public String getName() {
        return name;
    }
    public String getContents() {
        return contents;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setName(String name) {
        this.name = name;
    }
}
