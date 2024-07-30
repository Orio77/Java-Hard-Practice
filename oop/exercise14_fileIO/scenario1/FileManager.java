package oop.exercise14_fileIO.scenario1;

import java.util.ArrayList;

public class FileManager {
    private ArrayList<TextFile> files;
    private ArrayList<Directory> directories;
    
    public FileManager() {
        files = new ArrayList<>();
        directories = new ArrayList<>();
    }

    public boolean createFile(String name, String content) {
        return files.add(new TextFile(name, content));
    }

    public TextFile findFile(String name) {
        for (TextFile file : files) {
            if (file.getName().matches(name))
                return file;
        }
        return null;
    }

    public boolean createDirectory(String name) {
        return directories.add(new Directory(name));
    }

    public Directory findDirectory(String name) {
        for (Directory dir : directories) {
            if (dir.getName().matches(name))
                return dir;
        }
        return null;
    }
}
