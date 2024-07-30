package oop.exercise14_fileIO.scenario1;

public class User {
    private String name;
    private FileManager manager;

    public User(String name) {
        this.name = name;
        manager = new FileManager();
    }

    public boolean createFile(String name, String content) {
        return manager.createFile(name, content);
    }

    public void editFile(String name, String newContent, boolean clear) {
        TextFile file = manager.findFile(name);

        file.write(newContent, clear);
    }

    public String getName() {
        return name;
    }
}
