package oop.exercise14_fileIO.scenario1;

import java.util.ArrayList;

public class Directory {
    private String name;
    private ArrayList<TextFile> files;
    
    public Directory(String name) {
        this.name = name;
        files = new ArrayList<>();
    }

    public boolean addFile(TextFile file) {
        return files.add(file);
    }

    public boolean removeFile(TextFile file) {
        return files.remove(file);
    }

    public String getName() {
        return name;
    }
}
