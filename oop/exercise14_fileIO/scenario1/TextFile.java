package oop.exercise14_fileIO.scenario1;

public class TextFile {
    private String name;
    private String content;

    public TextFile(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String read() {
        return content;
    }

    public void write(String newContent, boolean clearPrevious) {
        if (clearPrevious)
            this.content = newContent;
        else {
            this.content.concat(" ");
            this.content.concat(newContent);
        }
    }
    public String getName() {
        return name;
    }
}
