package oop.exercise14_fileIO.scenario3;

import java.util.List;

public class FileHandler {
    private List<File> files;
    
    public String readFile(String name) {
        for (File file : files) {
            if (file.getName().matches(name)) {
                return file.getContents();
            }
        }
        return null;
    }

    public void writeFile(String name, String contents, String path) {
        File file = new File(name, contents);
        file.setLocation(path);
        files.add(file);
    }

    public String readMetadata(String name) {
        for (File file : files) {
            if (file.getName().matches(name)) {
                return file.getMetadata();
            }
        }
        return null;
    }

    public boolean renameFile(String name) {
        for (File file : files) {
            if (file.getName().matches(name)) {
                file.setName(name);
                return true;
            }
        }
        return false;
    }

    public boolean deleteFile(String name) {
        for (int i = 0; i < files.size(); i++) {
            if ((files.get(i)).getName().matches(name)) {
                files.remove(i);
                return true;
            }
        }
        return false;
    }
}
